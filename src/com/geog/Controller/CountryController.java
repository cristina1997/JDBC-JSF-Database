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
	
	public CountryController() {
		dao = new SqlDao();
		countries = new ArrayList<>();
		choice = new Country();
	}	
	
	public void loadCountry() {		
		try {
			countries = dao.loadCountries();
		} catch (Exception e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
		
	public ArrayList<Country> getCountries() {
		return countries;
	}

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
	
	public String delete(Country country){
		try {
			dao.deleteCountry(country);
		} catch (SQLException e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return "list_countries.xhtml";
		
	}

	public String update(final Country country) {
		choice = country;
		return "updateCountry";
	}
	
	public String executeUpdate() {
		try {
			return dao.updateCountry(choice);
		} catch (SQLException e) {
			return "updateCountry";
		}

	}

	public Country getChoice() {
		return choice;
	}


	public void setChoice(Country choice) {
		this.choice = choice;
	}
	
	
} // CountryController