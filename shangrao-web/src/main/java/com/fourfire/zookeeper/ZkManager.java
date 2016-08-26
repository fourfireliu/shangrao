package com.fourfire.zookeeper;

import java.util.List;

import org.apache.zookeeper.data.Stat;

public interface ZkManager {
	public void create(String path, byte[] data);
	
	public Stat getZNodeStats(String path);
	
	public Object getZNodeData(String path, boolean watchFlag);
	
	public void update(String path, byte[] data);
	
	public List<String> getZNodeChildren(String path);
	
	public void delete(String path);
}
