package ToolPackage;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class CheckoutTest {

	@Test
    public void testTotalRentalCostChainsaw() {
        Chainsaw chainsaw = new Chainsaw();
        LocalDate checkoutDate = LocalDate.of(2023, 8, 13);
        Checkout checkout = new Checkout(chainsaw, 3, 10, checkoutDate);
        double cost = checkout.totalRentalCost();
        assertEquals(5.36, cost, 0.01);
    }
	
	@Test
    public void testTotalRentalCostChainsawNoDiscount() {
        Chainsaw chainsaw = new Chainsaw();
        LocalDate checkoutDate = LocalDate.of(2023, 8, 13);
        Checkout checkout = new Checkout(chainsaw, 3, 0, checkoutDate);
        double cost = checkout.totalRentalCost();
        assertEquals(5.96, cost, 0.01);
    }

    @Test
    public void testTotalRentalCostLadder() {
        Ladder ladder = new Ladder();
        LocalDate checkoutDate = LocalDate.of(2023, 8, 20);
        Checkout checkout = new Checkout(ladder, 8, 0, checkoutDate);
        double cost = checkout.totalRentalCost();
        assertEquals(17.91, cost, 0.01);
    }
    
    @Test
    public void testChainsawHolidayDiscount() {
        Chainsaw chainsaw = new Chainsaw();
        LocalDate checkoutDate = LocalDate.of(2023, 9, 4);
        Checkout checkout = new Checkout(chainsaw, 2, 10, checkoutDate);
        double cost = checkout.totalRentalCost();

        // Chainsaw has an additional charge for rentals on the first Monday in September
        assertEquals(4.02, cost, 0.01); 
    }

    @Test
    public void testLadderHolidayNoDiscount() {
        Ladder ladder = new Ladder();
        LocalDate checkoutDate = LocalDate.of(2023, 7, 3);
        Checkout checkout = new Checkout(ladder, 2, 0, checkoutDate);
        double cost = checkout.totalRentalCost();

        // Ladder has no additional charge for holidays
        assertEquals(5.97, cost, 0.01); 
    }

    @Test
    public void testJackhammerIndependenceDayDiscount() {
        Jackhammer jackhammer = new Jackhammer("JACKD");
        LocalDate checkoutDate = LocalDate.of(2023, 7, 3);
        Checkout checkout = new Checkout(jackhammer, 2, 10, checkoutDate);
        double cost = checkout.totalRentalCost();

        // Jackhammer (DeWalt) has a discount for rentals on Independence Day
        assertEquals(8.07, cost, 0.01); 
    }

    @Test
    public void testJackhammerRidgidNoHolidayDiscount() {
        Jackhammer jackhammer = new Jackhammer("JACKR");
        LocalDate checkoutDate = LocalDate.of(2023, 9, 4);
        Checkout checkout = new Checkout(jackhammer, 1, 0, checkoutDate);
        double cost = checkout.totalRentalCost();

        // Jackhammer (Ridgid) has no additional charge for holidays
        assertEquals(5.98, cost, 0.01); 
    }

}
