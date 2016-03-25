import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class UserLogs {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		
		Map<String, LinkedHashMap<String, Integer>> users = new TreeMap<String, LinkedHashMap<String,Integer>>();
		
		while (!line.equals("end")) {
			String[] messages = line.split(" ");
			String ip = messages[0];
			String user = messages[2];
			final int NEXT_MASSAGE = 1;
			
			if (!users.containsKey(user)) {
				users.put(user, new LinkedHashMap<String, Integer>());
			}
			
			if (users.get(user).containsKey(ip)) {
				users.get(user).put(ip, users.get(user).get(ip) + NEXT_MASSAGE);
			} else {
				users.get(user).put(ip, NEXT_MASSAGE);
			}
			
			line = input.nextLine();
		}
		
		printUsers(users);
	}

	private static void printUsers(
			Map<String, LinkedHashMap<String, Integer>> users) {
		for (String user : users.keySet()) {
			System.out.println(user.replaceAll("user=", "") + ":");
			
			List<String> ipMessages = new ArrayList<String>();
			for (String ip : users.get(user).keySet()) {
				ipMessages.add(String.format("%s => %d", ip.replaceAll("IP=", ""), users.get(user).get(ip)));
			}
			
			
			for (int i = 0; i < ipMessages.size(); i++) {
				boolean isBeforeLastMessage = i != (ipMessages.size() - 1);
				String commaOrPoint;
				if (isBeforeLastMessage) {
					commaOrPoint = ", ";
				} else {
					commaOrPoint = ".";
				}
				String currentMessage = ipMessages.get(i);
				currentMessage += commaOrPoint;
				System.out.print(currentMessage);
			}
			System.out.println();
		}
	}

}
