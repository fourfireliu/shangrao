package com.fourfire;

import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value=10)
public class MyCommandLineRunner implements CommandLineRunner {
	@Autowired
	private MBeanServer mbeanServer;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello from here");
		
		LocateRegistry.createRegistry(8888);  
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:8888/server");  
        JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbeanServer);  
        System.out.println("....................begin rmi start.....");  
        cs.start();  
        System.out.println("....................rmi start.....");  
	}

}
