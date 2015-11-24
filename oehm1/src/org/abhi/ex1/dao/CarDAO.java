package org.abhi.ex1.dao;

import org.abhi.ex1.dto.CarDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class CarDAO {

	public static void main(String[] args) {

		CarDTO carDTO=new CarDTO();
		carDTO.setId(2);
		carDTO.setColour("Blue");
		carDTO.setModel("BMW");
		carDTO.setPrice(10000000.00);
		
		//hibernate code
		
		Configuration configuration=new Configuration();
		configuration.configure();
		configuration.addResource("carDTO.hbm.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		
		//delete function
		/*CarDTO carDTO=new CarDTO();
		carDTO.setId(2);
		session.delete(carDTO);*/
		
		//fetching data
		/*//CarDTO dto=(CarDTO)session.get(CarDTO.class, 1);
		CarDTO dto=(CarDTO)session.load(CarDTO.class, 1);
		System.out.println(dto);*/
		
		//updating database
		/*session.update(carDTO);*/
		
		session.save(carDTO);
		transaction.commit();
		session.close();
		
		
	}

}
