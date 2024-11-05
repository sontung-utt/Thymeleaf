package com.codegym.thymeleaf.controller;

import com.codegym.thymeleaf.model.Customer;
import com.codegym.thymeleaf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
//Có nhiệm vụ ánh xạ đến URL, khai báo tham số của Request(Http req, http resp)
//Để phát hiện tự động Controller, cần khai báo @ComponentScan (trong AppConfiguration)
@RequestMapping("/customers")
//Ánh xạ các req tới các action tương ứng của controller
public class CustomerController {
    private final CustomerService customerService;
//private ICustomerService customerService = new CustomerService();

    /*@Autowired
    Tiêm qua thuộc tính
    private CustomerService customerService;
    */

    /*
    Tiêm qua constructor
     */
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*
    Tiêm qua setter
    private CustomerService customerService;
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }*/

    @GetMapping("/list")
    public ModelAndView listCustomers(){
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers",customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEditForm(HttpServletRequest req, @RequestParam int id) {
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("/customer/add");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute Customer customer){
        int id = (int) (Math.random() * 10000);
        customer.setId(id);
        customerService.add(customer);
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers",customerService.findAll());
//        return modelAndView;
        return "redirect:/customers/list";
    }

    @PostMapping("/edit")
    public String editCustomer(@RequestParam int id,@ModelAttribute Customer customer) {
        customerService.update(id,customer);
        return "redirect:/customers/list";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam int id){
        customerService.remove(id);
        return "redirect:/customers/list";
    }
}

