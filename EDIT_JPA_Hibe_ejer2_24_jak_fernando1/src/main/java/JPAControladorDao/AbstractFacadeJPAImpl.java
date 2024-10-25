package JPAControladorDao;

import entidades.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.UtilJPA;

public abstract class AbstractFacadeJPAImpl<T> implements AbstractFacadeJPA<T> {
	 
	private Class<T> entityClass;
	protected EntityManager em; 
	//podemos permitir el acceso directo en las clases hijas o crear un getEm()
	
	public AbstractFacadeJPAImpl(Class<T> entityClass) {
		this.entityClass=entityClass;
		em = UtilJPA.getEntityManager();
	}

	@Override
	public Boolean create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		}catch(Exception ex) {
			em.getTransaction().rollback();
			System.out.println("Ha ocurrido un error al Guardar, clave duplicada");
			return false;
		}
	}

	@Override
	public Boolean update(T entity) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
			
			em.merge(entity);//update va con merge
			
			tx.commit();
			System.out.println(entity + "Actualizacion exitosa");
			return true;
		}catch(Exception ex) {
			tx.rollback();
			System.out.println("Ha ocurrido un error");
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public void remove(T entity) {
		EntityTransaction tx=em.getTransaction();
		tx.begin();
			em.remove(em.merge(entity));
			System.out.println("BORRAAAAAA");
		tx.commit();
	}

	@Override
	public T find(Object id) {
		return em.find(entityClass, id);
	}

	@Override
	public EntityManager getEm() {
		return em;
	}
	
	//public Boolean create(T e)
	
	
}
