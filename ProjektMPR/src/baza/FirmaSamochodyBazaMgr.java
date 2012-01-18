package baza;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import Wypozyczalnie_samochodow.*;



public class FirmaSamochodyBazaMgr {

	private Connection polaczenie;
	private Statement statement;
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private PreparedStatement dodajFirmaSamochodStmt;
	private PreparedStatement usunSamochodZFirmyStmt;
	private PreparedStatement pobierzFirmaSamochodStmt;
	private PreparedStatement usunWszystkieFirmySamochodyStmt;
	
	public FirmaSamochodyBazaMgr() {
		try {
			
			
			polaczenie = DriverManager.getConnection(url);

			statement = polaczenie.createStatement();
			boolean FirmaSamochodCzyTabelaIstnieje = false;

			ResultSet rs = polaczenie.getMetaData().getTables(null, null, null, null);

			while (rs.next()) {
				if ("FirmaSamochod".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					FirmaSamochodCzyTabelaIstnieje = true;
					break;
				}
			}

			if (!FirmaSamochodCzyTabelaIstnieje) {
				statement.executeUpdate("CREATE TABLE FirmaSamochod(firma_id bigint, samochod_id bigint, FOREIGN KEY (firma_id) REFERENCES Firma (id),"
						+ " FOREIGN KEY (samochod_id) REFERENCES Samochod (id))");
			}

			dodajFirmaSamochodStmt = polaczenie.prepareStatement("INSERT INTO FirmaSamochod (firma_id, samochod_id) VALUES (?, ?)");

			usunSamochodZFirmyStmt = polaczenie.prepareStatement("DELETE FROM FirmaSamochod WHERE firma_id = ?");

			usunWszystkieFirmySamochodyStmt = polaczenie.prepareStatement("DELETE FROM FirmaSamochod");

			pobierzFirmaSamochodStmt = polaczenie
					.prepareStatement("SELECT samochod.nazwa, samochod.marka FROM Samochod,"
							+ " FirmaSamochod WHERE firma_id = ? and samochod_id = samochod.id");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void dodajSamochodyDoFirmy(List<Integer> FirmaLista,
			List<Integer> SamochodLista) {
		try {
			for (Integer FirmaID : FirmaLista) {
				for (Integer samochodID : SamochodLista) {
					dodajFirmaSamochodStmt.setInt(1, FirmaID);
					dodajFirmaSamochodStmt.setInt(2, samochodID);
					dodajFirmaSamochodStmt.executeUpdate();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	
	public void usunWszystko() {
		try {
			usunSamochodZFirmyStmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	
	public void pobierzFirmaSamochody(List<Integer> firmaLista, List<Integer> samochodLista) {
		
		try {
			for (Integer firmaID : firmaLista) {
				for (Integer samochodID: samochodLista) {
					dodajFirmaSamochodStmt.setInt(1, firmaID);
					dodajFirmaSamochodStmt.setInt(2, samochodID);
					dodajFirmaSamochodStmt.executeUpdate();
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}