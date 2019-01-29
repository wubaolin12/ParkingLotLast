package org.great.util;

/**
 * redis数据库接口
 * @author Administrator
 *
 */
public interface JedisClient {

	
	/**
	 * 添加建值对
	 * @param key
	 * @param value
	 * @return
	 */
	public String set(String key, String value);
	
	/**
	 * 设置过期时间
	 * @param key
	 * @param seconds
	 * @return
	 */
	public Long expire(String key, int seconds);
	
	/**
	 *	 根据key取值
	 * @param key
	 * @return
	 */
	public String get(String key);
	
	/**
	 * 删除key
	 * @param key
	 * @return
	 */
	public Long del(String key);
}
