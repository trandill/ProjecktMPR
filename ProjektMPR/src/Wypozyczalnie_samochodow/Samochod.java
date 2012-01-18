package Wypozyczalnie_samochodow;




public class Samochod {
	public Integer ID;
	public String nazwa;
	private double kosztUtrzymania;
	public Integer rokProdukcji;
	public String marka;
	public boolean myjnia;
	
	public Samochod(){}
	
	
	
	public Samochod(String nazwa,String  marka, Integer rokProdukcji, Double kosztUtrzymania)
	{
		this.nazwa=nazwa ;
		this.marka=marka;
		this.rokProdukcji=rokProdukcji;
		this.kosztUtrzymania=kosztUtrzymania;
	}
	
	public Samochod(String nazwa,String  marka, Double kosztUtrzymania)
	{
		this.nazwa=nazwa ;
		this.marka=marka;
		this.kosztUtrzymania=kosztUtrzymania;
	}
	public Samochod(String nazwa, Double kosztUtrzymania)
	{
		this.nazwa=nazwa ;
		this.kosztUtrzymania=kosztUtrzymania;
	}
	public Samochod(String nazwa,String  marka, Integer rokProdukcji)
	{
		this.nazwa=nazwa ;
		this.marka=marka;
		this.rokProdukcji=rokProdukcji;
		
	}
	
	public boolean czyJestWMyjni() {
		return myjnia;
	}

	public void ustawMyjnia(boolean myjnia) {
		this.myjnia = myjnia;
	}
	
	public void wypiszSamochody()
	{
		System.out.println("Nazwa samochodu: "+ nazwa + "\t Rok produkcji "+ rokProdukcji +"\t koszt utrzymania na miesiac: " + kosztUtrzymania + "PLN" );
	}
	
	public void ustawKosztUtrzymania(double kosztUtrzymania) throws SprawdzKosztUtrzymania
	{
		if (kosztUtrzymania <0)
				throw new SprawdzKosztUtrzymania("kosztUtrzymania nie moze byc ujemna");
		else this.kosztUtrzymania=kosztUtrzymania;
	}
	
	public String pobierzNazwa() {
		return nazwa;
	}

	public void ustawNazwe(String nazwa) {
		this.nazwa = nazwa;
	}
				
	public String poberzMarka() {
		return marka;
	}
	
	public void ustawMarka(String marka) {
		this.marka = marka;
	}
	
	public Integer pobierzRokProdukcji() {
		return rokProdukcji;
	}

	public void ustawRokProdukcji(Integer rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}
	
	public Double pobierzKosztUtrzymania() {
		return kosztUtrzymania;
	}

	public void ustawKosztUtrzymania(Double kosztUtrzymania) throws SprawdzKosztUtrzymania {
		this.kosztUtrzymania = kosztUtrzymania;
	}
	
	public Integer pobierzID() {
		return ID;
	}

	public void ustawID(Integer Id) {
		this.ID = ID;
	}
	

}
