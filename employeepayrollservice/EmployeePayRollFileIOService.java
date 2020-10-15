package com.capgemini.employeepayrollservice;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayRollFileIOService {
	private static String PAY_ROLE_FILE = "src/payroll-file.txt";
	public void writeData(List<employeePayrollData> employeePayRollList) {
		StringBuffer empBuffer=new StringBuffer();
		employeePayRollList.forEach(employee ->{
			String employeeDataString=employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAY_ROLE_FILE),empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printData() {
		try {
			Files.lines(new File("payroll-file.txt").toPath()).forEach(System.out::println);;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public long countEntries() {
		long entries=0;
		try {
			entries=Files.lines(new File("payroll-file.txt").toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
	public List<employeePayrollData> readData() {
		List<employeePayrollData> employeePayRollList=new ArrayList<employeePayrollData>();
		try {
			Files.lines(new File(PAY_ROLE_FILE).toPath()).map(line->line.trim()).forEach(line->{
				String data = line.toString();
				String[] dataArr = data.split(",");
				for(int i=0;i<dataArr.length;i++){
					int id = Integer.parseInt(dataArr[i].replaceAll("id =", ""));
					i++;
					String name = dataArr[i].replaceAll("name =", "");
					i++;
					double salary = Double.parseDouble(dataArr[i].replaceAll("salary =", ""));
					employeePayrollData employeePayrollData = new employeePayrollData(id,name,salary);
					employeePayRollList.add(employeePayrollData);
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employeePayRollList;
	}

}
