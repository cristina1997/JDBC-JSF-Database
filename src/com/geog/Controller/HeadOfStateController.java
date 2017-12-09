package com.geog.Controller;

import java.sql.*;
import java.util.*;
import javax.faces.application.*;
import javax.faces.context.*;
import javax.faces.bean.*;

import com.geog.DAO.MongoDBDao;
import com.geog.DAO.SqlDao;
import com.geog.Model.Country;
import com.geog.Model.HeadsOfState;
import com.geog.Model.Region;

@ManagedBean
@ApplicationScoped
public class HeadOfStateController {
	private ArrayList<HeadsOfState> headsOfState;
	private final MongoDBDao dao;

	// HeadOfStateController
	public HeadOfStateController() {
		dao = new MongoDBDao();
		headsOfState = new ArrayList<>();
	}
	
	
	/************************************************************************************************/
	/**********************************   Load Heads of State   *************************************/
	/************************************************************************************************/
	public void loadHeadsOfState() {		
		try {
			headsOfState = dao.loadHeadsOfState();
		} catch (Exception e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	// Heads Of State ArrayList
	public ArrayList<HeadsOfState> getHeadsOfState() {
		return headsOfState;
	}
	
	// add
	public String add(HeadsOfState headsOfState) {
		dao.addHeadsOfState(headsOfState);
		return "list_heads_of_state.xhtml";
	}
	
	// delete
	public String delete(HeadsOfState headsOfState){
		dao.deleteHeadsOfState(headsOfState);
		return "list_countries.xhtml";
		
	}
} // HeadOfStateController