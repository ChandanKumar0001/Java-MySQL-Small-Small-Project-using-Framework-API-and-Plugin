package com.jsp.spring.ac;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class App 
{
    public static void main( String[] args )
    {
//    	 BeanFactory bf = new XmlBeanFactory(new FileSystemResource("spring_bf.xml"));
//         Mobile mob = bf.getBean(Mobile.class);
//         System.out.println(mob);
         
         ApplicationContext ac = new ClassPathXmlApplicationContext("spring_ac.xml");
         Mobile mobile = ac.getBean(Mobile.class);
         System.out.println(mobile);
    }
}
