package wydarzenia;

import java.util.*;

import Wypozyczalnie_samochodow.*;

public class WydarzeniaMgr {

	private Samochod samochod;
	private List<ISamochodProces> proces = new ArrayList<ISamochodProces>();

	public Samochod pobierzSamochod() {
		return samochod;
	}

	public void ustawSamochod(Samochod samochod) {
		this.samochod = samochod;
	}

	public synchronized void dodajProces(ISamochodProces proces1) {
		proces.add(proces1);
	}

	public synchronized void usunProces(ISamochodProces proces1) {
		proces.remove(proces1);
	}

	public synchronized void wykonajProces(List<Samochod> list) {
		for (Samochod samochod : list) {
			ustawSamochod(samochod);
			WydarzeniaSam wydarzenie = new WydarzeniaSam(this, samochod);
			Iterator<ISamochodProces> proce = proces.iterator();
			while (proce.hasNext()) {
				((ISamochodProces) proce.next()).procesSamochod(wydarzenie);
			}
		}
	}
}
