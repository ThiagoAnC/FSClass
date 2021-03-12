package BancoThiago;

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

	public Pessoa(int id, String name, String address) {
		this.setName(name);
		this.setId(id);
		this.setAddress(address);

	}
}
