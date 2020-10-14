package com.capgemini.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
	private List<employeePayrollData> employeePayRollList;
	//constructor
	public EmployeePayRollService(){
	}
	//constructor with parameter
	public EmployeePayRollService(ArrayList<employeePayrollData> employeePayRollList) {
		this.employeePayRollList=employeePayRollList;
	}
    public static void main(String[] args) {
		Scanner consoleUserInput = new Scanner(System.in);
		ArrayList<employeePayrollData> employeePayRollList = new ArrayList();
		EmployeePayRollService employeePayRollService =new EmployeePayRollService(employeePayRollList);
		employeePayRollService.readEmployeePayRollData(consoleUserInput);
		employeePayRollService.writeEmployeePayRollData();
	}
	//taking input from console
	public void readEmployeePayRollData(Scanner consoleUserInput) {
		System.out.println("Enter the Employee ID");
		int user_id=consoleUserInput.nextInt();
		System.out.println("Enter the Employee Name");
		String name=consoleUserInput.next();
		System.out.println("Enter the Employee Salary");
		double salary=consoleUserInput.nextDouble();
		employeePayRollList.add(new employeePayrollData(user_id,name,salary));
	}
	//printing output on console
	public void writeEmployeePayRollData() {
		System.out.println("Employee Pay Roll List:"+employeePayRollList);
	}

}
