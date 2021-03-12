package BancoThiago;

import java.util.ArrayList;
import java.time.LocalDate;

import java.util.List;

public class Main {
	public static void main(String[] args) {	
		PessoaFisica john = new PessoaFisica(1,"John", "Goiania", 999, LocalDate.of(1994,02,14) ,"Male");
		PessoaFisica patricia = new PessoaFisica(2, "Patricia", "Brasilia",888, LocalDate.of(1989,05,16) ,"Female");
		
		System.out.println(john.getAge());
		System.out.println(patricia.getAge());
		
		PessoaJuridica nokia = new PessoaJuridica(3,"Nokia Corp","Finland",111,"Telecom");
		PessoaJuridica amazon = new PessoaJuridica(4, "Amazon Inc","USA", 222, "E-Commerce");
		
		ContaEspecial ceJohn = new ContaEspecial(john, 1, 1000.0, 500.0);
		ContaEspecial ceNokia = new ContaEspecial(nokia, 2, 100000.0, 10000.0);
		
		ContaPoupanca cpPatricia = new ContaPoupanca(patricia, 3, 1200.0, 500.0);
		ContaPoupanca cpAmazon = new ContaPoupanca(amazon, 4, 50000.0, 5000.0);
		
		System.out.println(ceJohn.getBalance());
		ceJohn.getCash(100.0);
		
		System.out.println(cpPatricia.getBalance());
		cpPatricia.toDeposit(200.0);
		
		System.out.println(ceNokia.getBalance());
		ceNokia.toTranfer(5000.0, cpAmazon);
		
		System.out.println("Nokia: " + ceNokia.getBalance());
		System.out.println("Amazon: " + cpAmazon.getBalance());
		
		List<Conta> accounts = new ArrayList<Conta>();
		accounts.add(ceJohn);
		accounts.add(ceNokia);
		accounts.add(cpAmazon);
		accounts.add(cpPatricia);
		
		double outcome = 0.00;
		for (Conta c : accounts) {
			System.out.println("Name: " + c.getClient().getName() + ", account balance: " + c.getBalance());
			outcome += c.getBalance();
		}
		
		System.out.println("Outcome: $" + outcome);
	}
	
}
