package ToolPackage;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class ToolTest {

	@Test
    public void testRentalCostChainsaw() {
        Chainsaw chainsaw = new Chainsaw();
        LocalDate startDate = LocalDate.of(2023, 8, 13);
        LocalDate endDate = LocalDate.of(2023, 8, 16);
        double cost = chainsaw.rentalCost(startDate, endDate, true, 10);
        assertEquals(4.02, cost, 0.01); // Assuming the delta is 0.01 for rounding issues
    }
	
	@Test
	public void testRentalCostLadder() {
	    Ladder ladder = new Ladder();
	    LocalDate startDate = LocalDate.of(2023, 8, 20);
	    LocalDate endDate = LocalDate.of(2023, 8, 28);
	    double cost = ladder.rentalCost(startDate, endDate, false, 0);
	    assertEquals(15.92, cost, 0.01); // Assuming the delta is 0.01 for rounding issues
	}

    @Test
    public void testRentalCostJackhammer() {
        Jackhammer jackhammer = new Jackhammer("JACKD");
        LocalDate startDate = LocalDate.of(2023, 8, 13);
        LocalDate endDate = LocalDate.of(2023, 8, 16);
        double cost = jackhammer.rentalCost(startDate, endDate, true, 10);
        assertEquals(2.99, cost, 0.01); // Assuming the delta is 0.01 for rounding issues
    }

}
