package ToolPackage;

import java.time.LocalDate;

public class Jackhammer extends Tool {
    private double totalCost;
    private double discountAmount;

    public Jackhammer(String code) {
        super(code, "Jackhammer", getBrandFromCode(code), 2.99);
    }

    private static String getBrandFromCode(String code) {
        if (code.equals("JACKD")) {
            return "DeWalt";
        } else if (code.equals("JACKR")) {
            return "Ridgid";
        } else {
            return "Invalid Code Entered.";
        }
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
