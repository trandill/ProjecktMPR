package testy;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Wypozyczalnie_samochodow.*;

public class testSamochod {
	Firma firmatest = new Firma("Aniol", 5842453 );

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	Samochod sam = new Samochod("ducato", Rodzajesamochodow.Fiat, 19.8);
	firmatest.dodajsamochod(sam);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSamochodow() {
	assertTrue(firmatest.pobierzListeSamochodow().size()>0);
	}

	

	@Test
	public void testPobierzNazwe() {
	assertTrue(firmatest.pobierzListeSamochodow().get(0).pobierzNazwa().equals("ducato"));
	}

	@Test
	public void testUstawNazwe() {
	firmatest.pobierzListeSamochodow().get(0).ustawNazwe("Maria");
	assertTrue(firmatest.pobierzListeSamochodow().get(0).pobierzNazwa().equals("Maria"));
	}

	@Test
	public void testPobierzKosztUtrzymania() throws SprawdzKosztUtrzymania {
	assertTrue(firmatest.pobierzListeSamochodow().get(0).pobierzKosztUtrzymania()==19.8);
	}

	@Test
	public void testUstawKosztUtrzymania() throws SprawdzKosztUtrzymania {
	firmatest.pobierzListeSamochodow().get(0).pobierzKosztUtrzymania();
	assertTrue(firmatest.pobierzListeSamochodow().get(0).pobierzKosztUtrzymania()==20);
	}

	@Test
	public void testczyJestWMyjni()  {
	assertTrue(firmatest.pobierzListeSamochodow().get(0).czyJestWMyjni()==false);
	}

	@Test
	public void testUstawMyjnie() {
	firmatest.pobierzListeSamochodow().get(0).ustawMyjnia(false);
	assertTrue(firmatest.pobierzListeSamochodow().get(0).czyJestWMyjni()==false);
	}
}
