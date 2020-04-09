package deubg;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class TestXmlBeanFactory {

	public static void main(String[] args) {
		ClassPathResource xmlResource=new ClassPathResource
				("application-context-test.xml");


		DefaultListableBeanFactory factory=new DefaultListableBeanFactory();

		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);

		reader.loadBeanDefinitions(xmlResource);

	}
}
