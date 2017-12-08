package com.geog.Controller;

import java.sql.*;
import java.util.*;
import javax.faces.application.*;
import javax.faces.context.*;
import javax.faces.bean.*;

import com.geog.DAO.SqlDao;
import com.geog.Model.Country;
import com.geog.Model.Region;

@ManagedBean
@ApplicationScoped
public class RegionController {
	private ArrayList<Region> regions;
	private final SqlDao dao;
	
	public RegionController() {
		dao = new SqlDao();
		regions = new ArrayList<>();
	}
	
	public void loadRegion() {		
		try {
			regions = dao.loadRegions();
		} catch (Exception e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public ArrayList<Region> getRegions() {
		return regions;
	}
	
	public String add(Region region) {
		try {
			 dao.addRegion(region);
			 return "list_regions.xhtml";
		} catch (SQLException e) {	
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return null;
	}
	

} // RegionController