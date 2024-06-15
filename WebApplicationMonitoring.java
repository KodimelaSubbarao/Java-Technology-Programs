package com.sa.listeners;

import java.util.Date;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebApplicationMonitoring implements ServletContextListener 
{
	private long start,end;
	
	public WebApplicationMonitoring() {
		System.out.println("WebApplicationMonitoring.WebApplicationMonitoring() 0-param constructor");
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoring.contextInitialized()");
		start = System.currentTimeMillis();
		System.out.println("Webapplication is deployed/reloaded/started at :: "+new Date());
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebApplicationMonitoring.contextDestroyed()");
		end = System.currentTimeMillis();
		System.out.println("Webapplication is undeployed/reloaded/stoped at :: "+new Date());
		ServletContext sc=sce.getServletContext();
		System.out.println(sc.getContextPath()+" is in continuous running mode of "+(end-start)+" ms");
	}
}
