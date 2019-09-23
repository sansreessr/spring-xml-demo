package com.stackroute;

import com.stackroute.domain.Movie;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main
{
    public static void main( String[] args ) {

        //Using XmlBeanFactory
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        Movie movie = (Movie) factory.getBean("movie");
        System.out.println("Using XmlBeanFactory: " + movie.getActor());

        //Using Spring 3.2 BeanDefinitionRegistry and BeanDefinitionReader
        BeanDefinitionRegistry registry = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(registry);
        BeanFactory factory1 = (BeanFactory) reader.getRegistry();
        Movie movie1 = (Movie) factory1.getBean("movie");
        System.out.println("Using Spring 3.2 BeanDefinitionRegistry and BeanDefinitionReader: " + movie1.getActor());

        //Using ApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie2 = (Movie) context.getBean("movie");
        System.out.println("Using ApplicationContext: " + movie2.getActor());
    }
}
