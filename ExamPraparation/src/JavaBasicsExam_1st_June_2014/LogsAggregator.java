package JavaBasicsExam_1st_June_2014;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfUsers = Integer.parseInt(input.nextLine());
		
		Map<String, Map<String, Integer>> users = new TreeMap<String, Map<String,Integer>>();
		for (int i = 0; i < numberOfUsers; i++) {
			String[] inputArgs = input.nextLine().split("\\s+");
			String ip = inputArgs[0];
			String user = inputArgs[1];
			int duration = Integer.parseInt(inputArgs[2]);
			
			if (!users.containsKey(user)) {
				users.put(user, new TreeMap<String, Integer>());
				
			} 
			if (!users.get(user).containsKey(ip)) {
				users.get(user).put(ip, duration);
			} else {
				users.get(user).put(ip, users.get(user).get(ip) + duration);
			}
				
		}
		
		printUsers(users);
	}

	private static void printUsers(Map<String, Map<String, Integer>> users) {
		for (Entry entry : users.entrySet()) {
			int totalDuration = calculateTotalDuration((TreeMap<String, Integer>) users.get(entry.getKey()));
			TreeSet<String> ips = createIpsCollection(users.get(entry.getKey()));
			
			System.out.printf("%s: %d %s\n", entry.getKey(), totalDuration, ips);
		}
	}
	
	static TreeSet<String> createIpsCollection(Map<String, Integer> ipDurations) {
		TreeSet<String> ips = new TreeSet<String>();
		for (Entry entry : ipDurations.entrySet()) {
			ips.add(entry.getKey().toString());
		}
		
		return ips;
	}

	static int calculateTotalDuration(Map<String, Integer> ips) {
		int totalDuration = 0;
		for (Entry entry : ips.entrySet()) {
			totalDuration += ips.get(entry.getKey());
		}
		
		return totalDuration;
	}
}
