package org.great.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
	
	//Ҫִ�в���������
	public String operationType() default "";
	
	//Ҫִ�в��������֡�
	public String operationName() default "";
	
	

}
