package Wypozyczalnie_samochodow;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Firma {
	
	private static Logger logger= Logger.getLogger(Firma.class);

	public Integer ID;
	public String nazwaFirmy;
	public Integer NIP;
		
	public List<Samochod> listaSamochod = new ArrayList<Samochod>();
	
	public Firma(String nazwaFirmy, Integer NIP)
	{
		this.nazwaFirmy = nazwaFirmy;
		this.NIP = NIP;
	}
	
	public Firma(String nazwaFirmy, Integer NIP, List<Samochod> listaSamochod)
	{
		this.nazwaFirmy = nazwaFirmy;
		this.NIP = NIP;
		this.listaSamochod=listaSamochod;
	}
	
	public String toString()
	{
		
		return nazwaFirmy + " ma  " + listaSamochod.size()+" wypozyczonych somochodow .";
	}
	
	public void wypiszSamochody()
	{
		for(Samochod b : this.listaSamochod)
		{
			b.wypiszSamochody();
		}
		logger.info("wypisamo samochody" );
	}

	public void wypiszFirme() {
		System.out.println(nazwaFirmy + " " + NIP);
		logger.info("Wypisamo firme" + nazwaFirmy + " " + NIP);
	}



	public void dodajsamochod(Samochod b) {
		
		listaSamochod.add(b);
		logger.info("Dodano nowy samochod \"" +b.marka +"\"" );
	}

	public void usunSamochod(Samochod samochod) {
		
		listaSamochod.remove(samochod);
			
			logger.info("Usunieto samochod z listy \"" + samochod.pobierzNazwa()+"\"" );
		}
		

	public void wyczyscListeSamochodow() {
		listaSamochod.clear();
		logger.info("Wyczyszczono liste samochod");
	}


	public Samochod znajdzNazweSamochodu(String nazwa) {
		
		for (Samochod samochod : listaSamochod) {
			if (samochod.pobierzNazwa().equals(nazwa)) {
				return samochod;
			}
			logger.info("znaleziono somochod \"" + nazwa +"\"" );
		}
		return null;
	}
	
	public Samochod znajdzMarke(Rodzajesamochodow marka) {
		
		for (Samochod samochod : listaSamochod) {
			if (samochod.poberzMarka().equals(marka)) {
				return samochod;
			}
			logger.info("Znaleziona marke \"" + marka +"\"" );
		}
		return null;
	}
	
	
	
	public List<Samochod> znajdzNazwySamochodow(String nazwa) {
		List<Samochod> wynik= new ArrayList<Samochod>();
		for (Samochod samochod : listaSamochod) {
			if (samochod.pobierzNazwa().equals(nazwa)) {
				wynik.add(samochod);
			}
			logger.info("Znaleziono wszystkie samochody z nazwa " + nazwa);
		}
		return wynik;
	}

	public List<Samochod> znajdzMarkiSamochodow(Rodzajesamochodow marka) {
		List<Samochod> wynik= new ArrayList<Samochod>();
		for (Samochod samochod : listaSamochod) {
			if (samochod.poberzMarka().equals(marka)) {
				wynik.add(samochod);
			}
			logger.info("Znaleziono wszystkie samochody z marki " + marka);
		}
		return wynik;
	}
	
	public String pobierzNazweFirmy() {
		return nazwaFirmy;
	}

	public void ustawNazwefirmy(String nazwaFirmy) {
		this.nazwaFirmy = nazwaFirmy;
		logger.info("Ustawiono nazwe firmy" + nazwaFirmy);
	}

	public Integer pobierzNIP(Integer NIP) {
		return NIP;
	}

	public void ustawNIP(Integer NIP) {
		this.NIP = NIP;
		logger.info("NIP Firmy to" + NIP);
	}

	public List<Samochod> pobierzListeSamochodow() {
		return listaSamochod;
	}

	public void ustawListeSamochodow(List<Samochod> listaSamochod) {
		this.listaSamochod = listaSamochod;
		logger.info("wczytano liste samochodow" );
	}
	
}


