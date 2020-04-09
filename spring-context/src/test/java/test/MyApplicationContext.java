package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @ClassName MyApplicationContext
 * @Description TODO
 * @Author USER
 * @Date 2020/3/24 14:35
 * @Company
 **/
public class MyApplicationContext extends AnnotationConfigApplicationContext {
	@Override
	public void setEnvironment(ConfigurableEnvironment environment) {
		super.setEnvironment(environment);
		environment.setRequiredProperties("VAR");
	}
}
