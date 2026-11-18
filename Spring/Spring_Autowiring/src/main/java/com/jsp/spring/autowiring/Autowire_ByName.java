package com.jsp.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Autowire_ByName
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Autowire-byName.xml");
        Person person = ac.getBean(Person.class);
        System.out.println(person);
        System.out.println(person.getAddress());
    }
}
