package org.great.bean;

import java.util.ArrayList;

/**
 * 
 * @author 孔大帅人脸识别返回值
 *
 */
public class Msg {
	public int error_code;
	public String error_msg;
	public long log_id;
	public long timestamp;
	public int cached;
	public Result result;
	
	public Msg(int error_code, String error_msg, long log_id, long timestamp, int cached, Result result) {
		super();
		this.error_code = error_code;
		this.error_msg = error_msg;
		this.log_id = log_id;
		this.timestamp = timestamp;
		this.cached = cached;
		this.result = result;
	}
	
	public float showScore() {
		return result.score;
	}
}
class Result{
	public float score;
	public ArrayList<Object> face_list;
	
	public Result(float score, ArrayList<Object> face_list) {
		super();
		this.score = score;
		this.face_list = face_list;
	}
	
	
}

