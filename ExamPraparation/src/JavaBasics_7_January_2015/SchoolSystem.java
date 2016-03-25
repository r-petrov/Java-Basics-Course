package JavaBasics_7_January_2015;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class SchoolSystem {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		Scanner input = new Scanner(System.in);
		int numberOfLines = Integer.parseInt(input.nextLine());
		
		Map<String, Student> students = new TreeMap<String, Student>();

		try {
			for (int i = 0; i < numberOfLines; i++) {
				String[] inputArgs = input.nextLine().split("\\s+");
				String firstName = inputArgs[0];
				String lastName = inputArgs[1];
				String subject = inputArgs[2];
				double grade = Double.parseDouble(inputArgs[3]);

				String fullName = firstName + " " + lastName;
				if (!students.containsKey(fullName)) {
					students.put(fullName, new Student(firstName, lastName));
				}
				students.get(fullName).addSubject(subject);
				students.get(fullName).addGrade(subject, grade);

			}
		} catch (IllegalArgumentException illArgEx) {
			illArgEx.printStackTrace();
		}
		
		printStudents(students);
	}

	private static void printStudents(Map<String, Student> students) {
		for (Entry entry : students.entrySet()) {
			System.out.println(entry.getValue().toString());
		}
	}

}

class Student {
	private String firstName;
	private String lastName;
	private Map<String, List<Double>> subjects;

	public Student(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.subjects = new TreeMap<String, List<Double>>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			throw new IllegalArgumentException(
					"Student's first name cannot be empty.");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.isEmpty()) {
			throw new IllegalArgumentException(
					"Student's last name cannot be empty.");
		}
		this.lastName = lastName;
	}

	public Map<String, List<Double>> getSubjects() {
		return this.subjects;
	}

	public void addSubject(String subject) {
		if (!this.subjects.containsKey(subject)) {
			this.subjects.put(subject, new ArrayList<Double>());
		}
	}

	public void addGrade(String subject, double grade) {
		this.subjects.get(subject).add(grade);
	}
	
	private double getAverageGrade(String subject) {
		double averageGrade = this.subjects.get(subject)
				.stream()
				.mapToDouble(g -> g)
				.average()
				.getAsDouble();
		return averageGrade;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("%s %s: ", this.firstName, this.lastName));
		if (this.subjects.size() > 0) {
			result.append("[");
			Iterator<Entry<String, List<Double>>> iterator = this.subjects.entrySet().iterator();
			for (Entry entrySubjects : this.subjects.entrySet()) {
				Map.Entry<java.lang.String, java.util.List<java.lang.Double>> entry = 
						(Map.Entry<java.lang.String, java.util.List<java.lang.Double>>) iterator.next();
				if (iterator.hasNext()) {
					result.append(String.format("%s - %.2f, ", 
							entry.getKey(), 
							this.getAverageGrade(entry.getKey().toString())));
				} else {
					result.append(String.format("%s - %.2f]", 
							entry.getKey(), 
							this.getAverageGrade(entry.getKey().toString())));
				}
			}
		}
		
		return result.toString();
	}
	
}
