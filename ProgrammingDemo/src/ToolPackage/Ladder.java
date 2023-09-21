package ToolPackage;

import java.time.LocalDate;

public class Ladder extends Tool{
	private double totalCost;
	private double discountAmount;
	
	public Ladder() {
		super("LADW", "Ladder", "Werner", 1.99);
	}
	
	@Override
	public double rentalCost(LocalDate startDate, LocalDate endDate, boolean applyDiscount, double discount) {
		totalCost = super.rentalCost(startDate, endDate, applyDiscount, discount);
		this.discountAmount = discount;
		return totalCost;
	}

	/*
	 * @Override public void printToolDetails() { super.printToolDetails();
	 * System.out.println("Discount Applied: $" + discountAmount + "%");
	 * System.out.println("Total Rental Cost: $" + totalCost); }
	 */
}
