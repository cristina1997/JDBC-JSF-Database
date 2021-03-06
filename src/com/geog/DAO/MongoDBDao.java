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
	} 
	
	
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
	} 
	

	/************************************************************************************************/
	/**********************************   Add Heads of State   **************************************/
	/************************************************************************************************/
	public MongoCollection<Document> addHeadsOfState(final HeadsOfState heads) {		
		MongoCollection<Document> collection = connect();
		final Document doc = new Document(); // the document that will be added.
		
		doc.append("_id", heads.get_id());
		doc.append("headOfState", heads.getHeadOfState());
		collection.insertOne(doc);
		
		return collection;	
	} 
	
	
	/**************************************************************************************************/
	/**********************************   Delete Heads of State   *************************************/
	/**************************************************************************************************/
	public void deleteHeadsOfState(HeadsOfState heads) {
		MongoCollection<Document> collection = connect();
		collection.deleteOne(new Document("_id", heads.get_id()));
	} 	
	
	// Connect
	private MongoCollection<Document> connect() {
		MongoClient mongoClient = new MongoClient();
		MongoDatabase stateDatabase = mongoClient.getDatabase("headsOfStateDB");
		MongoCollection<Document> stateCollection = stateDatabase.getCollection("headsOfState");
		
		return stateCollection;
	} 
} // MongoDBDao
