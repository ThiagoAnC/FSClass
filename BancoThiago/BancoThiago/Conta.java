package br.inf.ufg.BancoThiago;
import java.util.Random;

public class Conta {
	private Pessoa Person;
	private int accNmb;
	private double balance;
		
	public Pessoa getClient() {
		return Person;
	}

	public void setClient(Pessoa person) {
		Person = person;
	}

	public int getAccNmb() {
		return accNmb;
	}
	
	public void setAccNmb(int accNmb) {
		this.accNmb = accNmb;
	}

	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void getConta() {
		Pessoa client;
		client = new Pessoa();
		client.getPessoa();
		setClient(client);
		
		
		setAccNmb(randAccNo());
		setBalance(0);
	}

	public void getCash(double value) {
		if (getBalance() < value) {
			System.out.println("This operation cannnot be done, insufficient balance!");
		}
		else {
			setBalance(getBalance() - value);
		}
	}
	
	@SuppressWarnings("unused")
	private void toDebit(double value) {
		if (getBalance() < value) {
			System.out.println("This operation cannnot be done, insufficient balance!");
		}
		else {
			setBalance(getBalance() - value);
		}
	}
	
	protected int showBalance(Conta conta) {
		if (conta.getBalance() > 0) {
			System.out.println("This account has a balance of " + conta.getBalance() + ".");
			return 1;
		}
		else {
			System.out.println("This account hasn't have cash.");
			return 0;
		}
	}
	
	public void toDeposit(double value) {
		setBalance(getBalance() + value);
	}
	
	public void toTranfer(double value, Conta recv, Conta payer) {
		double payBal = payer.getBalance();
		if (payBal < value) {
			System.out.println("This operation can't be done, no enough cash to complete tranfer.");
		} 
		else {
			payer.setBalance(payer.getBalance() - value);
			recv.setBalance(recv.getBalance() + value);
		}
	}
	
	public int randAccNo() {
		Random number = new Random(0);
		return (number.nextInt(99999));
		
	}
}

























