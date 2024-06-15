package com.sa.banks;

public class MainCustomer 
{
	String name;
	double accountBalance;
	
	public MainCustomer(String name,double accountBalance)
	{
		this.name=name;
		this.accountBalance=accountBalance;
	}
	void deposit(IBank bank,double amount)
	{
		bank.deposit(amount);
	}
	void withdraw(IBank bank,double amount)
	{
		if (amount <= bank.checkBalance()) {
		bank.withdraw(amount);
		System.out.println("Withdraw successfull");
		}
		else {
			System.out.println("Insufficient funds in "+bank.getClass().getSimpleName()+" account.");
		}
	}
	void checkBalance(IBank bank)
	{
		System.out.println("Your account Balance is :: "+bank.checkBalance());
	}
	public static void main(String[] args) 
	{
		MainCustomer mc=new MainCustomer("Subbu",100000.0);
		SBI sbi=new SBI(mc.accountBalance);
		
		
		mc.deposit(sbi, mc.accountBalance);
		mc.withdraw(sbi, 2000.0);
		mc.checkBalance(sbi);
		
		System.out.println();
		System.out.println();
		
		MainCustomer mc1=new MainCustomer("Subbu",50000.0);
		HDFC hdfc1=new HDFC(mc1.accountBalance);
		mc1.checkBalance(hdfc1);
		mc1.withdraw(hdfc1, 5555);
		mc1.checkBalance(hdfc1);
		mc1.deposit(hdfc1, 65000);
		mc1.checkBalance(hdfc1);
		
		System.out.println();
		System.out.println();
		
		MainCustomer mc2=new MainCustomer("raja", 7550.58);
		ICICI icici=new ICICI(mc2.accountBalance);
		mc2.checkBalance(icici);
		mc2.deposit(icici, 1200.21);
		mc2.checkBalance(icici);
		mc2.withdraw(icici, 1500000.10);
		mc2.checkBalance(icici);
	}

}
