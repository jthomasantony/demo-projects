package com.datedemo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.datedemo.data.Customer;
import com.datedemo.util.DateUtil;

/**
 * 
 * @author Thomas Antony
 *
 */
@Component
public class DateValidator implements Validator{
	@Autowired
	private DateUtil dateUtil;

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}
	
	/**
	 * Method to validate start date, end date
	 * if start date is greater than end date throws error message
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer)target;
		
		if(null == customer.getFromDate()  || customer.getFromDate() == "") {
			errors.rejectValue("fromDate", "start.date.not.empty");
		}
		
		if(null == customer.getToDate()  || customer.getToDate() == "") {
			errors.rejectValue("toDate", "end.date.not.empty");
		}
		
		if(null != customer.getFromDate()  && customer.getFromDate() != ""
				&& null != customer.getToDate()  && customer.getToDate() != "") {
			long difference=0;
			difference=dateUtil.computeDateDiff(customer.getFromDate(), customer.getToDate());
			if(difference < 0) {
				errors.rejectValue("toDate", "endDate.not.valid");
			}
			
		}
	}
	
}
