package com.chainsys.springproject.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chainsys.miniproject.commonutils.InvalidInputDataException;
import com.chainsys.miniproject.commonutils.Validator;

public class EmployeeController {
	public   void addNewEmployee() {

		Scanner sc = new Scanner(System.in);
		Employee newEmp = new Employee();
		System.out.println("Enter Employee id");
		String id = sc.nextLine();
		int empId;
		try {
			Validator.checkStringForParse(id);
			 empId = Integer.parseInt(id);

		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}
	
		try {
			Validator.CheckNumberForGreaterThanZero(empId);
			newEmp.setEmp_id(Integer.parseInt(id));
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
		}

		
		System.out.println("Enter Employee FirstName");
		String Fname = sc.nextLine();
		try {
			Validator.checkStringOnly(Fname);
			Validator.checklengthOfString(Fname);
			newEmp.setFirst_name(Fname);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();      
			return;

		}

		System.out.println("Enter Employee LastName");

		String Lname = sc.nextLine();
		try {
			Validator.checkStringOnly(Lname);
			Validator.checklengthOfString(Lname);
			newEmp.setLast_name(Lname);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}

		System.out.println("Enter Employee Email");
		String email=(sc.nextLine());
		try {
			Validator.checkMail(email);
			newEmp.setEmail(email);
		} catch (InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		

		System.out.println("Enter Employee job_id");

		String jobid = sc.nextLine();
		try {
			Validator.checkjob(jobid);
			newEmp.setJob_id(jobid);
		}catch(InvalidInputDataException err) {
			err.printStackTrace();
		}
		
		System.out.println("Enter Employee Hire_Date");
		String sDate = sc.nextLine();
		Date date = null;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			Validator.checkDateFormat(sDate);
			newEmp.setHire_date(date);
		}catch(InvalidInputDataException err) {
			err.printStackTrace();
		}


		System.out.println("Enter Employee Salary");
		String salary = sc.nextLine();
		Float fsalary;
		try {
			Validator.checkStringForParseFloat(salary);
			fsalary = Float.parseFloat(salary);

		} 
		catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}try {
			Validator.checkSalLimit(fsalary);
			newEmp.setSalary(fsalary);
		}catch(InvalidInputDataException err) {
			err.printStackTrace();
		}finally {
			sc.close();
		}
        int result;
		
			result = EmployeeDao.insertEmployee(newEmp);
		
