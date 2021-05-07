package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.*;
import com.app.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class PurchaseController {
    private ProductService productService;
    private PurchaseService purchaseService;
    private UserService userService;
    private ProductPurchaseService productPurchaseService;
    private CategoryService categoryService;

    @Autowired
    public PurchaseController(ProductService productService,
                              PurchaseService purchaseService,
                              UserService userService,
                              ProductPurchaseService productPurchaseService,
                              CategoryService categoryService) {
        this.productService = productService;
        this.purchaseService = purchaseService;
        this.userService = userService;
        this.productPurchaseService = productPurchaseService;
        this.categoryService = categoryService;
    }

    @PostMapping("/purchase")
    public String processPurchase(@RequestParam Long[] productId,
                                        @RequestParam Integer[] quantity,
                                        @SessionAttribute("userId") Long userId) {
        Set<ProductPurchase> productPurchases = new HashSet();
        double total = 0;

        for(int index = 0; index < productId.length; index++) {
            Integer tempQuantity = quantity[index];

            if (tempQuantity != null && tempQuantity > 0) {
                Product tempProduct = productService.findById( productId[index] );

                ProductPurchase productPurchase = new ProductPurchase();
                productPurchase.setQuantity(tempQuantity);
                productPurchase.setProduct(tempProduct);

                productPurchases.add(productPurchase);

                total += tempProduct.getPrice() * tempQuantity;
            }
        }

        Purchase purchase = new Purchase();
        purchase.setUser( userService.findById(userId) );
        purchase.setDate( LocalDate.now() );
        purchase.setTotal(total);

        //Save Purchase entity
        final Purchase newPurchase = purchaseService.save(purchase);

        //Populate & Save ProductPurchase entities
        productPurchases.forEach(productPurchase -> {
            productPurchase.setPurchase(newPurchase);

            ProductPurchaseKey productPurchaseKey = new ProductPurchaseKey();
            productPurchaseKey.setProductId(productPurchase.getProduct().getId());
            productPurchaseKey.setPurchaseId(productPurchase.getPurchase().getId());

            productPurchase.setId(productPurchaseKey);

            productPurchaseService.save(productPurchase);
        });

        return "redirect:/user?id=" + userId;
    }

    @GetMapping("/purchases")
    public ModelAndView viewPurchases(@RequestParam Long userId) {
        ModelAndView modelAndView = new ModelAndView("purchases");
        modelAndView.addObject(  "purchases", purchaseService.findAllByUser( userService.findById(userId) ) );
        return modelAndView;
    }

    @GetMapping("/purchase_report")
    public ModelAndView viewPurchaseReport(@RequestParam(required = false) String dateFilter,
                                           @RequestParam(required = false) Long categoryId) {
        ModelAndView modelAndView = new ModelAndView("purchase_report");
        List<Purchase> purchaseList;

        if( dateFilter != null && !dateFilter.isEmpty() ) {
            purchaseList = purchaseService.findByDate(dateFilter);
        } else {
            purchaseList = purchaseService.findAll();
        }

        if(categoryId != null && categoryId > 0) {
            modelAndView.addObject(  "purchases", filterByCategory(purchaseList, categoryId) );
        } else {
            modelAndView.addObject(  "purchases", purchaseList );
        }

        modelAndView.addObject(  "categories", categoryService.findAll() );

        return modelAndView;
    }

    private List<Purchase> filterByCategory(List<Purchase> purchaseList, Long categoryId) {
        List<Purchase> filteredPurchases = new ArrayList();
        Category category = categoryService.findById(categoryId);

        purchaseList.forEach( purchase -> {
            Set<ProductPurchase> filteredProductPurchases = new HashSet();

            purchase.getProductPurchases().forEach(productPurchase -> {
                if( category.equals( productPurchase.getProduct().getCategory() ) ) {
                    filteredProductPurchases.add(productPurchase);
                }
            });

            if( !filteredProductPurchases.isEmpty() ) {
                purchase.setProductPurchases(filteredProductPurchases);
                filteredPurchases.add(purchase);
            }
        });

        return filteredPurchases;
    }
}
