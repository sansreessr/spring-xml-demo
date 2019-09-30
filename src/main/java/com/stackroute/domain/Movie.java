package com.stackroute.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Movie implements ApplicationContextAware, BeanFactoryAware, BeanNameAware {

    private Actor actor;
    private ApplicationContext context = null;
    private BeanFactory factory =null;
    private String name = "";

    public Movie() {}

    public Movie(Actor actor) {
        this.actor = actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }

    @Override
    public void setBeanFactory(BeanFactory factory) throws BeansException {
        this.factory = factory;
        System.out.println("Actor info from Movie class using BeanFactoryAware: " + factory.getBean("actor"));
    }

    @Override
    public void setBeanName(String s) {
        this.name = s;
        System.out.println("Bean name using BeanNameAware: " + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
        System.out.println("Actor info from Movie class using ApplicationContextAware: " + context.getBean("actor"));
    }
}
