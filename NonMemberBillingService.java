package Billing;

public class NonMemberBillingService extends BillingService {

	@Override
	public double discountRate() {
		System.out.println("No discount is applied");
		return 0;
	}

}
