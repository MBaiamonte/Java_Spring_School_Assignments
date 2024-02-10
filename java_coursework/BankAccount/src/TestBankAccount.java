
public class TestBankAccount {
	public static void main(String[] args) {
		BankAccount mattsAccount=new BankAccount(10.50, 300.50);
		BankAccount lizsAccount=new BankAccount(150.50, 1020.50);
		BankAccount ronsAccount=new BankAccount(1000.50, 1001.50);
		
		//Initial total in all accounts
		System.out.println("<<Initial total in all accounts>>");
		System.out.println(BankAccount.getAllAccountsTotal());
		
		//<<get method test>>
		System.out.println("<<get method test>>");
		System.out.println(mattsAccount.getCheckingBalance()+ " Get checking method check");
		System.out.println(mattsAccount.getSavingsBalance()+ " Get savings method check");
		
		//<<deposit Method check>>
		System.out.println("<<deposit Method check>>");
		mattsAccount.depositIntoAnAccount(10, "savingsAccount");
		System.out.println(mattsAccount.getSavingsBalance()+ " Get savings method check");
		mattsAccount.depositIntoAnAccount(12, "checkingAccount");
		System.out.println(mattsAccount.getCheckingBalance()+ " Get checking method check");
		
		
		
		//withdraw Method check savings
		System.out.println("<<withdraw Method check for savings>>");
		mattsAccount.withdrawFromAccount(1, "savings");
		System.out.println(mattsAccount.getSavingsBalance()+ " Get savings method check");
		mattsAccount.withdrawFromAccount(10000, "sssssssvjkfebnvwekflb"); 
		
		//withdraw Method check checking
		System.out.println("<<withdraw Method check for checking>>");
		mattsAccount.withdrawFromAccount(1, "checking");
		System.out.println(mattsAccount.getCheckingBalance()+ " Get savings method check");
		mattsAccount.withdrawFromAccount(10000, "cccc");
		mattsAccount.withdrawFromAccount(10000, "xfjrhfhj");
		
		
		
		
	}//end main method
}//end class method
