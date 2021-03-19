package BancoThiago;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import BancoThiago.Conta.Types;

public class Menu {

	public void mainMenu(Scanner sc) {
		Integer option;
		Conta account;
		do {
			this.showMainMenu();
			option = 1;
			try {
				option = sc.nextInt();
				sc.nextLine();
				
				switch (option) {
				
				case 1:
					openAcc(sc);
					break;
					
				case 2:
					System.out.println("--- Please input an account number: -----");
					int accNmb = sc.nextInt();
					account = this.searchAccount(sc, accNmb);
					this.menuConta(sc, account);
					break;

				case 3:
					this.addClient(sc);
					break;

				case 4:
					reports(sc);
					break;

				case 5:
					System.out.println("5 Ц Sair");
					break;

				default:
					System.out.println("Opзгo Incorreta");
				}
				
			} catch (Exception e) {
				
				System.out.println("Opзгo Incorreta, sair.");
				option = 5;
			}
		} while (option != 5);

	}

	private void reports(Scanner sc) {
		Main main = new Main();
		int repo;
		
		do{
			System.out.println();
			System.out.println("What kind of report do you want?");
			System.out.println("1- Outcome Report  2 - Clients List  3 - Leave Reports");
			
			repo = sc.nextInt();
			sc.nextLine();
			
			if (repo == 1) {
				main.outcomeReport();
			} 
			
			else if (repo == 2) {
				main.clientReport();
			}
			else {
				break;
			}
		}while (repo == 1 || repo == 2);
		
	}

	private void openAcc(Scanner sc) {
		int flag;
		int accNmb = 0;
		double bal = 0.0;
		
		System.out.println("--- New Account-----");
		
		System.out.println("--- Please type your id:-----");
		int id = sc.nextInt();
		Pessoa client = searchClient(sc,id);
		
		if (!verifyClt(client)) {
			System.out.println("--- Please register as client before opening an account. -----");
			return;
		}
		
		do {
			System.out.println("--- Please input an account number: -----");
			accNmb = sc.nextInt();
			
			if (verifyAcc(searchAccount(sc,accNmb))) {
				System.out.println("--- Invalid account number! -----");
				flag = 0;
				
			} else {
				flag = 1;
				System.out.println("--- Please set your account balance, just numbers without point: -----");
				bal = sc.nextDouble();
				sc.nextLine();
			}
			
		} while (flag == 0);
		
		System.out.println("What type of your account?");
		System.out.println("1 - Special Account  2 - Savings Account");
		
		int repo = sc.nextInt();
		sc.nextLine();
		
		if (repo == 1) {
			System.out.println("--- Please set your account limit: -----");
			double limit = sc.nextDouble();
			Conta account = new ContaEspecial(client, accNmb, bal, limit);
			account.setType(Types.EXECUTIVA);
			Main.accounts.add(account);
		} 
		
		else if (repo == 2) {
			System.out.println("--- Please set your account correction tax: -----");
			double corrTx = sc.nextDouble();
			Conta account = new ContaPoupanca(client, accNmb, bal, corrTx);
			account.setType(Types.SIMPLES);
			Main.accounts.add(account);
		}
		
		System.out.println("--- Account sucessfully created! -----");
	}

	private void addClient(Scanner sc) {

		System.out.println("--- New Client-----");
		
		System.out.println("--- Please inform your id: -----");
		Integer id = sc.nextInt();
		
		System.out.println("--- Please input your name: -----");
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.println("--- Inform your address: -----");
		String address = sc.nextLine();
		
		System.out.println("Select the type of your legal entity:");
		System.out.println("1 - Natural Person");
		System.out.println("2 - Juridical Person");
		
		Integer tipo = sc.nextInt();
		
		if(tipo == 1) {
			System.out.println("--- Inform your CPF:-----");
			int cpf = sc.nextInt();
			sc.nextLine();

			System.out.println("--- Inform your birthdate, as in MM/DD/YYYY -----");
			String date = sc.nextLine();
			
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDate bdate = LocalDate.parse(date, dateFormat);
					
			System.out.println("--- Informe o Genero (M/F) -----");
			String gender = sc.next();
					
			PessoaFisica client = new PessoaFisica(id, name, address, cpf, bdate, gender);
			Main.clients.add(client);
			
			System.out.println("---Client added sucessfully!-----");
			
		}else {
			System.out.println("--- Inform your CNPJ: -----");
			int cnpj = sc.nextInt();
			sc.nextLine();
			
			System.out.println("---Inform your activity: -----");
			String activity = sc.nextLine();
						
			PessoaJuridica client = new PessoaJuridica(id, name, address, cnpj, activity);
			Main.clients.add(client);
			
			System.out.println("---Client added sucessfully!-----");
		}
		
	}

