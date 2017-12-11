package com.geog.DAO;
import java.sql.*;
import java.util.*;

import javax.sql.*;
import javax.naming.*;
import com.mysql.jdbc.jdbc2.optional.*;

import com.geog.Model.*;
import com.mysql.jdbc.exceptions.*;


public class SqlDao {
	private Connection conn;
	
	public SqlDao(){
		connect();
	}
	
	// Connection
	public Connection getConnection() {
		return conn;
		
	}
	
	
	/************************************************************************************************/
	/**********************************   Load Country   ********************************************/
	/************************************************************************************************/
	public ArrayList<Country> loadCountries() throws SQLException {	
		final ArrayList<Country> countries = new ArrayList<Country>();
		final Statement stmt = conn.createStatement();		
		final ResultSet rs = stmt.executeQuery("SELECT * FROM country");	

		while(rs.next()) {
			final Country country = new Country();
			country.setCountryCode(rs.getString("co_code"));
			country.setCountryName(rs.getString("co_name"));
			country.setCountryDetails(rs.getString("co_details"));
					
			countries.add(country);
		}
		
		return countries;
	}
	

	/************************************************************************************************/
	/**********************************   Load Regions   ********************************************/
	/************************************************************************************************/
	public ArrayList<Region> loadRegions() throws SQLException {
		final ArrayList<Region> regions = new ArrayList<Region>();
		final Statement stmt = conn.createStatement();		
		final ResultSet rs = stmt.executeQuery("SELECT * FROM region");	

		while(rs.next()) {
			final Region region = new Region();
			region.setCountryCode(rs.getString("co_code"));
			region.setRegionCode(rs.getString("reg_code"));
			region.setRegionDetails(rs.getString("reg_name"));
			region.setRegionName(rs.getString("reg_desc"));
					
			regions.add(region);
		} 
		
		return regions;
	}
	

	/************************************************************************************************/
	/**********************************   Load Cities   *********************************************/
	/************************************************************************************************/
	public ArrayList<City> loadCities() throws SQLException {
		final ArrayList<City> cities = new ArrayList<City>();
		final Statement stmt = conn.createStatement();		
		final ResultSet rs = stmt.executeQuery("SELECT * FROM city");	
		
		while(rs.next()) {
			final City city = new City();
			city.setCityCode(rs.getString("cty_code"));
			city.setCountryCode(rs.getString("co_code"));
			city.setRegionCode(rs.getString("reg_code"));
			city.setCityName(rs.getString("cty_name"));
			city.setPopulation(rs.getInt("population"));
			city.setArea(rs.getDouble("areaKM"));
					
			cities.add(city);
		} 
		return cities;
	}
	
	
	/************************************************************************************************/
	/**********************************   Add Country   *********************************************/
	/************************************************************************************************/
	public void addCountry (final Country country) throws SQLException{	
		final PreparedStatement stmt = conn.prepareStatement("INSERT INTO country VALUES (?,?,?)");
		
		stmt.setString(1, country.getCountryCode());
		stmt.setString(2, country.getCountryName());
		stmt.setString(3, country.getCountryDetails());
		
		stmt.executeUpdate();
		
	} 
	
	
	/************************************************************************************************/
	/**********************************   Add Region   **********************************************/
	/************************************************************************************************/
	public void addRegion(final Region region) throws SQLException {
		final PreparedStatement stmt = conn.prepareStatement("INSERT INTO region VALUES (?,?,?,?)");
		
		stmt.setString(1, region.getCountryCode());
		stmt.setString(2, region.getRegionCode());
		stmt.setString(3, region.getRegionName());
		stmt.setString(4, region.getRegionDetails());
		
		stmt.executeUpdate();
	}


