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
	protected int showBalance(Conta conta) {
		return super.showBalance(conta);
	}

	@Override
	public void getConta() {
		super.getConta();
	}
	
}
