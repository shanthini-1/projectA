package com.chainsys.miniproject.commonutils;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExceptionManager {
	public void HandleException(Exception er,String source,String message) {
		ConfigurableApplicationContext apcontext = new ClassPathXmlApplicationContext("Employee.xml");
		LogManager.logException(er,source);
		message +="message: "+er.getMessage();
//		String errorPage=HTMLHelper.getHTMLTemplate("ERROR",message);
//		return errorPage;
				
	}
}
