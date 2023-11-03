import java.util.Scanner;

public class First {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
				System.out.println("Enter your 'Name' annd 'Customerid' to access your bank account");
				String name=sc.nextLine();
				String Customerid=sc.nextLine();
				BankAccount obj1=new BankAccount(name,Customerid);
				obj1.menu();

	}

}
class BankAccount{
	double bal;
	double prevTrans;
	String CustomerName;
	String Customerid;
	
	BankAccount(String CustomerName,String Customerid){
		this.CustomerName=CustomerName;
		this.Customerid=Customerid;
	}
	
	void deposit(double amount) {
		if(amount!=0) {
			bal+=amount;
			prevTrans=amount;
		}
	}
	
	void withdraw(double amt) {
		if(amt!=0 && bal>=amt) {
			bal-=amt;
			prevTrans=-amt;
		}
		else if(bal<amt) {
			System.out.println("Bank balance insufficient");
		}
	}
	
	void getPreviousTrans() {
		if(prevTrans>0) {
			System.out.println("Deposited"+prevTrans);
		}
		else if(prevTrans<0) {
			System.out.println("Withdrawn"+Math.abs(prevTrans));
		}
		else {
			System.out.println("No transaction occured");
		}
	}
	void menu() {
		char option;
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome"+CustomerName);
		System.out.println("Your ID:"+Customerid);
		System.out.println("\n");
		System.out.println("a)check Balance");
		System.out.println("b)Deposit Amount");
		System.out.println("c)Withdraw Amount");
		System.out.println("d)Previous Transaction");
		System.out.println("e)Exit");
		
		do {
			System.out.println("****************************************************");
			System.out.println("Choose an option");
			option=sc.next().charAt(0);
			System.out.println("\n");
			
			switch(option){
			    case 'a':
			         System.out.println("............................");
			         System.out.println("Balance="+bal);
			         System.out.println("............................");
			         System.out.println("\n");
			         break;
			    case 'b':
			    	 System.out.println("............................");
			         System.out.println("Enter Amount to deposit:");
			         System.out.println("............................");
			         double amt=sc.nextDouble();
			         deposit(amt);
			         System.out.println("\n");
			         break;
			    case 'c':
			    	 System.out.println("............................");
			         System.out.println("Enter Amount to Withdraw:");
			         System.out.println("............................");
			         double amtW=sc.nextDouble();
			         withdraw(amtW);
			         System.out.println("\n");
			         break;
			    case 'd':
			    	 System.out.println("............................");
			         System.out.println("Previous Transaction");
			         getPreviousTrans();
			         System.out.println("............................");
			         System.out.println("\n");
			         break;
			    case 'e':
			    	System.out.println("............................");
			    	break;
			    default:
			    	System.out.println("Choose a correct option to proceed");
			    	break;
			}
		}
		while(option!='e');
		System.out.println("Thankyou for using our bank service");
		
	}
}
