package org.springframework.mytest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestContextGetBean
 * @Description TODO
 * @Author USER
 * @Date 2020/3/24 9:28
 * @Company
 **/
public class TestContextGetBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		TestContextGetBean bean = context.getBean(TestContextGetBean.class);
		System.out.println(bean);
	}
}
