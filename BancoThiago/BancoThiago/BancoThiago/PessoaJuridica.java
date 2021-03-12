package BancoThiago;

public class PessoaJuridica  extends Pessoa{
	int cnpj;
	String activity;
	
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public PessoaJuridica(int id, String name, String address, int cnpj, String activity) {
		super(id, name, address);
		this.setActivity(activity);
		this.setCnpj(cnpj);
	}
}
