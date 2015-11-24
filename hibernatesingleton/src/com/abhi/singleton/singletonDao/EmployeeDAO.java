package com.abhi.singleton.singletonDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.abhi.singleton.singleton.HibernateUtility;
import com.abhi.singleton.singletonDto.EmployeeDTO;

public class EmployeeDAO {

	public static void main(String[] args) {

		EmployeeDTO employeeDTO=new EmployeeDTO();
		
		System.out.println("entering data into 1st row");
		employeeDTO.setName("Abhijit");
		employeeDTO.setDept("Developer");
		employeeDTO.setSal(500000.00);
		
		System.out.println("entering data into 2nd row");
		employeeDTO.setName("Amit");
		employeeDTO.setDept("Developer");
		employeeDTO.setSal(1200000.00);
		
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		session.save(employeeDTO);
		transaction.commit();
		
	}
	
}
