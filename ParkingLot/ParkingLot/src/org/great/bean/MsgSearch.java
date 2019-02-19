package org.great.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author  孔大帅人脸识别返回值
 *
 */
public class MsgSearch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int error_code;
	public String error_msg;
	public long log_id;
	public long timestamp;
	public int cached;
	public ResultSearch result;
	
	public MsgSearch(int error_code, String error_msg, long log_id, long timestamp, int cached, ResultSearch result) {
		super();
		this.error_code = error_code;
		this.error_msg = error_msg;
		this.log_id = log_id;
		this.timestamp = timestamp;
		this.cached = cached;
		this.result = result;
	}
	
	public float showScore() {
		if(error_code==0){
			if(result.user_list.size()!=0){
				return result.user_list.get(0).score;
			}else {
				return 0;
			}
		}else{
			return 0;
		}	
	}
	
	public SearchUser ShowSearched(){
		if(result.user_list.get(0)!=null) {
			return result.user_list.get(0);
		}else {
			return new SearchUser("null", "null", "null", 0);
		}
	}
	
}
/*class ResultSearch{
	public String face_token;
	public ArrayList<SearchUser> user_list;
	public ResultSearch(String face_token, ArrayList<SearchUser> user_list) {
		super();
		this.face_token = face_token;
		this.user_list = user_list;
	}
	
}
*/
/*class SearchUser{
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
	
}*/

