package com.murtll.springdemo.controller;

import com.murtll.springdemo.entity.Customer;
import com.murtll.springdemo.service.CustomerService;
import com.murtll.springdemo.service.EmailService;
import com.murtll.springdemo.utils.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    EmailService emailService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(name = "search", defaultValue = "") String search) {

        List<Customer> customers;

        if (search == null || search.equals("")) {
            customers = customerService.getCustomers();
        } else {
            customers = customerService.getMatchingCustomers(search);
        }

        model.addAttribute("customers", customers);
        return "customers";

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

    @GetMapping("/send-mail")
    public String showMailForm(Model model, @RequestParam("id") int id) {

//        retrieve customer from db
        Customer customer = customerService.getCustomerById(id);

//        create message

        EmailModel mailModel = new EmailModel();
        mailModel.setFrom("esskeetiter@gmail.com");
        mailModel.setTo(customer.getEmail());

/*
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("MailSender");
        message.setTo(customer.getEmail());
*/

//        add customer and message to model
        model.addAttribute("customer", customer);
        model.addAttribute("mailModel", mailModel);

//        return view
        return "mail-form";

    }

    @PostMapping(value = "/send-mail", headers = "content-type=multipart/*")
    public String sendMessage(Model model,
                              @ModelAttribute("mailModel") EmailModel emailModel,
                              @RequestParam("file") MultipartFile file) {

        if (file != null)
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                String name = file.getOriginalFilename();

                File uploadedFile = new File(name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));

                stream.write(bytes);
                stream.flush();
                stream.close();

                if (!emailService.sendMimeMessage(emailModel, uploadedFile)) {
                    return "error";
                }

                uploadedFile.delete();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (!emailService.sendMimeMessage(emailModel)) {
                return "error";
            }
        }

        return "redirect:/customer/list";

    }
}
