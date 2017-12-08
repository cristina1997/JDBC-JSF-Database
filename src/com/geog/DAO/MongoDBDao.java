package com.geog.DAO;
import java.util.*;

import org.bson.*;
import com.google.gson.*;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.connection.*;
import com.geog.Model.Country;
import com.geog.Model.HeadsOfState;

public class MongoDBDao {
	private Connection conn;
	
	// Connection
	public Connection getConnection() {
		return conn;
	} // getConnection
	
	/************************************************************************************************/
	/**********************************   Load Heads of State   *************************************/
	/************************************************************************************************/
	public ArrayList<HeadsOfState> loadHeadsOfState(){
		final ArrayList<HeadsOfState> headsOfStateList = new ArrayList<HeadsOfState>();
		Gson gson = new Gson();
		FindIterable<Document> heads = ((MongoCollection<Document>) connect()).find();	
		
		for (Document hos : heads) {
			final HeadsOfState head = gson.fromJson(hos.toJson(), HeadsOfState.class);
			headsOfStateList.add(head);			
		}		
		return headsOfStateList;		
	} // loadHeadsOfState
	
	
	/************************************************************************************************/
	/**********************************   Add Heads of State   **************************************/
	/************************************************************************************************/
	public void addHeadsOfState(final HeadsOfState headsOfState) {
		
	} // addHeadsOfState
	
	/**************************************************************************************************/
	/**********************************   Delete Heads of State   *************************************/
	/**************************************************************************************************/
	public void deleteHeadsOfState(HeadsOfState headsOfState) {
		
	} // deleteHeadsOfState
	
	// Connect
	private MongoCollection<Document> connect() {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase stateDatabase = mongoClient.getDatabase("headsOfStateDB");
		MongoCollection<Document> stateCollection = stateDatabase.getCollection("headsOfState");
		
		return stateCollection;
	} // connect
} // MongoDBDao
