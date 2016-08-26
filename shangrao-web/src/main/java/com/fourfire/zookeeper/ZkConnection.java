package com.fourfire.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZkConnection {
	private ZooKeeper zookeeper;
	
	final CountDownLatch countDonwLatch = new CountDownLatch(1);
	
	
	public ZkConnection() {
		
	}
	
	public ZooKeeper connect(String host) throws IOException, InterruptedException {
		zookeeper = new ZooKeeper(host, 2000, new Watcher() {

			@Override
			public void process(WatchedEvent event) {
				if (event.getState() == KeeperState.SyncConnected) {
					System.out.println("event: path=" + event.getPath() + 
							", state=" + event.getState() + ", type=" + event.getType());
					countDonwLatch.countDown();
				}
				
			}
			
		});
		
		countDonwLatch.await();
		
		return zookeeper;
	}
	
	public void close() throws InterruptedException {
		zookeeper.close();
	}
}
