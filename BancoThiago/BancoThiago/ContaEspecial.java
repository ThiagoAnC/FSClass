package BancoThiago;

public class ContaEspecial extends Conta{

	double limit;

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	@Override
	public double getBalance() {
		return super.getBalance();
	}
	
	@Override
	public void getCash(double value) {
		super.getCash(value);
	}

	public ContaEspecial(Pessoa client, int accNmb, double balance, double limit) {
		super.getConta(client ,accNmb, balance);
		this.setLimit(limit);
	}
}
