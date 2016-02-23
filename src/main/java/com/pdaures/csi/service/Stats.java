package com.pdaures.csi.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Stores statistics about the visits
 */
@Service(value="stats")
public class Stats {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Stats.class);

	//Counter format : <metric_key,value>
	private Map<String, Long> counters;
	
	//visitors : set of different visitors
	private Set<Key> visitors;


	public Stats(){
		this.counters = new HashMap<String, Long>();
		this.visitors = new HashSet<Key>();
	}

	public void incrementCountryCounter(String country){
		String key = formatKey(country);
		if(counters.containsKey(key)){
			counters.put(key, counters.get(key)+1L);
		} else {
			counters.put(key, 1L);
		}
		LOGGER.info("Country counter : "+key +": "+counters.get(key));
	}
	
	public void addDailyVisitor(String userId){
		String id = formatKey(userId);
		Key key = new Key(id);
		visitors.add(key);
		LOGGER.info("Daily visitors :"+visitors.size());
	}

	
	private String formatKey(String input){
		return input.toUpperCase();
	}
	
	/**
	 * Key for Cardinality set
	 * @author pdaures
	 *
	 */
	private class Key {
		
		public String metric;
		
		public Key(String metric){
			this.metric = metric;
		}
	}
}
