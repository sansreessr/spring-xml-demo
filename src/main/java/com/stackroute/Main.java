package com.stackroute;

import com.stackroute.domain.Movie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main( String[] args ) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Movie movie = (Movie) context.getBean("movie", Movie.class);
        System.out.println("Actor Info; BeanA: " + movie.getActor());

        Movie movie1 = (Movie) context.getBean("movieB", Movie.class);
        System.out.println("Actor Info; BeanB: " + movie1.getActor());
    }
}