		System.out.println(result);
		
		
		
		
	}

	public   void updateNewEmployee() {

		java.util.Scanner sc = new java.util.Scanner(System.in);
		Employee oldEmp = new Employee();
		System.out.println("Enter Employee Id");
		String id = sc.nextLine();
		int empId;
		try {
			Validator.checkStringForParse(id);
		  empId = Integer.parseInt(id);

		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}
		
		try {
			Validator.CheckNumberForGreaterThanZero(empId);
			Employee emp = null;
			try {
				emp = EmployeeDao.getEmployeeById(empId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (emp == null) {
				System.out.println("Employee Doesn't Exit For Id" + empId);
				return;
			}
			oldEmp.setEmp_id(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;}
		

		System.out.println("Enter Employee FirstName:");
		String Fname = sc.nextLine();
		try {
			Validator.checkStringOnly(Fname);
			Validator.checklengthOfString(Fname);
			oldEmp.setFirst_name(Fname);
		} catch (InvalidInputDataException err1) {
			err1.printStackTrace();
			return;

		}

		// TODO- Validate Fname
		System.out.println("Enter Employee LastName:");
		String Lname = sc.nextLine();
		try {
			Validator.checkStringOnly(Lname);
		} catch (InvalidInputDataException err1) {
			err1.printStackTrace();
			return;

		}

		oldEmp.setLast_name(Lname);
		System.out.println("Enter Employee Email:");

		String email=sc.nextLine();
		try {
			Validator.checkMail(email);
		} catch (InvalidInputDataException e) {
			e.printStackTrace();
			return;
		}
		oldEmp.setEmail(email);
		System.out.println("Enter Employee Hire_Date");
		String sDate = sc.nextLine();
		Date date;
		try {
			date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
			oldEmp.setHire_date(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			Validator.checkDateFormat(sDate);
			oldEmp.getHire_date();
		}catch(InvalidInputDataException err1) {
			err1.printStackTrace();
		}

		System.out.println("Enter Employee job_id:");
		String jobid = sc.nextLine();
		try {
			Validator.checkjob(jobid);
			oldEmp.setJob_id(jobid);
		}catch(InvalidInputDataException err1) {
			err1.printStackTrace();
		}
		
		System.out.println("Enter Employee Salary:");
		String salary = sc.nextLine();

		String sal = sc.nextLine();
		float salParse=0;
		try {
			Validator.checkStringForParseFloat(sal);
		     salParse = Float.parseFloat(sal);
		} catch (InvalidInputDataException err1) {
			err1.printStackTrace();
		}
		
		try {
		Validator.checkSalLimit(salParse);
		 oldEmp.setSalary(salParse);
		}catch(InvalidInputDataException er) {
			er.printStackTrace();
		}finally {
			sc.close();
		}
	   

		int result = 0;
		try {
			result = EmployeeDao.updateEmployee(oldEmp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);}
	

	public   void updateEmployeeFirstName() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id");
		String id = sc.nextLine();
		// TODO -Validate input String
		int empId = 0;
		try {
			Validator.checkStringForParse(id);
			empId = Integer.parseInt(id);

		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}

		try {
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
		}

		System.out.println("Enter alter Employee First_name");
		String Fname = sc.nextLine();
		try {
			Validator.checkStringOnly(Fname);
            Validator.checklengthOfString(Fname);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}finally {
			sc.close();
		}

		int result = 0;
		try {
			result = EmployeeDao.updateEmployeeFirstName(empId, Fname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);

	}

	public   void updateEmployeeSalary() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id");
		String id = sc.nextLine();
		int empId = 0;
		try {
			Validator.checkStringForParse(id);
			empId = Integer.parseInt(id);

		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}

		try {
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
		}
		System.out.println("Enter alter Employee Salary");
		String sal = sc.nextLine();
		float salParse=0;
		try {
			Validator.checkStringForParseFloat(sal);
			 salParse = Float.parseFloat(sal);
			
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
		}
		
		try {
		Validator.checkSalLimit(salParse);
		}catch(InvalidInputDataException err) {
			err.printStackTrace();
		}finally {
			sc.close();
		}
	
		

		int result = EmployeeDao.updateEmployeeSalary(Integer.parseInt(id), Float.parseFloat(sal));
		System.out.println(result);

	}

	public   void deleteEmployeeById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id");
		String s1 = sc.nextLine();
		int empId = 0;
		try {
			Validator.checkStringForParse(s1);
			empId = Integer.parseInt(s1);

		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}

		try {
			EmployeeDao.getEmployeeById(empId);
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
		}finally {
			sc.close();
		}
		int result = EmployeeDao.deleteEmployee(empId);
		System.out.println(result);

	}

	public   void getEmployeeById() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id");
		String s1 = sc.nextLine();
		int empId = 0;
		try {
			Validator.checkStringForParse(s1);
			empId = Integer.parseInt(s1);

		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;

		}

		try {
			Validator.CheckNumberForGreaterThanZero(empId);
		} catch (InvalidInputDataException err) {
			err.printStackTrace();
			return;
		}finally {
			sc.close();
		}

		Employee emp = EmployeeDao.getEmployeeById(empId);
		System.out.println(emp.getEmp_id() + " " + emp.getFirst_name() + " " + emp.getLast_name() + " " + emp.getEmail()
				+ " " + emp.getJob_id() + " " + emp.getSalary());

	}

	public   void getAllEmployee() {

		List<Employee> allEmployees = EmployeeDao.getAllEmployee();
		Iterator<Employee> empiterator = allEmployees.iterator();
		while (empiterator.hasNext()) {
			Employee emp = empiterator.next();
			System.out.println(emp.getEmp_id() + " " + emp.getFirst_name() + " " + emp.getLast_name() + " "
					+ emp.getEmail() + " " + emp.getJob_id() + " " + emp.getSalary());
		}

	}

}
