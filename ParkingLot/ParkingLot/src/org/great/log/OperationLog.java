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
/*
 * @Target：该注解说明了Annotation(注解)所修饰的对象范围
 * METHOD：用于描述方法
 * PARAMETER：用于描述参数
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
/*
 * 	@Retention：定义该注解的生命周期，
 * RUNTIME : 始终不会丢弃，运行期也保留该注解，
 * 	因此可以使用反射机制读取该注解的信息
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 * @Documented用于描述其它类型的注解应该被作为被标注的程序成员的公共API；
 * 	被修饰的注解会生成到javadoc中
 */
@Documented
public @interface OperationLog {
	
	/**
	 * 要执行的操作类型  比如：操作用户
	 * @return
	 */
	public String operationType() default "";
	
	/**
	 * 要执行的具体操作  比如：添加用户
	 * @return
	 */
	public String operationName() default "";
	
	

}
