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
	
	public CityController() {
		dao = new SqlDao();
		cities = new ArrayList<>();
	}
	
	public void loadCity() {		
		try {
			cities = dao.loadCities();
		} catch (Exception e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
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

	public ArrayList<City> getCities() {
		return cities;
	}	
	
} // CityController