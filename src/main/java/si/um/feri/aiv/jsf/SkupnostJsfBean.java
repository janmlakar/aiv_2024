package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.dao.SkupnostDao;
import si.um.feri.aiv.dao.SkupnostMemoryDao;
import si.um.feri.aiv.vao.Skupnost;

@Named("beta")
@SessionScoped

public class SkupnostJsfBean implements Serializable {


	private static final long serialVersionUID = -1743904552982084167L;

	Logger log=Logger.getLogger(SkupnostJsfBean.class.toString());
	
	private SkupnostDao dao=SkupnostMemoryDao.getInstance();
	
	private Skupnost izbranaSkupnost=new Skupnost();
	
	public List<Skupnost> getVseSkupnosti() throws Exception {
		return dao.vrniVse();
	}
	
	public String shraniSkupnost() throws Exception {
		dao.shrani(izbranaSkupnost);
		return "vse";
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

}
