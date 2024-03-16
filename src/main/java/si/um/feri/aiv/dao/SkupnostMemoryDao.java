/**
 * 
 */
package si.um.feri.aiv.dao;

import java.util.List;
import java.util.logging.Logger;

import si.um.feri.aiv.vao.Skupnost;

public class SkupnostMemoryDao implements SkupnostDao {

	Logger log=Logger.getLogger(SkupnostMemoryDao.class.toString());
	
	private static SkupnostMemoryDao instance=new SkupnostMemoryDao();

	public static SkupnostMemoryDao getInstance() {
		return instance;
	}
	
	private List<Skupnost> skupnosti;
	
	public SkupnostMemoryDao() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Skupnost> vrniVse() {
		log.info("DAO: vračam vse skupnosti");
		return skupnosti;
	}

	@Override
	public Skupnost najdi(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void shrani(Skupnost s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void izbrisi(String naziv) {
		// TODO Auto-generated method stub

	}

}
