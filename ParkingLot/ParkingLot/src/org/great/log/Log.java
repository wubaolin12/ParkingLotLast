package org.great.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 操作事件
 * @author 吴宝林
 *
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	
	/**
	 * 要执行的操作类型  比如：增加操作
	 * @return
	 */
	public String operationType() default "";
	
	/**
	 * 要执行的具体操作  比如：添加用户
	 * @return
	 */
	public String operationName() default "";
	
	

}
