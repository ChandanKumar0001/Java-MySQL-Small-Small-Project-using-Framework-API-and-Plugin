package com.jsp.spring.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jsp.spring.annotations.horse.Horse;
import com.jsp.spring.annotations.tiger.Tiger;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        Tiger tiger = ac.getBean(Tiger.class);
        tiger.sound();
        
        //Upcasting
//        Tiger tiger2 = (Tiger) ac.getBean("tiger");
//        tiger.sound();
        
        Horse horse = ac.getBean(Horse.class);
        horse.sound();
    }
}
