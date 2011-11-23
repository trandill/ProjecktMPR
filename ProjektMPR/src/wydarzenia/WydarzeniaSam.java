package wydarzenia;

import Wypozyczalnie_samochodow.*;

public class WydarzeniaSam {
	private Samochod _samochod;

	public WydarzeniaSam(Object source, Samochod samochod) {
		super();
		_samochod = samochod;
	}
	
	public Samochod pobierz_samochod() {
		return _samochod;
	}

	public void ustaw_samochod(Samochod _samochod) {
		this._samochod = _samochod;
	}

	
}
