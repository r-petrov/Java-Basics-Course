package Java_Fundamentals_4_October_2015;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		Scanner input = new Scanner(System.in);
		int numberOfDragons = Integer.parseInt(input.nextLine());
		
//		Map<String, Set<Dragon>> dragons = new LinkedHashMap<String,  Set<Dragon>>();
//		for (int i = 0; i < numberOfDragons; i++) {
//			String[] dragonStats = input.nextLine().split(" ");
//			String dragonType = dragonStats[0];
//			String dragonName = dragonStats[1];
//			Integer dragonDamage = Integer.parseInt(dragonStats[2]);
//			Integer dragonHealth = Integer.parseInt(dragonStats[3]);
//			Integer dragonArmor = Integer.parseInt(dragonStats[4]);
//			
//			if (!dragons.containsKey(dragonType)) {
//				dragons.put(dragonType, new TreeSet<Dragon>());
//			}
//			
//			Dragon dragon = new Dragon(dragonType, dragonName, dragonDamage, dragonHealth, dragonArmor);
//			dragons.get(dragonType).add(dragon);
//		}
//		
//		System.out.println(dragons);
		
		Map<String, Map<String, Dragon>> dragons = new LinkedHashMap<String,  Map<String, Dragon>>();
		for (int i = 0; i < numberOfDragons; i++) {
			String[] dragonStats = input.nextLine().split(" ");
			String dragonType = dragonStats[0];
			String dragonName = dragonStats[1];
			String dragonDamageString = dragonStats[2];
			Integer dragonDamage = null;
			if (!dragonDamageString.equals("null")) {
				dragonDamage = Integer.parseInt(dragonStats[2]);
			}
			
			String dragonHealthString = dragonStats[3];
			Integer dragonHealth = null;
			if (!dragonHealthString.equals("null")) {
				 dragonHealth = Integer.parseInt(dragonStats[3]);
			}
			
			String dragonArmorString = dragonStats[4];
			Integer dragonArmor = null;
			if (!dragonArmorString.equals("null")) {
				dragonArmor = Integer.parseInt(dragonStats[4]);
			}
			
			if (!dragons.containsKey(dragonType)) {
				dragons.put(dragonType, new TreeMap<String, Dragon>());
			}
			
			Dragon dragon = new Dragon(dragonType, dragonName, dragonDamage, dragonHealth, dragonArmor);
			dragons.get(dragonType).put(dragonName, dragon);
		}
		
		for (String dragonType : dragons.keySet()) {
			Map<String, Dragon> currentDragons = dragons.get(dragonType);
			double averageDamage = getDragonsAverageDamage(currentDragons);
			double averageHealth = getDragonsAverageHealth(currentDragons);
			double averageArmor = getDragonsAverageArmor(currentDragons);
			
			System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", 
					dragonType, averageDamage, averageHealth, averageArmor));
			for (String dragonName : currentDragons.keySet()) {
				Dragon dragon = currentDragons.get(dragonName);
				System.out.println(dragon.toString());
			}
		}
	}
	
	static double getDragonsAverageDamage(Map<String, Dragon> dragons) {
		double averageDamage = 0.0;
		for (String name : dragons.keySet()) {
			averageDamage += dragons.get(name).getDamage();
		}
		
		return averageDamage / (double) dragons.size();
	}
	
	static double getDragonsAverageHealth(Map<String, Dragon> dragons) {
		double averageHealth = 0.0;
		for (String name : dragons.keySet()) {
			averageHealth += dragons.get(name).getHealth();
		}
		
		return averageHealth / (double) dragons.size();
	}
	
	static double getDragonsAverageArmor(Map<String, Dragon> dragons) {
		double averageArmor = 0.0;
		for (String name : dragons.keySet()) {
			averageArmor += dragons.get(name).getArmor();
		}
		
		return averageArmor / (double) dragons.size();
	}

}

class Dragon implements Comparable<String> {
	final int DEFAULT_DAMAGE = 45;
	final int DEFAULT_HEALTH = 250;
	final int DEFAULT_ARMOR = 10;

	private String type;
	private String name;
	private Integer damage;
	private Integer health;
	private Integer armor;
	
	

	public Dragon(String type, String name, Integer damage, Integer health,
			Integer armor) {
		this.setType(type);
		this.setName(name);
		this.setDamage(damage);
		this.setHealth(health);
		this.setArmor(armor);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		if (type.equals(null) || type.length() == 0) {
			throw new IllegalArgumentException("Dragon type cannot by null.");
		}

		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.equals(null) || name.length() == 0) {
			throw new IllegalArgumentException("Dragon name cannot by null.");
		}
		
		this.name = name;
	}

	public Integer getDamage() {
		return damage;
	}

	public void setDamage(Integer damage) {
		if (damage == null) {
			this.damage = DEFAULT_DAMAGE;
			return;
		} else {
			this.damage = damage;
		}
		
		
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		if (health == null) {
			this.health = DEFAULT_HEALTH;
			return;
		}
		
		this.health = health;
	}

	public Integer getArmor() {
		return armor;
	}

	public void setArmor(Integer armor) {
		if (armor == null) {
			this.armor = DEFAULT_ARMOR;
			return;
		}
		
		this.armor = armor;
	}

	@Override
	public int compareTo(String name) {
		if (this.name.compareTo(name) < 0) {
			return -1;
		} else if (this.name.compareTo(name) == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("-%s -> damage: %d, health: %d, armor: %d", 
				this.name, this.damage, this.health, this.armor));
		
		return result.toString();
	}
	
}