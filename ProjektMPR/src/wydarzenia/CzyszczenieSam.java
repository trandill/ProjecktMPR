package wydarzenia;


import java.util.Calendar;
import java.util.GregorianCalendar;
import org.apache.log4j.Logger;

public class CzyszczenieSam implements ISamochodProces {
	
	private static Logger logger = Logger.getLogger(CzyszczenieSam.class);
    Calendar calendar = GregorianCalendar.getInstance();

	@Override
	public void procesSamochod(WydarzeniaSam wydarzenie) {
		wydarzenie.pobierz_samochod().ustawMyjnia(true);
		logger.info(wydarzenie.pobierz_samochod().pobierzNazwa() + " - samochod w myjni " + calendar.getTime());
	}
}
