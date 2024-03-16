package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.LastnikDao;
import si.um.feri.aiv.dao.LastnikMemoryDao;
import si.um.feri.aiv.vao.Lastnik;

@Named("demo")
@SessionScoped
public class LastnikJsfBean implements Serializable {

	private static final long serialVersionUID = -8979220536758073133L;

	Logger log=Logger.getLogger(LastnikJsfBean.class.toString());

	private LastnikDao dao=LastnikMemoryDao.getInstance();
	
	private Lastnik izbranaLastnik=new Lastnik();
	
	private String izbranEmail;
	
	public List<Lastnik> getVseOsebe() throws Exception {
		return dao.vrniVse();
	}
	
	public String shraniOsebo() throws Exception {
		dao.shrani(izbranaLastnik);
		return "vse";
	}
	
	public void izbrisiOsebo(Lastnik o) throws Exception {
		dao.izbrisi(o.getEmail());
	}
	
	public void setIzbranEmail(String email) throws Exception {
		izbranEmail=email;
		izbranaLastnik=dao.najdi(email);
		if(izbranaLastnik==null) izbranaLastnik=new Lastnik();
	}
	
	public String getIzbranEmail() {
		return izbranEmail;
	}

	public Lastnik getIzbranaLastnik() {
		return izbranaLastnik;
	}

	public void setIzbranaLastnik(Lastnik izbranaLastnik) {
		this.izbranaLastnik = izbranaLastnik;
	}
	
}
