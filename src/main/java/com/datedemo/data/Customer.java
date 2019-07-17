package com.datedemo.data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Customer implements Serializable {

	private String fromDate;
	
	private String toDate;
	
	private String dateDiff;

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getDateDiff() {
		return dateDiff;
	}

	public void setDateDiff(String dateDiff) {
		this.dateDiff = dateDiff;
	}

	@Override
	public String toString() {
		return "Customer [fromDate=" + fromDate + ", toDate=" + toDate + ", dateDiff=" + dateDiff + "]";
	}
	
	

}