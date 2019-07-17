package com.datedemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.datedemo.data.Customer;
import com.datedemo.util.DateUtil;
import com.datedemo.validator.DateValidator;

import javax.validation.Valid;

@Controller
public class CustomerController {

	@Autowired
	private DateValidator dateValidator;
	
	@Autowired
	private DateUtil dateUtil;
	
	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(dateValidator);
	}
	
    @GetMapping("/customer")
    public String getCustomer(final Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping("/customer")
    public String createCustomer(@Valid Customer customer, BindingResult bindingResult,Model model){

        if(bindingResult.hasErrors()){
            return "customer";
        }
        long difference = 0;
        difference = dateUtil.computeDateDiff(customer.getFromDate(), customer.getToDate());
        
        if(difference < 0) {
        	customer.setDateDiff("");
        }else {
        	customer.setDateDiff(String.valueOf(difference));
        }
        
        model.addAttribute("msg", "Customer added");
        model.addAttribute("customer", customer);
        return "customer";
    }

}
