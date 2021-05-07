package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Category;
import com.app.model.Product;
import com.app.service.CategoryService;
import com.app.service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/product/edit")
    public ModelAndView productEdit(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_product");

        modelAndView.addObject("product", productService.findById(id));
        modelAndView.addObject( "categories", categoryService.findAll());

        return modelAndView;
    }

    @RequestMapping("/new_product")
    public String newProductForm(ModelMap map) {
        Product product = new Product();
        List<Category> categories = categoryService.findAll();

        map.addAttribute("product", product);
        map.addAttribute("categories", categories);
        return "new_product";
    }

    @PostMapping(value = "/save_product")
    public String saveProduct(@RequestParam(value="id", required = false) Long id,
                              @RequestParam(value="name") String name,
                              @RequestParam(value="price") Double price,
                              @RequestParam(value="categoryId") Long categoryId,
                              @SessionAttribute("adminId") Long adminId) {
        Product product = new Product();
        if (id != null) {
            product.setId(id);
        }
        product.setCategory(categoryService.findById(categoryId));
        product.setName(name);
        product.setPrice(price);

        productService.save(product);

        return "redirect:/admin?id=" + adminId;
    }

    @RequestMapping("/product/delete")
    public String deleteCustomer(@RequestParam Long id){
        productService.deleteById(id);
        return "redirect:/products";
    }
}
