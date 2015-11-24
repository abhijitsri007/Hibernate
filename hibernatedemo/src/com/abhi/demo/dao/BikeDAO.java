package com.abhi.demo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.abhi.demo.dto.BikeDTO;

public class BikeDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BikeDTO bikeDTO=new BikeDTO();
		bikeDTO.setColour("Black");
		bikeDTO.setModel("ninja");
		bikeDTO.setPrice(400000.00);
		
		//hibernate code
		
		Configuration configuration=new Configuration();
		configuration.configure();
		configuration.addResource("bikeDTO.hbm.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Transaction transaction=session.getTransaction();
		transaction.begin();
		session.save(bikeDTO);
		transaction.commit();
		session.close();
		
	}

}
