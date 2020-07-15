package com.murtll.springdemo.controller;

import com.murtll.springdemo.entity.Customer;
import com.murtll.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "search", defaultValue = "") String search) {

        try {
            //        get customers
            List<Customer> customers;
//        add data to model

            if (search == null || search.equals("")) {
                customers = customerService.getCustomers();
            } else {
                customers = customerService.getMatchingCustomers(search);
            }

            model.addAttribute("customers", customers);
            return "customers";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/add")
    public String showForm(Model model) {

//        add customer object to bind form data
        model.addAttribute("customer", new Customer());

        return "form";
    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {

        if (result.hasErrors()) {
            return "form";
        } else {
//        save customer
            customerService.saveCustomer(customer);

            return "redirect:/customer/list";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int id) {

//        delete customer
        customerService.deleteCustomerById(id);

        return "redirect:/customer/list";

    }

    @GetMapping("/update")
    public String showUpdateForm(Model model, @RequestParam("id") int id) {

        Customer customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);

        return "form";

    }
}
