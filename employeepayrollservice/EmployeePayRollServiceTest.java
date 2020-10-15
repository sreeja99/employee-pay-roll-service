package com.capgemini.employeepayrollservice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.capgemini.employeepayrollservice.EmployeePayRollService.IOservice;

import junit.framework.Assert;

class EmployeePayRollServiceTest {

	@Test
    public void given3EmployeeWrittenIntoFileShouldMatchTheEntries() {
		employeePayrollData[] arrayOfEmps= {
				new employeePayrollData(1,"Jeff Bozes",100000.0),
				new employeePayrollData(2,"Bill Gates",200000.0),
				new employeePayrollData(3,"Mark Zukerburg",300000.0)
		};
		EmployeePayRollService employeePayRollService;
		employeePayRollService=new EmployeePayRollService(Arrays.asList(arrayOfEmps));
		employeePayRollService. writeEmployeePayRollService(IOservice.FILE_IO);
		employeePayRollService.printData(IOservice.FILE_IO);
		List<employeePayrollData> employeeList = employeePayRollService.readData(IOservice.FILE_IO);
		System.out.println(employeeList);
		long entries=employeePayRollService.countEntries(IOservice.FILE_IO);
		Assert.assertEquals(3, entries);
	}
	@Test
	public void givenFileOnReadingShouldReturnCount() {
		EmployeePayRollService employeePayRollService=new EmployeePayRollService();
		long entries=employeePayRollService.countEntries(IOservice.FILE_IO);
		Assert.assertEquals(3, entries);
	}

}
