package JPAControladorDao;

import java.util.List;

import entidades.PlazaParking;
import entidades.Proyecto;

public interface ProyectoFacade extends AbstractFacadeJPA<Proyecto>{
	public List<Proyecto> mostrarTodos();
	public List<Proyecto> buscarProyectoDeDpto(String dep); //Integer 
	
}