	/************************************************************************************************/
	/**********************************   Add City   ************************************************/
	/************************************************************************************************/
	public void addCity(final City city) throws SQLException {
		final PreparedStatement stmt = conn.prepareStatement("INSERT INTO city VALUES (?,?,?,?,?,?,?)");
		
	    String trueOrFalse;
	    boolean val = city.getIsCoastal();
	    
	    if(!val){
	      trueOrFalse = "false";
	    } else {
	      trueOrFalse = "true";
	    }
	    
		stmt.setString(1, city.getCityCode());
		stmt.setString(2, city.getCountryCode());
		stmt.setString(3, city.getRegionCode());
		stmt.setString(4, city.getCityName());
		stmt.setInt(5, city.getPopulation());
		stmt.setString(6, trueOrFalse);		
		stmt.setDouble(7, city.getArea());
		
		stmt.executeUpdate();
	}

	
	/************************************************************************************************/
	/**********************************   Delete Country   ******************************************/
	/************************************************************************************************/
	public void deleteCountry(Country country) throws SQLException {
		final PreparedStatement stmt = conn.prepareStatement("DELETE FROM country WHERE co_code = ?;");
		
		stmt.setString(1, country.getCountryCode());
		stmt.executeUpdate();
	}	
	
	
	/************************************************************************************************/
	/**********************************   Update Country   ******************************************/
	/************************************************************************************************/
	public String updateCountry(Country country) throws SQLException {
		 PreparedStatement stmt = conn.prepareStatement("UPDATE country SET co_name = ?, co_details = ? WHERE co_code = ?;");

		 stmt.setString(1, country.getCountryName()); 
		 stmt.setString(2, country.getCountryDetails()); 
		 stmt.setString(3, country.getCountryCode());
		 stmt.executeUpdate(); 
		 
		 return "list_countries";		
	}
	
	private final static Map<String, String> mapOperator;

	static { 
		mapOperator = new HashMap<>();
		mapOperator.put("g", ">");
		mapOperator.put("l", "<");
		mapOperator.put("e", "=");
	}
	
	/************************************************************************************************/
	/**********************************   Find City   ***********************************************/
	/************************************************************************************************/
	public ArrayList<City> findCities(final SearchCities search) throws SQLException {		
		ArrayList<City> cities = new ArrayList<>();
		final String compareOperators = mapOperator.get(search.getCompareOperators());
		final int population = search.getPopulation();
//		final String countryCode = search.getCountryCode().isEmpty() ? "%" : search.getCountryCode();
//		final String isCoastal = search.getIsCoastal() ? "TRUE" : "FALSE";
		
		final String countryCode;
		if (search.getCountryCode().isEmpty()) {
			countryCode = "%";
		} else {
			countryCode = search.getCountryCode();
		}
			
	    String isCoastal;
	    if(search.getIsCoastal()){
	      isCoastal = "True";
	    } else {
	      isCoastal = "False";
	    }
	    
		String s = "SELECT * FROM city INNER JOIN country ON country.co_code = city.co_code INNER JOIN region ON city.reg_code = region.reg_code WHERE ";
		if (population > 0) { // ignore population filter if it's 0 - the user doesn't care about population.
			s += "population " + compareOperators + " ? AND ";
		}
	
		s += "city.co_code = ? AND isCoastal = ? ;";
		
		
		final PreparedStatement stmt = conn.prepareStatement(s);
		
		int dataPos = 1;
		if (population > 0) {
			stmt.setInt(dataPos++, population);
		}
		
		stmt.setString(dataPos++, countryCode);
		stmt.setString(dataPos, isCoastal);
		
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {			
			final City city = new City();
			city.setCityCode(rs.getString("cty_code"));
			city.setArea(rs.getDouble("areaKM"));
			city.setIsCoastal(rs.getBoolean("isCoastal"));
			city.setCountryCode(rs.getString("co_code"));
			city.setCityName(rs.getString("cty_name"));
			city.setPopulation(rs.getInt("population"));
			city.setRegionCode(rs.getString("reg_code"));
			city.setRegionName(rs.getString("reg_name"));
			city.setCountryName(rs.getString("co_name"));
			
			cities.add(city);
			
		}

		return cities;
	}
	
	// Connect
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/geography", "root", "");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}				
	}

} // SqlDao
