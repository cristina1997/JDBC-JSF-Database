package com.geog.Controller;

import java.sql.*;
import java.util.*;
import javax.faces.application.*;
import javax.faces.context.*;
import javax.faces.bean.*;

import com.geog.DAO.SqlDao;
import com.geog.Model.Country;

@ManagedBean
@ApplicationScoped
public class CountryController {
	private ArrayList<Country> countries;
	private final SqlDao dao;
	private Country choice;
	
	// CountryController
	public CountryController() {
		dao = new SqlDao();
		countries = new ArrayList<>();
		choice = new Country();
	}		
	
	/************************************************************************************************/
	/**********************************   Load Country   ********************************************/
	/************************************************************************************************/
	public void loadCountry() {		
		try {
			countries = dao.loadCountries();
		} catch (Exception e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
		
	// Country ArrayList
	public ArrayList<Country> getCountries() {
		return countries;
	}

	// add
	public String add(Country country) {
		try {
			 dao.addCountry(country);
			 return "list_countries.xhtml";
		} catch (SQLException e) {	
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return null;
	}
	
	// delete
	public String delete(Country country){
		try {
			dao.deleteCountry(country);
		} catch (SQLException e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return "list_countries.xhtml";
		
	}

	// update
	public String update(final Country country) {
		choice = country;
		return "updateCountry";
	}
	
	// execute update
	public String executeUpdate() {
		try {
			dao.updateCountry(choice);
		} catch (SQLException e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return null;
	}

	public Country getChoice() {
		return choice;
	}


	public void setChoice(Country choice) {
		this.choice = choice;
	}
	
	
} // CountryController