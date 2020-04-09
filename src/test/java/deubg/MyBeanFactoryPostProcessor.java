package deubg;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.Set;

/**
 * @ClassName MyBeanFactoryPostProcessor
 * @Description TODO
 * @Author USER
 * @Date 2020/3/24 21:39
 * @Company
 **/
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	// 敏感词列表
	private Set<String> obsenties;

	public MyBeanFactoryPostProcessor(Set<String> obsenties) {
		this.obsenties = obsenties;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		String[] beanNames = beanFactory.getBeanDefinitionNames();
		for(String beanName:beanNames){
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			StringValueResolver resolver = new StringValueResolver() {
				@Override
				public String resolveStringValue(String strVal) {
					// 敏感词处理
					if(isObscene(strVal)){
						return "******";
					}
					return strVal;
				}
			};
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(resolver);
			visitor.visitBeanDefinition(bd);
		}
	}

	private boolean isObscene(String strVal) {
		return this.obsenties.contains(strVal);
	}
}
