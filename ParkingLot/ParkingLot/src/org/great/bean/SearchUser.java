package org.great.bean;

public class SearchUser {

	public String group_id;
	public String user_id;
	public String user_info;
	public float score;
	public SearchUser(String group_id, String user_id, String user_info, float score) {
		super();
		this.group_id = group_id;
		this.user_id = user_id;
		this.user_info = user_info;
		this.score = score;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_info() {
		return user_info;
	}
	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
	
}
