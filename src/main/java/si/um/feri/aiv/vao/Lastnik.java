package si.um.feri.aiv.vao;

public class Lastnik {
	
	private int id;
	private String koordinate;
	private String ime;
	private String priimek;
	private String email;
	private double zmogljivost;
	private boolean urejanje;
	
	
	public Lastnik() {
		this("Neznane","Neznan", "","",0);
	}
	
	public Lastnik(String koordinate, String ime, String priimek, String email, double zmogljivost) {
		super();
		this.koordinate = koordinate;
		this.ime = ime;
		this.priimek = priimek;
		this.email = email;
		this.zmogljivost = zmogljivost;
		this.urejanje=true;
	}
	

	public String getKoordinate() {
		return koordinate;
	}

	public void setKoordinate(String koordinate) {
		this.koordinate = koordinate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPriimek() {
		return priimek;
	}
	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getZmogljivost() {
		return zmogljivost;
	}
	public void setZmogljivost(double zmogljivost) {
		this.zmogljivost = zmogljivost;
	}

	public boolean isUrejanje() {
		return urejanje;
	}

	public void setUrejanje(boolean urejanje) {
		this.urejanje = urejanje;
	}

	
	
}
