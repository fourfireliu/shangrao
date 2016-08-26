package com.fourfire.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.util.CollectionUtils;

public class ZkManagerImpl implements ZkManager {
	
	private static ZkConnection zkConnection;
	private static ZooKeeper zookeeper;
	
	public ZkManagerImpl() {
		try {
			initilize();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void initilize() throws IOException, InterruptedException {
		zkConnection = new ZkConnection();
		zookeeper = zkConnection.connect("10.128.160.232:4180");
	}
	
	public void closeConnection() throws InterruptedException {
		zkConnection.close();
	}

	@Override
	public void create(String path, byte[] data) {
		try {
			zookeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Stat getZNodeStats(String path) {
		try {
			Stat stat = zookeeper.exists(path, true);
			return stat;
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Object getZNodeData(String path, boolean watchFlag) {
		byte[] data = null;
		try {
			if (getZNodeStats(path) != null) {
				if (watchFlag) {
					ZkWatcher watcher = new ZkWatcher();
					data = zookeeper.getData(path, watcher, null);
				} else {
					data = zookeeper.getData(path, null, null);
				}
				
				return new String(data, "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update(String path, byte[] data) {
		try {
			Stat stat = zookeeper.exists(path, true);
			if (stat != null) {
				int version = zookeeper.exists(path, true).getVersion();
				System.out.println("current version=" + version);
				zookeeper.setData(path, data, version);
			} else {
				zookeeper.setData(path, data, 1);
			}
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> getZNodeChildren(String path) {
		Stat stat = getZNodeStats(path);
		if (stat != null) {
			try {
				List<String> children = zookeeper.getChildren(path, false);
				if (!CollectionUtils.isEmpty(children)) {
					for (String child : children) {
						System.out.println("child=" + child);
					}
				}
				
				return children;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@Override
	public void delete(String path) {
		try {
			int version = zookeeper.exists(path, true).getVersion();
			zookeeper.delete(path, version);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
