package com.geog.Model;
import javax.faces.bean.*;

@ManagedBean
public class HeadsOfState {
	private String _id;
	private String headOfState;
	
	public HeadsOfState() {}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getHeadOfState() {
		return headOfState;
	}

	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

} // HeadsOfState 
