package si.um.feri.aiv.dao;

import java.util.List;

import si.um.feri.aiv.vao.Skupnost;

public interface SkupnostDao {

	List<Skupnost> vrniVse();
	Skupnost najdi(String naziv);
	void shrani (Skupnost s);
	void izbrisi (String naziv);
	
}