	private void menuConta(Scanner sc, Conta account) {
		
		Integer option = 1;
		do {
			this.showMenuConta(account);
			try {
				option = sc.nextInt();
				Double value;
				int accNmb;
				switch (option) {
				
				case 1: 
					System.out.println("--- Please input the account number that you want to go to: -----");
					accNmb = sc.nextInt();
					account = this.searchAccount(sc, accNmb);
					break;
					
				case 2: 
					System.out.println("Please input the value to deposit:");
					value = sc.nextDouble();
					account.toDeposit(value);
					break;
				case 3: 
					System.out.println("Please inform the value to withdrawn:");
					value = sc.nextDouble();
					account.getCash(value);
					
					break;
				case 4: 
					Conta dest = new Conta();
					int flag = 0;
					
					do{
						System.out.println("Please inform receiver's account number: ");
						accNmb = sc.nextInt(); 
						sc.nextLine();
						
						if (!verifyAcc(searchAccount(sc,accNmb))) {
							flag = 1;
						}else {
							dest = searchAccount(sc,accNmb);
						}
					} while (flag == 1);
						
					System.out.println("Receiver's name: " + dest.getClient().getName());
					
					System.out.println("Please inform the value to transfer:");
					value = sc.nextDouble();
					sc.nextLine();
					
					account.toTransfer(value, dest);
					break;
					
				case 5:
					System.out.println("-------------------------");
					System.out.println("--- OUTCOME: R$ "+account.getBalance());
					System.out.println("-------------------------");
					break;
				}

			}  catch (Exception e) {
				System.out.println("Incorrect option! Leaving system...");
				option = 6;
			}
		}while (option != 6);
	}

	private void showMainMenu() {
		System.out.println("-------------------------");
		System.out.println("---Select an option---");
		System.out.println("-------------------------");
		System.out.println("1 Ц Open Account");
		System.out.println("2 Ц Select an Account");
		System.out.println("3 Ц Register Client");
		System.out.println("4 Ц Reports");
		System.out.println("5 Ц Leave System");
		System.out.println("-------------------------");
	}

	private void showMenuConta(Conta account) {
		System.out.println("-------------------------");
		System.out.println("Client: " + account.getClient().getName());
		System.out.println("Account Number: " + account.getAccNmb());
		System.out.println("-------------------------");
		System.out.println("---Select an option---");
		System.out.println("-------------------------");
		System.out.println("1 Ц Change Accounts");
		System.out.println("2 Ц To Deposit");
		System.out.println("3 Ц Withdrawn Cash");
		System.out.println("4 Ц Transfer Cash");
		System.out.println("5 Ц Outcome");
		System.out.println("6 Ц Leave System");
		System.out.println("-------------------------");
	}

	public Conta searchAccount(Scanner sc, int accNmb) {

		Conta account = null;
		for (Conta c : Main.accounts) {

			if (c.getAccNmb() == accNmb) {
				account = c;
				break;
			}
		}
		return account;
	}
	
	public Pessoa searchClient(Scanner sc, int id) {

		Pessoa client = null;
		
		for (Pessoa p : Main.clients) {
			if (p.getId() == id) {
				client = p;
				break;
			}
		}
		return client;
	}
	
	public boolean verifyAcc(Conta acc) {
		if (acc == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean verifyClt(Pessoa clt) {
		if (clt == null) {
			return false;
		} else {
			return true;
		}
	}
}
