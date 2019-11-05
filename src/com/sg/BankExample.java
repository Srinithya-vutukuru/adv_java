package com.sg;

public class BankExample {

	public static void main(String[] args) {
		Account account = new Account(5000);
		
		TransactionThread t1 = new 
				TransactionThread(account,TransactionType.CREDIT,"George",2500.00);
		TransactionThread t2 = 
				new TransactionThread(account,TransactionType.CREDIT,"\tPeter",3500.00);
		TransactionThread t3 = 
				new TransactionThread(account,TransactionType.DEBIT,"\t\tJane",4500.00);
		TransactionThread t4 = 
				new TransactionThread(account,TransactionType.DEBIT,"\t\t\tJasamine",5500.00);
		
		t4.start();
		t3.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		t1.start();
		t2.start();
		
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			
		System.out.println("Final Balance: "+ account.getBalance());
		
	}

}
