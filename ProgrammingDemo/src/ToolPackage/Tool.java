package ToolPackage;

import java.time.DayOfWeek;
import java.time.LocalDate;

abstract class Tool {
    protected String code;
    protected String type;
    protected String brand;
    protected int totalRentalDays;
    protected int countChargeDays;
    protected double totalCost;
    protected double discountPercentage;
    protected double dailyRentalCharge;
    protected double preDiscountTotal;
    protected LocalDate startRentalDate;
    protected LocalDate endRentalDate;

    public Tool(String code, String type, String brand, double dailyRentalCharge) {
        this.code = code;
        this.type = type;
        this.brand = brand;
        this.dailyRentalCharge = dailyRentalCharge;
    }

    public double rentalCost(LocalDate startDate, LocalDate endDate, boolean applyDiscount, double discount) {
        int totalDays = (int) startDate.until(endDate).getDays() + 1; // Including both start and end dates
        
        // Starting date, ending date, and total rental dates
        this.startRentalDate = startDate;
        this.endRentalDate = endDate;
        this.totalRentalDays = totalDays;

        if (type.equals("Ladder")) {
            // Check if any of the rental days are weekends
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    dailyRentalCharge = 1.99;
                }
                this.countChargeDays += 1;
            }
        }
        
        if (type.equals("Chainsaw")) {
        	// Check if any of the rental days are Holidays
        	for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
        		if (date.getMonthValue() == 7 && date.getDayOfMonth() == 4) {
        			if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
        				startDate = startDate.minusDays(1);
        			}
        			else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
        				startDate = startDate.plusDays(1);
        			}
        		}
        		
        		if (date.getMonthValue() == 9 && date.getDayOfWeek() == DayOfWeek.MONDAY && date.getDayOfMonth() <= 7) {
        			dailyRentalCharge += 1.49;
        		}
        		this.countChargeDays += 1;
        	}
        }

        // Calculate total cost based on the original dailyRentalCharge
        preDiscountTotal = totalDays * dailyRentalCharge;
        setPreDiscountTotal(preDiscountTotal);

        if (applyDiscount) {
            // Apply the provided discount percentage
            double discountAmount = preDiscountTotal * (discount / 100.0);
            totalCost = preDiscountTotal - discountAmount;
        } else {
            totalCost = preDiscountTotal; // No discount applied
        }


        // Round up to nearest hundredth cent
        totalCost = Math.round(totalCost * 100.0) / 100.0;

        return totalCost;
    }

	public int getCountChargeDays() {
		return countChargeDays;
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}
    
    public double getPreDiscountTotal() {
		return preDiscountTotal;
	}

	public void setPreDiscountTotal(double preDiscountTotal) {
		this.preDiscountTotal = preDiscountTotal;
	}

	public int getTotalRentalDays() {
    	return this.totalRentalDays;
    }
    
	/*
	 * public void printToolDetails() { System.out.println("Tool Code: " + code);
	 * System.out.println("Tool Type: " + type); System.out.println("Brand: " +
	 * brand); System.out.println("Rental Start Date: " + getStartRentalDate());
	 * System.out.println("Rental End Date: " + getEndRentalDate());
	 * System.out.println("Total Rental Days: " + getTotalRentalDays() + " day/s");
	 * System.out.println("Daily Rental Charge: $" + dailyRentalCharge); }
	 */
}