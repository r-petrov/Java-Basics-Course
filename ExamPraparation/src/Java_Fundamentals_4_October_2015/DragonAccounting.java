package Java_Fundamentals_4_October_2015;

import java.util.Scanner;

public class DragonAccounting {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
	}

}

class Worker {
	private int startDay;
	private int days;
	private double salary;
	
	public Worker(int startDay, double salary) {
		this.setStartDay(startDay);
		this.days = 1;
		this.setSalary(salary);
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	
	public int getDays() {
		return days;
	}

	public double getSalary() {
		if (this.days < 30) {
			return (this.salary / 30) * this.days;
		} else {
			return (this.salary / 30) * 30;
		}
		
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void raiseDays() {
		this.days++;
	}
	
	private void raiseSalary() {
		if (this.days > 365) {
			this.salary *= 0.6;
		}
	}
	
	
}