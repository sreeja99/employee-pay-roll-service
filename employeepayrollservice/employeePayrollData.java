package com.capgemini.employeepayrollservice;

public class employeePayrollData {
	private int user_id;
	private String name;
	private double salary;

	public employeePayrollData(int user_id,String name,double salary) {
		this.user_id=user_id;
		this.name=name;
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "id = " + user_id + ", name = " + name + ", salary = " + salary;
	}
}
