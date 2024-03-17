package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import si.um.feri.aiv.vao.Lastnik;
import si.um.feri.aiv.vao.Skupnost;

public class SkupnostMemoryDao implements SkupnostDao {

	Logger log=Logger.getLogger(SkupnostMemoryDao.class.toString());
	
	private SkupnostMemoryDao() {
		skupnosti=Collections.synchronizedList(new ArrayList<Skupnost>());
	}
	
	private static SkupnostMemoryDao instance=new SkupnostMemoryDao();

	public static SkupnostMemoryDao getInstance() {
		return instance;
	}
	
	private List<Skupnost> skupnosti;

	@Override
	public List<Skupnost> vrniVse() {
		log.info("DAO: vračam vse skupnosti");
		return skupnosti;
	}

	@Override
	public Skupnost najdi(String naziv) {
		log.info("DAO: iščem "+ naziv);
		for (Skupnost s : skupnosti)
			if (s.getNaziv().equals(naziv))
				return s;
		return null;
	}

	@Override
	public void shrani(Skupnost s) {
		log.info("DAO: shranjujem "+s);
		if(najdi(s.getNaziv())!=null) {
			log.info("DAO: urejam "+s);
			izbrisi(s.getNaziv());
		}
		skupnosti.add(s);	
	}

	@Override
	public void izbrisi(String naziv) {
		log.info("DAO: brišem "+naziv);
		for (Iterator<Skupnost> i = skupnosti.iterator(); i.hasNext();) {
			if (i.next().getNaziv().equals(naziv))
				i.remove();
		}
	}
	
	@Override
	public void izbrisiLastnika(int id, String naziv) {
		log.info("DAO: brišem lastnika "+id+" skupnosti "+naziv);
		Skupnost najdena=najdi(naziv);
		if (najdena==null) return;
		for (Iterator<Lastnik> i = najdena.getLastniki().iterator(); i.hasNext();) {
			if (i.next().getId()==id)
				i.remove();
		}
		
	}

	@Override
	public void shraniLastnika(Lastnik lastnik, String naziv) {
		log.info("DAO: shranjujem lastnika "+lastnik+" skupnosti "+naziv);
		Skupnost najdena=najdi(naziv);
		if (najdena==null) return;
		izbrisiLastnika(lastnik.getId(), naziv);
		lastnik.setId(najdena.getMaxLastnikId()+1);
		najdena.getLastniki().add(lastnik);
	}

}
