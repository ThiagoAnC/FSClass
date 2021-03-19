package BancoThiago;

import java.time.LocalDate;
import java.util.Random;

public class Conta {
	private Pessoa Person;
	private int accNmb;
	private double balance;
	private LocalDate createTime;
	@SuppressWarnings("unused")
	private Types type;
	
	public enum Types{
		SIMPLES, EXECUTIVA, PREMIUM, PERSONALITE;
	}

	public LocalDate getCreateTime() {
		return createTime;
	}

	public Pessoa getClient() {
		return this.Person;
	}

	public void setClient(Pessoa person) {
		this.Person = person;
	}

	public int getAccNmb() {
		return this.accNmb;
	}

	public void setAccNmb(int accNmb) {
		this.accNmb = accNmb;
	}

	public double getBalance() {
		return this.balance;
	}
	

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setTime(LocalDate createTime) {
		this.createTime = createTime;
	}

	public void getConta(Pessoa client, int accNmb, double balance) {
		this.setClient(client);
		this.setAccNmb(accNmb);
		this.setBalance(balance);
		this.setTime(LocalDate.now());
	}

	public void getCash(double value) {
		if (getBalance() < value && this.getClass().equals(ContaPoupanca.class)) {
			System.out.println("This operation cannnot be done, insufficient balance!");

		}
		else {
			setBalance(getBalance() - value);
			System.out.println("Cash successfully withdrawn!");
		}
	}

	protected void toDebit(double value) {
		if (getBalance() < value) {
			System.out.println("This operation cannnot be done, insufficient balance!");
		}
		else {
			setBalance(getBalance() - value);
			System.out.println("Debit successfully done!");
		}
	}

	protected int showBalance() {
		if (this.getBalance() > 0) {
			System.out.println("This account has a balance of " + this.getBalance() + ".");
			return 1;
		}
		else {
			System.out.println("This account hasn't have cash.");
			return 0;
		}
	}

	public void toDeposit(double value) {
		setBalance(getBalance() + value);
		System.out.println("Deposit successfully done!");
	}

	public void toTransfer(double value, Conta recv) {
		if (this.getBalance() < value) {
			System.out.println("This operation can't be done, no enough cash to complete tranfer.");
		}
		else {
			this.toDebit(value);
			recv.toDeposit(value);
			System.out.println("Transfer done with success.");
		}
	}

	public int randAccNo() {
		Random number = new Random(0);
		return (number.nextInt(99999));

	}

	public void setType(Types type) {
		this.type = type;
	}

}
