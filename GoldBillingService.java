package Billing;

public class GoldBillingService extends BillingService {

	@Override
	public double discountRate() {
		double discountRate = 0.15;
		System.out.println("Discount applied: " + (discountRate * 100) + "%");
		return discountRate;
	}
	
	public void exchangePointsForGifts() {
		System.out.println("Gift options: 500 points - Gift A; 1000 points - Gift B");
	}
	
}
