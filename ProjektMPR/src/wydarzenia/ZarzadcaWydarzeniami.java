package wydarzenia;



import Wypozyczalnie_samochodow.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZarzadcaWydarzeniami {

	private Samochod samochod;
	private List procesow = new ArrayList();

	public Samochod pobierzSamochod() {
		return samochod;
	}

	public void ustawSamochod(Samochod samochod) {
		this.samochod = samochod;
	}

	public synchronized void dodajProces(ISamochodProces proces) {
		procesow.add(proces);
	}

	public synchronized void usunProces(ISamochodProces proces) {
		procesow.remove(proces);
	}

	public synchronized void realizujProsesy(List<Samochod> list) {
		for (Samochod samochod : list) {
			ustawSamochod(samochod);
			WydarzeniaSam wydarzenie = new WydarzeniaSam(this, samochod);
			Iterator proc = procesow.iterator();
			while (proc.hasNext()) {
				((ISamochodProces) proc.next()).procesSamochod(wydarzenie);
			}
		}
	}
}
