package ToolPackage;

import java.time.LocalDate;

public class ToolRunnerMain {

	public static void main(String[] args) {
		 LocalDate checkoutDate = LocalDate.of(2023, 8, 13);
	     Chainsaw chainsaw = new Chainsaw();
	     Checkout checkout = new Checkout(chainsaw, 3, 10, checkoutDate);
	     checkout.printReceipt();
	     
	     System.out.println("");
	     
	     LocalDate ladderCheckoutDate = LocalDate.of(2023, 8, 20);
	     Ladder ladder = new Ladder();
	     Checkout checkoutLadder = new Checkout(ladder, 8, 0, ladderCheckoutDate);
	     checkoutLadder.printReceipt();
	}

}
