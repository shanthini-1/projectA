package com.chainsys.springproject.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.chainsys.project.component.MobilePhone;
import com.chainsys.springproject.appconfig.AppConfig;
import com.chainsys.springproject.beans.Employee;

public class TestAnnotationConfig {
  public static void testA() {
	  ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		 Employee emp = ac.getBean(Employee.class);
		  emp.setName("shan"); 
		  emp.setId(101); emp.print();
		  Employee secondemp = ac.getBean(Employee.class);
		 	
  }
  public static void testPhone() {
	  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
                ac.scan("com.chainsys.project.component");
                ac.refresh();
                MobilePhone phone = ac.getBean(MobilePhone.class);
                phone.setPhoneNumber(6379388297l);
                long number = phone.getPhoneNumber();
                System.out.println("phone number"+ number);
                ac.close();
  }
}
