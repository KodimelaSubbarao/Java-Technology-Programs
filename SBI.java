package com.sa.banks;

public class SBI implements IBank {
	double Tamount=0;
	
	public SBI(double Tamount)
	{
		this.Tamount=Tamount;
	}
	
	@Override
	public void deposit(double amount) {
		Tamount=Tamount+amount;
		System.out.println("Amount Deposited is "+amount+" avaliable balance "+Tamount);
	}

	@Override
	public void withdraw(double amount) {
		// TODO Auto-generated method stub
		Tamount=Tamount-amount;
		System.out.println("withdraw amount is "+(amount)+" available balance "+checkBalance());

	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		return Tamount;
	}

}
