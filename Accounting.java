public class Accounting {


public static void main(String[] args) {
BankAccount[] Bank = new BankAccount[10];
		Bank[0] = (SavingsAccount) new SavingsAccount("zxc",24234,"001");
		Bank[1] = (CheckingAccount) new CheckingAccount("fdgs",3333,"002");
		Bank[2] = (SavingsAccount) new SavingsAccount((SavingsAccount) Bank[0],243,"003");
		Bank[3] = (CheckingAccount) new CheckingAccount ("2342",4000,"004");
		Bank[4] = (SavingsAccount) new SavingsAccount((SavingsAccount)Bank[2],250,"005");
		Bank[5] = (CheckingAccount) new CheckingAccount("qrs",6000,"006");
		Bank[6] = (SavingsAccount) new SavingsAccount((SavingsAccount) Bank[0],100,"007");
		Bank[7] = (CheckingAccount) new CheckingAccount("sdfa",8000,"008");
		Bank[8] = (CheckingAccount) new CheckingAccount("213",9000,"009");
		Bank[9] = (SavingsAccount) new SavingsAccount((SavingsAccount) Bank[2],23,"010");
		for(int i=0;i<Bank.length;i++)
			System.out.println(Bank[i]);
	

}

}
class BankAccount {
private double balance;
private String owner;
private String accountNumber;
protected int numberOfAccounts=0;

public BankAccount() {}

public BankAccount(String name,double amount,String accountNum) {
name=owner;
amount = balance;
accountNum=accountNumber;
numberOfAccounts++;
}
public BankAccount(BankAccount old,double amount,String acc)
	{
		this.owner=old.owner;
		numberOfAccounts++;;
		if(old.balance>=amount)
		{
			old.withdraw(amount);
			this.balance=amount;
			accountNumber=acc;
			
		}
		else
		{
		 System.out.println("not enough balance!!")	;
		 accountNumber=acc;
		 
		}
        }
public void deposit(double amount) {
balance+=amount;
}
public boolean withdraw(double amount) {
    if((balance-amount)<0)
		{
			 System.out.println("not enough balance!!")	;
			return false;
		}balance-=amount;
		return true;
}
public double getBalance() {
return balance;
}
public String getOwner() {
return owner;
}
public String getAccountNumber() {
return accountNumber;
}
public void setBalance(double amount) {
amount=balance;

}
public void setAccountNumber(String newAccountNumber){
newAccountNumber=accountNumber;
}
@Override
public String toString()
	{
		return "Owner Name is : " +owner+ " Account Number is: "+accountNumber+" Current Balance:"+balance;
	}
}
class CheckingAccount extends BankAccount {
private double FEE=100;
	public CheckingAccount(String name,double amount,String acc)
	{
		super(name,amount,acc);
	}
	public boolean withdraw(double amount)
	{
		amount+=FEE;
		if((getBalance()-amount)<0)
		{
			return false;
		}super.withdraw(amount);
		return true;
	}

}
class SavingsAccount extends BankAccount {
private double rate=10;
private int savingsNumber;
private String accountNumber;

	SavingsAccount(String name,double amount,String account)
	{
		super(name,amount,account);
	}
	SavingsAccount(SavingsAccount old,double amount,String acc)
	{
		super(old,amount,acc);
	}
	public void postinterest()
	{
		System.out.println((rate/100)*getBalance());
	}
	public String getaccountnum()
	{
		return super.getAccountNumber();
	}	
}
