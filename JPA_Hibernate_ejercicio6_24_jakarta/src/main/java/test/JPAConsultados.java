package test;

import java.util.List;

import JPAControladorDao.DepartamentoFacadeImpl;
import JPAControladorDao.DireccionFacadeImpl;
import JPAControladorDao.EmpleadoFacadeImpl;
import JPAControladorDao.PlazaParkingFacadeImpl;
import JPAControladorDao.ProyectoFacadeImpl;
import entidades.Departamento;
import entidades.Empleado;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

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
		
		
		/* Ejercicio 3 mostrar todos los proyectos del depto de nombre 'contabilidad'

		 * */
		
		System.out.println("**********");
		System.out.println("*3 mostrar todos los proyectos del depto de nombre 'contabilidad'");
		System.out.println("**********");
		System.out.println( pyf.buscarProyectoDeDptoNombre("contabilidad") );
		
		
		//System.out.println(dpf.buscarTodos().get(0).getProyectos()); // sin PQL
		
		
		System.out.println("**********");
		System.out.println("*4 Crea un metodo que devuelva todos los empleados del depto1");
		System.out.println("**********");
		System.out.println(ef.mostrarTodosEmpleadosPorDepa("depa1"));
		
		
		//ejer 5
		//Consulta estática findAll que devuelva todos los empleados
		
		/* Las consultas con nombre son diferentes de las sentencias dinámicas que hemos visto hasta ahora
		 * en el sentido de que una vez definidas, no pueden ser modificadas:
		 * son leidas y transformadas en sentencias SQL cuando el programa arranca por primera vez en lugar 
		 * de cada vez que son ejecutadas. Este comportamiento estático las hace mas eficientes, por lo tanto
		 * ofrecen un mejor rendimiento. Las consultas estáticas se anotan en la entidad
		 */
		System.out.println("*5 Consulta estática que devuelva todos los empleados");
		Query query = ef.getEm().createNamedQuery(Empleado.BUSCAR_TODOS_EMPLEADOS);
		System.out.println(query.getResultList());
		
		
		//ejer 6
		//En una entidad se puede hacer varias csonultas
		System.out.println("*6 varias consultas estaticas");
		
		//muy rara
		TypedQuery<Departamento> query2 = ef.getEm().createNamedQuery(Departamento.ORDENAR_DESC_NOMBRE, Departamento.class);
		System.out.println(query2.getFirstResult());
		
		Query query3= ef.getEm().createNamedQuery(Departamento.BUSCAR_CODEPT);
		Query query41= ef.getEm().createNamedQuery("Departamento.buscar");
		query3.setParameter("cod", "depa1");
		
		System.out.println(query3.getResultList());
		
		query41.setParameter("cod", "depa1");
		System.out.println(query41.getResultList());


	}

}
