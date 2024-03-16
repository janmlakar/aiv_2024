package si.um.feri.aiv.vao;

public class Skupnost {

	private String naziv;
	private Skrbnik ime;
	private Skrbnik priimek;
	private Skrbnik email;
	
	public Skupnost() {
		
	}
	
	public Skupnost(String naziv, Skrbnik ime, Skrbnik priimek, Skrbnik email) {
		naziv=this.naziv;
		ime=this.ime;
		priimek=this.priimek;
		email=this.email;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Skrbnik getIme() {
		return ime;
	}

	public void setIme(Skrbnik ime) {
		this.ime = ime;
	}

	public Skrbnik getPriimek() {
		return priimek;
	}

	public void setPriimek(Skrbnik priimek) {
		this.priimek = priimek;
	}

	public Skrbnik getEmail() {
		return email;
	}

	public void setEmail(Skrbnik email) {
		this.email = email;
	}
	

}
