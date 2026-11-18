package com.jsp.spring.Spring_IOC;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class App 
{
    public static void main( String[] args )
    {
    	//Upcasting using Class name it is essential to do
        BeanFactory bf = new XmlBeanFactory(new FileSystemResource("spring.xml"));
        Student student = bf.getBean(Student.class);
        student.learn();
        
        //Downcasting By using id --> we have to downcast it but it is not mandatory(extra)
        Student student2 = (Student) bf.getBean("spring-demo");
        student2.learn();
        
    }
}
