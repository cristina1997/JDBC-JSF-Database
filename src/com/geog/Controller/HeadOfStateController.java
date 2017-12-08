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

@ManagedBean
@ApplicationScoped
public class HeadOfStateController {
	private ArrayList<HeadsOfState> headsOfState;
	private final MongoDBDao dao;

	public HeadOfStateController() {
		dao = new MongoDBDao();
		headsOfState = new ArrayList<>();
	}

	public void loadHeadsOfState() {		
		try {
			headsOfState = dao.loadHeadsOfState();
		} catch (Exception e) {
			FacesMessage message = 	new FacesMessage("Error: "+ e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public ArrayList<HeadsOfState> getHeadsOfState() {
		return headsOfState;
	}
	
} // HeadOfStateController