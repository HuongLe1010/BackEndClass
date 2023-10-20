package Billing;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// staff will check membership card then input membership type before billing
		Scanner scanner = new Scanner (System.in);
		System.out.println("What is customer's membership type?");
		String membershipType = scanner.nextLine();
		
		BillingService service = BillingService.getMembership(membershipType);
		
		double discount = service.discountRate();
		double sum = 1000000;
		double bill = service.totalBill(sum, discount);
		System.out.println("Your total bill is: " + bill);
		double point = service.accumulatedPoint(sum);
		System.out.println("Your accumulated point is: " + point);
		
		if (service instanceof GoldBillingService) {
	        GoldBillingService goldService = (GoldBillingService) service;
	        goldService.exchangePointsForGifts();
	    }
		
		service.thankYouMessage();
	}

}
