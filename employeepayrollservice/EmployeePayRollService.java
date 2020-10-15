package com.capgemini.employeepayrollservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {
	public enum IOservice{FILE_IO,CONSOLE_IO,DATABASE_IO,REST_IO}
	private List<employeePayrollData> employeePayRollList;
	//constructor
	public EmployeePayRollService(){
	}
	//constructor with parameter
	public EmployeePayRollService(List<employeePayrollData> list) {
		this.employeePayRollList=list;
	}
    public static void main(String[] args) {
		Scanner consoleUserInput = new Scanner(System.in);
		ArrayList<employeePayrollData> employeePayRollList = new ArrayList();
		EmployeePayRollService employeePayRollService =new EmployeePayRollService(employeePayRollList);
		employeePayRollService.readEmployeePayRollData(consoleUserInput);
		employeePayRollService.writeData(IOservice.CONSOLE_IO);
	}
	private void writeData(IOservice consoleIo) {
		// TODO Auto-generated method stub
		
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
	public void writeEmployeePayRollService(IOservice ioservice) {
		if(ioservice.equals(ioservice.CONSOLE_IO)) {
			System.out.println("Employee Pay Roll List:"+employeePayRollList);
		}
		else if(ioservice.equals(ioservice.FILE_IO)){
			new EmployeePayRollFileIOService().writeData(employeePayRollList);
		}
		
	}
	public void printData(IOservice ioService) {
		new  EmployeePayRollFileIOService().printData();
	}

	public long countEntries(IOservice ioService) {
		if(ioService.equals(IOservice.FILE_IO)) 
			return new EmployeePayRollFileIOService().countEntries();
		return 0;
	}
	public List<employeePayrollData> readData(IOservice ioservice) {
		if(ioservice.equals(IOservice.FILE_IO))
			 return new EmployeePayRollFileIOService().readData();
		else 
			return null;
	}

}
