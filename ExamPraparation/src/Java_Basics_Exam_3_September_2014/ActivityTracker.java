package Java_Basics_Exam_3_September_2014;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ActivityTracker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int dataLines = Integer.parseInt(input.nextLine());
		
		Map<Integer, List<User>> activityOfUsers = new TreeMap<Integer, List<User>>();
		for (int i = 0; i < dataLines; i++) {
			String[] dataLineArgs = input.nextLine().split("\\s+");
			String[] date = dataLineArgs[0].split("/");
			int month = Integer.parseInt(date[1]);
			String userName = dataLineArgs[1];
			int distance = Integer.parseInt(dataLineArgs[2]);
			
			if (!activityOfUsers.containsKey(month)) {
				activityOfUsers.put(month, new ArrayList<User>());
			}
			
			boolean hasUser = false;
			for (User user : activityOfUsers.get(month)) {
				if (user.getName().equals(userName)) {
					user.addDistance(distance);
					hasUser = true;
					break;
				}
			}
			
			if (!hasUser) {
				User user = new User(userName, distance);
				activityOfUsers.get(month).add(user);
			}
		}
		
		printActivityOfUsers(activityOfUsers);
	}

	private static void printActivityOfUsers(
			Map<Integer, List<User>> activityOfUsers) {
		for (int month : activityOfUsers.keySet()) {
			ArrayList<User> users = (ArrayList<User>) activityOfUsers.get(month);
			Collections.sort(users, comparing(User::getName));
			String usersString = users.toString();
			
			System.out.println(String.format("%d: %s", 
					month, usersString.substring(1, usersString.length() - 1)));
		}
	}

}

class User implements Comparator<String> {
	private String name;
	private int distance;
	
	public User(String name, int distance) {
		this.name = name;
		this.distance = distance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public int addDistance(int distance) {
		return this.distance +=distance;
	}
	
	@Override
	public int compare(String name1, String name2) {
		if (name1.compareTo(name2) < 0) {
			return -1;
		} else if (name1.compareTo(name2) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%s(%d)", this.name, this.distance));
		
		return result.toString();
	}

}