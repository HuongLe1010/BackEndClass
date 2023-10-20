package Billing;

public class SilverBillingService extends BillingService {

	@Override
	public double discountRate() {
		double discountRate = 0.10;
		System.out.println("Discount applied: " + (discountRate * 100) + "%");
		return discountRate;
	}
	
}
