package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Admin;
import com.app.model.Login;
import com.app.service.AdminService;

@Controller
@SessionAttributes("adminId")
public class AdminController {
    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/admin")
    public ModelAndView login(@ModelAttribute Login login, Model model,
                              @ModelAttribute("adminId") Long adminId) {
        ModelAndView modelAndView = null;
        Admin admin = adminService.findByUsernameAndPassword(login.getUsername(), login.getPassword());

        if (admin != null) {
            modelAndView = new ModelAndView("redirect:/admin?id=" + admin.getId());
            modelAndView.addObject("admin", admin);
            // Store admin id in session
            model.addAttribute("adminId", admin.getId());
        } else {
            modelAndView = new ModelAndView("redirect:/");
        }

        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView login(@RequestParam Long id) {
        Admin admin = adminService.findById(id);
        ModelAndView result = new ModelAndView("admin");
        result.addObject("admin", admin);
        return result;
    }

    @RequestMapping("/admin/edit")
    public ModelAndView editAdmin(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("edit_password");
        Admin user = adminService.findById(id);
        modelAndView.addObject("admin", user);
        return modelAndView;
    }

    @RequestMapping(value="/admin/updatePassword", method= RequestMethod.POST)
    public String updatePassword(@ModelAttribute("admin") Admin admin){
        Admin newEntity = adminService.updatePassword(admin.getId(), admin.getLogin().getPassword());
        return "redirect:/admin?id=" + newEntity.getId();
    }

    @ModelAttribute("adminId")
    public Long adminId() {
        return new Long(0);
    }
}
