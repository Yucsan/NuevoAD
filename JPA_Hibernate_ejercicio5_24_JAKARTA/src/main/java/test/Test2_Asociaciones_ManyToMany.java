package test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test2_Asociaciones_ManyToMany {
	public static void main(String[] args) {
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Persistencia");
		EntityManager emanager = emfactory.createEntityManager(); // poner en dos lineas

		
		
		
		
		
		
		
		
		//se recomienda cerrar
		emanager.close();
		emfactory.close();
			
		
			
			
			
			
			
			
	}

}
