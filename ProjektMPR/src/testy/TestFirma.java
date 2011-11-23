package testy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Wypozyczalnie_samochodow.*;

public class TestFirma {
	Firma firmatest = new Firma("Aniol", 5842453 );
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	Samochod sam = new Samochod("Legend", Rodzajesamochodow.Honda , 1111);
	firmatest.dodajsamochod(sam);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFirma() throws SprawdzKosztUtrzymania {
	Firma firmatest2 = new Firma("g-Data", 65542453);
	Samochod sam2 = new Samochod("VTX", Rodzajesamochodow.Honda, 19.8);
	firmatest2.dodajsamochod(sam2);
	assertTrue(firmatest2.pobierzListeSamochodow().size() == 1);
	assertTrue(firmatest2.pobierzNazweFirmy().equals("g-Data"));
	}

	
	@Test
	public void testDodajSamochod() throws SprawdzKosztUtrzymania {
	assertTrue(firmatest.pobierzListeSamochodow().size() == 1);
	}

	@Test
	public void testPobierzNazweFirmy() {
	assertTrue(firmatest.pobierzNazweFirmy() == "g-Data");
	}

	@Test
	public void testSetName() {
	firmatest.ustawNazwefirmy("Onet");
	assertTrue(firmatest.pobierzNazweFirmy() == "Onet");
	}


	

	@Test
	public void testZnajdzMarkiSamochodow() {
	assertNotNull(firmatest.znajdzMarkiSamochodow(Rodzajesamochodow.Honda));
	assertTrue(firmatest.znajdzMarkiSamochodow(Rodzajesamochodow.Honda).size() > 0 );
	}

	
	@Test
	public void testFindBooksTitle() {
	assertNotNull(firmatest.znajdzNazwySamochodow("Legend"));
	assertTrue(firmatest.znajdzNazwySamochodow("Legend").size() > 0 );
	}

	

	
	
	
}
