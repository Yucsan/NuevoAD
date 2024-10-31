package test;

import java.util.List;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
import entidades.Empleado;

public class JPAConsultados {

	public static void main(String[] args) {
		PlazaParkingFacadeImpl  pf=new PlazaParkingFacadeImpl();
		DireccionFacadeImpl  df=new DireccionFacadeImpl(); 
		EmpleadoFacadeImpl ef=new EmpleadoFacadeImpl();
		DepartamentoFacadeImpl dpf=new DepartamentoFacadeImpl();
		ProyectoFacadeImpl pyf=new ProyectoFacadeImpl();
		/* ejercicio 1 crea un metodo con consulta JPQL y uso de createQuery que
		 * devuelva todos los empleados de la empresa
		 * 
		 * ejecucion de sentencias JPQL con createQuery
		*/
		System.out.println("**********");
		System.out.println("*Ejer1 consultas todos los empleados");
		System.out.println("**********");
		System.out.println("**"
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ "*****");
		List<Empleado> listaEmpleados=ef.mostrarTodos();
		System.out.println(listaEmpleados);
		
		/* Ejercicio 2 crea un metodo que devuelva todos los proyectos
		 * 
		 * del departamento del codigo depa1
		 * 
		 * ejecucion de sentencias JPQL (con createQuery)
		 * con parámetros dinámicos
		 * */
		
		System.out.println("**********");
		System.out.println("*Ejer2 consultas Mostrar Proyectos");
		System.out.println("**********");
		System.out.println(pyf.buscarProyectoDeDpto("depa1"));
		

	}

}
