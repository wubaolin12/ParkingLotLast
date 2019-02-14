package org.great.bean;

import java.util.ArrayList;

public class ResultSearch {

	public String face_token;
	public ArrayList<SearchUser> user_list;
	public ResultSearch(String face_token, ArrayList<SearchUser> user_list) {
		super();
		this.face_token = face_token;
		this.user_list = user_list;
	}
	public String getFace_token() {
		return face_token;
	}
	public void setFace_token(String face_token) {
		this.face_token = face_token;
	}
	public ArrayList<SearchUser> getUser_list() {
		return user_list;
	}
	public void setUser_list(ArrayList<SearchUser> user_list) {
		this.user_list = user_list;
	}
	
	
}
