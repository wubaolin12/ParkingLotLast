package org.great.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 解决session共享问题
 * 
 * @author 吴宝林
 *
 */
@Component
public class RedisSession {

	@Resource
	JedisClient jedisClient;

	private String token;// 自定义sessionID

	private HttpServletRequest request;// 获取请求头

	/**
	 * 设置存储在redis的对象
	 * 
	 * @param key
	 * @param value
	 */
	public void setAttribute(String key, Object value) {

		request.getSession().setAttribute(key, value);
		
		if(value==null){
				return;
		}
		if(value instanceof List<?>) {
			System.out.println("这是list类型---");
			JSONArray jsonList = JSONArray.fromObject(value);
			value=jsonList;
		} else if (value instanceof String||value instanceof Integer) {
			System.out.println("这是String类型---");
//			jedisClient.set(key + ":" + token, value.toString());
			
		}else {
			System.out.println("这是bean类型---"+value.toString());
			JSONObject json = JSONObject.fromObject(value);
			value = json;
		}
		jedisClient.set(key + ":" + token, value.toString());
		jedisClient.expire(key + ":" + token, 1800);// 设置过期时间

	}

	/**
	 * 获取存储在redis的对象
	 * 
	 * @param key
	 * @param value
	 */
	public Object getAttribute(String key, Class clazz) {

		String value = jedisClient.get(key + ":" + token);

		System.out.println("value---" + value);
		Object obj=null;
		if(value==null) {
			return null;
		}
		if(value.startsWith("[")) {
			JSONArray json = JSONArray.fromObject(value);
			obj = JSONArray.toArray(json, clazz);
		} else if (value.startsWith("{")) {
			JSONObject json = JSONObject.fromObject(value);
			obj = JSONObject.toBean(json, clazz);
		}else {
			obj=value;
		}

		request.getSession().setAttribute(key, obj);
		jedisClient.expire(key + ":" + token, 1800);// 设置过期时间

		return obj;
	}

	/**
	 * 删除reids的值
	 * 
	 * @param key
	 */
	public void removeSession(String key) {

		jedisClient.del(key + ":" + token);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

}
