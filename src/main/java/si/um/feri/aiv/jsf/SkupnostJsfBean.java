package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.SkupnostDao;
import si.um.feri.aiv.dao.SkupnostMemoryDao;
import si.um.feri.aiv.vao.Lastnik;
import si.um.feri.aiv.vao.Skupnost;

@Named("beta")
@SessionScoped

public class SkupnostJsfBean implements Serializable {

	private static final long serialVersionUID = -1743904552982084167L;

	Logger log=Logger.getLogger(SkupnostJsfBean.class.toString());
	
	private SkupnostDao dao=SkupnostMemoryDao.getInstance();
	
	private Skupnost izbranaSkupnost=new Skupnost();
	
	private String izbranNaziv;
	
	public void setIzbranNaziv(String naziv) throws Exception {
		izbranNaziv=naziv;
		izbranaSkupnost=dao.najdi(naziv);
		if(izbranaSkupnost==null) izbranaSkupnost=new Skupnost();
	}
	
	public String getIzbranNaziv() {
		return izbranNaziv;
	}

	
	public List<Skupnost> getVseSkupnosti() throws Exception {
		return dao.vrniVse();
	}
	
	public String shraniSkupnost() throws Exception {
		dao.shrani(izbranaSkupnost);
		return "skupnosti";
	}
	
	public void izbrisiSkupnost(Skupnost s) throws Exception {
		dao.izbrisi(s.getNaziv());
	}

	public Skupnost getIzbranaSkupnost() {
		return izbranaSkupnost;
	}

	public void setIzbranaSkupnost(Skupnost izbranaSkupnost) {
		this.izbranaSkupnost = izbranaSkupnost;
	}
	
	public void dodajLastnika() throws Exception {
		dao.shraniLastnika(new Lastnik(), izbranaSkupnost.getNaziv());
		izbranaSkupnost=dao.najdi(izbranaSkupnost.getNaziv());
	}
	
	public void shraniLastnika(Lastnik l) throws Exception {
		l.setUrejanje(false);
		dao.shraniLastnika(l, izbranaSkupnost.getNaziv());
		izbranaSkupnost=dao.najdi(izbranaSkupnost.getNaziv());
	}
	
	public void izbrisiLastnika(Lastnik l) throws Exception {
		dao.izbrisiLastnika(l.getId(), izbranaSkupnost.getNaziv());
		izbranaSkupnost=dao.najdi(izbranaSkupnost.getNaziv());
	}
	
	public void urediLastnika(Lastnik l) throws Exception {
		l.setUrejanje(true);
		dao.shraniLastnika(l, izbranaSkupnost.getNaziv());
		izbranaSkupnost=dao.najdi(izbranaSkupnost.getNaziv());
	}

}
