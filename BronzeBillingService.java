package Billing;

public class BronzeBillingService extends BillingService{

	@Override
	public double discountRate() {
		double discountRate = 0.05;
		System.out.println("Discount applied: " + (discountRate * 100) + "%");
		return discountRate;
	}

}
