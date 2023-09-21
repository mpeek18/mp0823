package ToolPackage;

import java.time.LocalDate;

public class Chainsaw extends Tool {
    private double totalCost;

    public Chainsaw() {
        super("CHNS", "Chainsaw", "Stihl", 1.49);
    }

    @Override
    public double rentalCost(LocalDate startDate, LocalDate endDate, boolean applyDiscount, double discount) {
        totalCost = super.rentalCost(startDate, endDate, applyDiscount, discount);
        return totalCost;
    }

	/*
	 * @Override public void printToolDetails() { super.printToolDetails();
	 * System.out.println("Discount Applied: $" + discountAmount + "%");
	 * System.out.println("Total Rental Cost: $" + totalCost); }
	 */
}