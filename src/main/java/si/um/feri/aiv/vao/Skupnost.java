package si.um.feri.aiv.vao;

import jakarta.validation.constraints.NotBlank;

public class Skupnost {

	@NotBlank
	private String naziv;
	private String ime;
	private String priimek;
	private String email;
	
	public Skupnost() {
		this("","","","");
	}
	
	public Skupnost(String naziv, String ime, String priimek, String email) {
		this.naziv = naziv;
		this.ime = ime;
		this.priimek = priimek;
		this.email = email;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
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

	@Override
	public String toString() {
		return "Skupnost [naziv=" + naziv + ", ime=" + ime + ", priimek=" + priimek + ", email=" + email + "]";
	}

	
}
