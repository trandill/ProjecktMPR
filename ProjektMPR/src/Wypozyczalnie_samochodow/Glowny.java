package Wypozyczalnie_samochodow;



import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import wydarzenia.*;

public class Glowny {

	private static Logger logger= Logger.getLogger(Glowny.class);
	
	public static void glowny(String[] args) {
	
		PropertyConfigurator.configure("Log4J.properties");
	
		List<Firma> listafirm = new ArrayList<Firma>();
		
		List<Samochod> listasamochodow = new ArrayList<Samochod>();
		List<Samochod> listasamochodow2 = new ArrayList<Samochod>();
		
		Firma firma = new Firma("PW onet", 582456547 , listasamochodow);
		Firma firma2 = new Firma("Koniec", 584248748 , listasamochodow2);
		
		listafirm.add(firma);
		listafirm.add(firma2);
		
		
		Samochod sam1 = new Samochod("Maluch 126p", Rodzajesamochodow.Fiat, 30.40);
		Samochod sam2 = new Samochod("458 italia", Rodzajesamochodow.Ferrari, 503.45);
		Samochod sam3 = new Samochod("CRV ",50.50);
		
		try {
			sam1.ustawKosztUtrzymania(-2.0);
			} catch (SprawdzKosztUtrzymania e) {
				logger.error(e);
		}
		
		try {
			sam1.ustawKosztUtrzymania(28.0);
			
		} catch (SprawdzKosztUtrzymania e) {
			e.printStackTrace();
			logger.error("niepoprawna cena"+sam1.pobierzNazwa());
		}
		
		
		sam3.ustawMarka(Rodzajesamochodow.Honda);
		
		firma.dodajsamochod(sam1);
		firma.dodajsamochod(sam2);
		firma2.dodajsamochod(sam3);
		firma.usunSamochod(firma.znajdzNazweSamochodu("Maluch 126p"));
		
		System.out.print("Nazwa fimy i jej dane ");
		firma.wypiszFirme();
		System.out.println("Jaka posiada flote samochodow");
		firma.wypiszSamochody();
				
		System.out.println("____________________________");
		
		System.out.print("Nazwa fimy i jej dane ");
		firma2.wypiszFirme();
		System.out.println("Jaka posiada flote samochodow");
		firma2.wypiszSamochody();
		
		ZarzadcaWydarzeniami  zarzadzaj = new ZarzadcaWydarzeniami();
		ISamochodProces myjnia = new CzyszczenieSam();
		

		System.out.println("===========================");
		System.out.println("## Test Events ##");
		firma.znajdzMarke(Rodzajesamochodow.Honda).ustawMyjnia(true);

		System.out.println("458 italia  przed -" + firma.znajdzNazweSamochodu("458 italia").czyJestWMyjni());
		

		
		zarzadzaj.dodajProces(myjnia);
		zarzadzaj.realizujProsesy(firma.znajdzMarkiSamochodow(Rodzajesamochodow.Honda));

		System.out.println("458 italia  po - " + firma.znajdzNazwySamochodow("458 italia").get(0).czyJestWMyjni());
		
	}
}
