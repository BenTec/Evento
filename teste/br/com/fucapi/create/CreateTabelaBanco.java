package br.com.fucapi.create;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;


public class CreateTabelaBanco {

	@Test
	public void createTables(){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_PROJETO");
		factory.close();
	}
}
