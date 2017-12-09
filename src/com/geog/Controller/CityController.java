package com.geog.Controller;

import java.sql.*;
import java.util.*;
import javax.faces.application.*;
import javax.faces.context.*;
import javax.faces.bean.*;

import com.geog.DAO.SqlDao;
import com.geog.Model.*;
@ManagedBean
@ApplicationScoped
public class CityController {
	private ArrayList<City> cities;
	private final SqlDao dao;
	private SearchCities search;
	private City choice;
	
	// CityController
	public CityController() {
		dao = new SqlDao();
		cities = new ArrayList<>();
	}
	
	
	/************************************************************************************************/
	/**********************************   Load City   ***********************************************/
	/************************************************************************************************/
	public void loadCity() {		
		try {
			cities = dao.loadCities();
		} catch (Exception e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	/************************************************************************************************/
	/**********************************   Search City   *********************************************/
	/************************************************************************************************/
	public String searchCity(SearchCities search) {
		try {
			cities = dao.findCities(search);
			return "city_search_results.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	
	// City ArrayList
	public ArrayList<City> getCities() {
		return cities;
	}
	
	// add
	public String add(City city) {
		try {
			 dao.addCity(city);
			 return "list_cities.xhtml";
		} catch (SQLException e) {	
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}		
		return null;
	}

	
	/************************************************************************************************/
	/**********************************   All City Details   ****************************************/
	/************************************************************************************************/
	public String allCityDetails(final City city) {
		this.choice = city;
		return "allCityDetails.xhtml";
	}
	
	public City getChoice() {
		return choice;
	}


	public void setChoice(City choice) {
		this.choice = choice;
	}
	
} // CityController