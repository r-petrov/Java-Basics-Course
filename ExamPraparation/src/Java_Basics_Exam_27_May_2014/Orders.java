package Java_Basics_Exam_27_May_2014;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Orders {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfOrders = Integer.parseInt(input.nextLine());
		
		// Process the input orders and put them in a map
		Map<String, Map<String, Integer>> orders = new LinkedHashMap<String, Map<String,Integer>>();
		for (int i = 0; i < numberOfOrders; i++) {
			String[] orderArgs = input.nextLine().split(" ");
			String customer = orderArgs[0];
			int orderAmount = Integer.parseInt(orderArgs[1]);
			String product = orderArgs[2];
			
			if (!orders.containsKey(product)) {
				orders.put(product, new TreeMap<String, Integer>());
			}
			
			if (!orders.get(product).containsKey(customer)) {
				orders.get(product).put(customer, orderAmount);
			} else {
				int totalOrderAmount = orders.get(product).get(customer) + orderAmount;
				orders.get(product).put(customer, totalOrderAmount);
			}
		}
		
		printOrders(orders);
	}

	private static void printOrders(Map<String, Map<String, Integer>> orders) {
		for (String product : orders.keySet()) {
			List<String> customers = new ArrayList<String>();
			for (String customer : orders.get(product).keySet()) {
				String customerOrder = customer + " " + orders.get(product).get(customer);
				customers.add(customerOrder);
			}
			
			String customersOutput = customers.toString().substring(1, customers.toString().length() - 1);
			System.out.print(String.format("%s: %s%n", product, customersOutput));
		}
	}

}
