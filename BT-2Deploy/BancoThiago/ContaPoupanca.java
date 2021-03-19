package BancoThiago;

import java.time.LocalDate;

public class ContaPoupanca extends Conta{

	double corrcTx;

	public double getCorrcTx() {
		return corrcTx;
	}

	public void setCorrcTx(double corrcTx) {
		this.corrcTx = corrcTx;
	}

	public void passIncome(){
		LocalDate calendar = LocalDate.now();
		LocalDate birth = getCreate();
        if (calendar.getDayOfMonth() == birth.getDayOfMonth() && calendar.getMonth() == birth.getMonth()) {
			super.toDeposit(corrcTx);
		}
	}

	private LocalDate getCreate() {
		return super.getCreateTime();
	}

	public ContaPoupanca(Pessoa client, int accNmb, double balance, double tax) {
		super.getConta(client, accNmb, balance);
		this.setCorrcTx(tax);
	}

}