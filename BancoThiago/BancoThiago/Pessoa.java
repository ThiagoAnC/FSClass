package br.inf.ufg.BancoThiago;
import java.util.Scanner;
import java.util.Random;

public class Pessoa {
	private int id;
	private String name;
	private String address;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Pessoa getPessoa() {
		Pessoa client = new Pessoa();
		client.setId(randIdNo());
		
		try (Scanner input = new Scanner(System.in)) {

			System.out.println("Enter client name: ");
			String name = input.nextLine();
			client.setName(name);
			
			
			System.out.println("Enter client address: ");
			String address = input.nextLine();
			client.setAddress(address);
		}
		
		return client;
	}
	
	public int randIdNo() {
		Random number = new Random(0);
		return (number.nextInt(99999999));
	}

}
