package com.cisco.restapimongodb.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DBUtils {

	public static MongoClient	getMongoClient() {
		String mongoDBURI = "mongodb://admin:pwd4abhi@cluster0-shard-00-00-oosu8.mongodb.net:27017,cluster0-shard-00-01-oosu8.mongodb.net:27017,cluster0-shard-00-02-oosu8.mongodb.net:27017/devconnector?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority";
		MongoClient client = new MongoClient(new MongoClientURI(mongoDBURI));
		return client;
	}
	
	private static MongoDatabase database = null;
	public static  MongoDatabase getDatabase() {
		database = getMongoClient().getDatabase("devconnector");
		return database;
	}
	
	
}
