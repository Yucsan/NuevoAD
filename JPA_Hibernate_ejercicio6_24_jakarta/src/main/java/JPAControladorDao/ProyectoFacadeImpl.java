package JPAControladorDao;

import java.util.List;

import entidades.PlazaParking;
import entidades.Proyecto;
import jakarta.persistence.TypedQuery;

public class ProyectoFacadeImpl extends AbstractFacadeJPAImpl<Proyecto> {

	public ProyectoFacadeImpl() {
		super(Proyecto.class);
	}
	
	public List<Proyecto> mostrarTodos(){
		TypedQuery<Proyecto> q = em.createQuery("SELECT p FROM Proyecto as p",Proyecto.class);
		return q.getResultList();
	}
	
	public List<Proyecto> buscarProyectoDeDpto(String dep){
		TypedQuery<Proyecto> q = this.getEm().createQuery("SELECT p FROM Proyecto p WHERE p.departamento.codDept=:seleccionado", Proyecto.class);
		q.setParameter("seleccionado", dep);
		
		return q.getResultList();
	}

}
