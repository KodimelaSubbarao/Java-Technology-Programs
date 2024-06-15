package com.sa.listeners;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

@WebListener
public class RequestMonitoringListener implements ServletRequestListener 
{
	private long start,end;
	public RequestMonitoringListener() {
		System.out.println("RequestMonitoringListener.RequestMonitoringListener() 0-param constructor");
	}
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestMonitoringListener.requestInitialized()");
		start =System.currentTimeMillis();
		
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestMonitoringListener.requestDestroyed()");
		end=System.currentTimeMillis();
		HttpServletRequest hsreq=(HttpServletRequest)sre.getServletRequest();
		System.out.println(hsreq.getRequestURI()+" request has taken at :: "+(end-start)+" ms");
	}
}
