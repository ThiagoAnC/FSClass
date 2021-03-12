package BancoThiago;

import java.time.LocalDate;

public class PessoaFisica extends Pessoa{
	private int cpf;
	private LocalDate birthdate;
	private String gender;
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		LocalDate calendar = LocalDate.now();
		LocalDate birth = getBirthdate();
        return calendar.getYear() - birth.getYear();
    }
	
	public PessoaFisica(int id, String name, String address, int cpf, LocalDate localDate, String gender) {
		
		super(id,name,address);
		this.setCpf(cpf);
		this.setBirthdate(localDate);
		this.setGender(gender);
	}
}
