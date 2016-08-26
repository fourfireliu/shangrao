package com.fourfire.zookeeper;

import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.AsyncCallback.StatCallback;
import org.apache.zookeeper.data.Stat;

public class ZkWatcher implements Watcher, StatCallback {
	//CountDownLatch countDownLatch;
	
	public ZkWatcher() {
		//countDownLatch = new CountDownLatch(1);
	}

	@Override
	public void processResult(int rc, String path, Object ctx, Stat stat) {
		
	}

	@Override
	public void process(WatchedEvent event) {
		System.out.println("watch event, path=" + event.getPath() + 
				", state=" + event.getState() + ", type=" + event.getType());
		//countDownLatch.countDown();
	}
	
//	public void await() throws InterruptedException {
//		countDownLatch.await();
//	}

}
