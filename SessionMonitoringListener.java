package com.sa.listeners;

import java.util.Date;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionMonitoringListener implements HttpSessionListener {
	private long start,end;
	public SessionMonitoringListener() {
		System.out.println("SessionMonitoringListener.SessionMonitoringListener() 0-param constructor" );
	}
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionMonitoringListener.sessionCreated()");
		start= System.currentTimeMillis();
		System.out.println("Session started at :: "+new Date());
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionMonitoringListener.sessionDestroyed()");
		end=System.currentTimeMillis();
		System.out.println("Session ended at :: "+new Date());
		System.out.println("the session duration is :: "+(end-start)+" ms");
	}
}
