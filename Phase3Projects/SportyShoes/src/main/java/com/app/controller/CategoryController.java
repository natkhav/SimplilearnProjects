package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Category;
import com.app.model.Product;
import com.app.service.CategoryService;

import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ModelAndView viewAllCategories() {
        ModelAndView modelAndView = new ModelAndView("categories");
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @RequestMapping("/new_category")
    public String newCategoryForm(ModelMap map) {
        Category category = new Category();
        map.addAttribute("category", category);
        return "new_category";
    }

    @GetMapping("/category/edit")
    public ModelAndView editCategory(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("edit_category");
        modelAndView.addObject("category", categoryService.findById(id));

        return modelAndView;
    }

    @PostMapping(value = "/save_category")
    public String saveCategory(@RequestParam(value="id", required = false) Long id,
                               @RequestParam(value="name") String name,
                               @SessionAttribute("adminId") Long adminId) {
        Category category = new Category();
        if (id != null) {
            category.setId(id);
        }
        category.setName(name);

        categoryService.save(category);

        return "redirect:/admin?id=" + adminId;
    }
}
