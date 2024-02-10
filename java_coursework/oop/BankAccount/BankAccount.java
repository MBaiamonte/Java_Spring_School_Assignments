
public class BankAccount {
	private double checkingBalance;
	private double savingsBalance;
	private static int numberOfAccounts;
	private static int allAccountsTotal;
	
	public BankAccount(double checkingBalance, double savingsBalance) {
		 this.checkingBalance=checkingBalance;
		 this.savingsBalance=savingsBalance;
		 numberOfAccounts++;
		 allAccountsTotal+=checkingBalance;
		 allAccountsTotal+=savingsBalance;		 
	} //end of constructor (could add a second one for overloading)
	
	public double getCheckingBalance(){
		return this.checkingBalance;
	}//end getCheckingBalance
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}//end getSavingsBalance
	
	public void depositIntoAnAccount(double amount, String accountToDeposit) {
		if (accountToDeposit.contains("savingsAccount")) { //could also use .startsWith("s") or .equals(savingsAccount) or maybe .contentEquals(savingsAccount)? 
			this.savingsBalance+= amount;
			allAccountsTotal+=amount;
		}//end savings if
		else if (accountToDeposit.equals("checkingAccount")) {
			this.checkingBalance+=amount;
			allAccountsTotal+=amount;
		} //end checking if
		else {
			System.out.println("must have string as ether savingsAccount or checkingAccount to deposit ");
		}//end else
	}//end deposit method
	
	
	public void withdrawFromAccount(double amount, String accountToWithdraw) {
		if (accountToWithdraw.startsWith("s")) {
			if (this.savingsBalance-amount <0) {
				System.out.println("insufficant funds in savings account");
			}
			else {
				this.savingsBalance-=amount;
				allAccountsTotal-=amount;
			}//savings else
		}//end savings 1st if statement
		else if (accountToWithdraw.startsWith("c")) {
			if (this.checkingBalance-amount <0) {
				System.out.println("insufficant funds in checking account");
			}
			else {
				this.checkingBalance-=amount;
				allAccountsTotal-=amount;
			}//end checking else
		}//end else if statement
		else {
			System.out.println("for saving type any word that starts with s for checking and word that starts with  ");
		}
	}//end withdraw methods
	
	public static int getAllAccountsTotal() {
		return allAccountsTotal;
	}
	
	
	
	
//<<<<<<<<below methods are supposed to be in one not two>>>>>>>>>>
//	public void setCheckingBalanceDeposit(double amount) {
//		this.checkingBalance+= amount;
//		allAccountsTotal+=amount;
//	}//end setCheckingBalanceDeposit
//	
//	public void setSavingsAccountBalanceDeposit(double amount) {
//		this.savingsBalance+=amount;
//		allAccountsTotal+=amount;
//	}//end setSavingsAccountBalanceDeposit
//	
}//end entire class bracket