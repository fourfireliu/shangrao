package com.fourfire.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZkClientTest {
	public static void main(String args[]) throws IOException, InterruptedException {
		ZkManagerImpl manager = new ZkManagerImpl();
//		System.out.println("bbb");
//
//		CountDownLatch latch = new CountDownLatch(1);
//		latch.await();
//		System.out.println("AAA");
//		synchronized (manager) {
//			manager.wait();
//
//		}
		String path = "/liuyi";
//		byte[] data = "fourfire".getBytes();
//		
		String path1 = "/liuyi/tair";
//		
		byte[] data1 = "ursaminor".getBytes();
//		
////		manager.create(path, data);
		System.out.println(manager.getZNodeStats(path));
		System.out.println("begin to update");
		manager.update(path, data1);
//		manager.create(path1, data);
////		manager.update(path1, data);
		System.out.println("finish update");
//		System.out.println(manager.getZNodeChildren(path));
//		//System.out.println(manager.get)
		System.out.println(manager.getZNodeData(path, true));
		System.in.read();
		
	}
}
