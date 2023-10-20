package Billing;

public abstract class BillingService {

	public abstract double discountRate();
	
	
	public double totalBill(double sum, double discountRate) {
		return sum - (sum * discountRate);
	};
	
	public double accumulatedPoint(double sum) {
		return sum/100;
	};
	
	public void thankYouMessage() {
		System.out.println("Thank you for shopping with us. See you next time");
	};
	
	public static BillingService getMembership(String membershipType) {
		switch(membershipType) {
		case "Gold":{
			return new GoldBillingService();
		}
		case "Silver":{
			return new SilverBillingService();
		}
		case "Bronze":{
			return new BronzeBillingService();
		}
		case "NonMember":{
			return new NonMemberBillingService();
		}
		}
		return null;
		
	}

}
