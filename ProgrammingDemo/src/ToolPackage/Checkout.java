package ToolPackage;

import java.time.LocalDate;

public class Checkout {
	private Tool tool;
	private int rentalDayCount;
	private double discount;
	private LocalDate dueDate;
	private LocalDate checkoutDate;
	
	public Checkout(Tool tool, int rentalDayCount, double discount, LocalDate checkoutDate) {
		this.tool = tool;
        this.rentalDayCount = rentalDayCount;
        this.discount = discount;
        this.checkoutDate = checkoutDate;
        this.dueDate = checkoutDate.plusDays(rentalDayCount);
	}
	
	public double totalRentalCost() {
		try {
			if (rentalDayCount < 1) {
	            throw new IllegalArgumentException("Rental day count must be at least 1.");
	        }
			
	        if (discount < 0 || discount > 100) {
	            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
	        }
	        
	        dueDate = checkoutDate.plusDays(rentalDayCount);
	        return tool.rentalCost(checkoutDate, dueDate, true, discount);
	    } catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	        return -1; // Error occurred.
	    }
	}
	
	public void printReceipt() {
		double totalCost = tool.rentalCost(checkoutDate, dueDate, false, discount);
		tool.setPreDiscountTotal(totalCost);
		System.out.println("Tool Code: " + tool.getCode());
		System.out.println("Tool Type: " + tool.getType());
		System.out.println("Tool Brand: " + tool.getBrand());
		System.out.println("Rental Days: " + rentalDayCount);
		System.out.println("Checkout Date: " + checkoutDate);
		System.out.println("Due Date: " + dueDate);
		System.out.println("Daily Rental Charge: $" + tool.dailyRentalCharge);
		System.out.println("Chargeable Days: " + tool.getCountChargeDays());
		
		System.out.println("Discount Percent: " + discount + "%");
		System.out.println("Pre-Discount Total: $" + tool.getPreDiscountTotal());
		System.out.println("Final Charge: $" + totalRentalCost());
	}

}
