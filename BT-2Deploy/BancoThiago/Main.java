package BancoThiago;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

import java.util.List;

public class Main {
	
	static List<Conta> accounts = new ArrayList<Conta>();
	static List<Pessoa> clients = new ArrayList<Pessoa>();
	
	public static void main(String[] args) {
		System.out.println("Running");
		
		Scanner sc = new Scanner(System.in);		
		
		PessoaFisica john = new PessoaFisica(1,"John", "Goiania", 999, LocalDate.of(1994,02,14) ,"Male");
		PessoaFisica patricia = new PessoaFisica(2, "Patricia", "Brasilia",888, LocalDate.of(1989,05,16) ,"Female");
		
		PessoaJuridica nokia = new PessoaJuridica(3,"Nokia Corp","Finland",111,"Telecom");
		PessoaJuridica amazon = new PessoaJuridica(4, "Amazon Inc","USA", 222, "E-Commerce");
		
		ContaEspecial ceJohn = new ContaEspecial(john, 1, 1000.0, 500.0);
		ContaEspecial ceNokia = new ContaEspecial(nokia, 2, 100000.0, 10000.0);
		
		ContaPoupanca cpPatricia = new ContaPoupanca(patricia, 3, 1200.0, 500.0);
		ContaPoupanca cpAmazon = new ContaPoupanca(amazon, 4, 50000.0, 5000.0);
					
		clients.add(amazon);
		clients.add(nokia);
		clients.add(john);
		clients.add(patricia);
		
		accounts.add(ceJohn);
		accounts.add(ceNokia);
		accounts.add(cpAmazon);
		accounts.add(cpPatricia);
		
	
	Menu menu = new Menu();
	System.out.println("-------------------------");
	System.out.println("---- Be welcome!-----");
	System.out.println("-------------------------");
	menu.mainMenu(sc);
	System.out.println("-------------------------");
	System.out.println("-- You logged out!---");
	System.out.println("------- See you soon!--------");
	System.out.println("-------------------------");
	}
	
	public void outcomeReport() {
		double outcome = 0.00;
		for (Conta c : accounts) {
			outcome += c.getBalance();
		}
		System.out.println("Total outcome: " + outcome);
	}
	
	public void clientReport() {
		for (Pessoa c : clients) {
			System.out.println(c.getName());
		}
	}
	
}
