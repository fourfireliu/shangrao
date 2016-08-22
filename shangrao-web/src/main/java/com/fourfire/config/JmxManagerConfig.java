package com.fourfire.config;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fourfire.operator.TestMBean;
import com.fourfire.operator.Test;

@Configuration
public class JmxManagerConfig {
	@Bean(name="mbeanServer")
	public MBeanServer mbeanServer() throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, MalformedObjectNameException {
		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
		TestMBean testBean = new Test();
		mBeanServer.registerMBean(testBean, new ObjectName("MyMBean:name=testBean"));
		
		return mBeanServer;
	}
}
