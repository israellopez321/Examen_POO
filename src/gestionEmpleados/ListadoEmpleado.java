package gestionEmpleados;

import java.util.ArrayList;

/**
 * Lista de la clase Empleados
 */
public class ListadoEmpleado {

	private ArrayList<Empleado> listado = new ArrayList<>();
	
	/**
	 * Funcion para verificar si la persona a buscar por el dni ya forma parte de la lista
	 * @param dni de la persona
	 * @return devuelve el dni de la persona a buscar si no pertenece a la lista
	 */
	public Empleado buscarPorDni(String dni) {
		Empleado encontrar = null;
		
		for(Empleado persona : listado) {
			
			if (persona.getDni().equalsIgnoreCase(dni)) {
				
				encontrar = persona;
			}
		}
		
		return encontrar;
	}
	
	/**
	 * Funcion para ver si es posible añadir un empleado a la lista 
	 * @param empleado a añadir a la lista
	 * @return devuelve true si es posible añadir al empleado a la lista
	 */
	public boolean añadirEmpleado(Empleado empleado) {
		
		boolean esPosible = false;
		
		if(buscarPorDni(empleado.getDni()) == null) {
			
		listado.add(empleado);	
		
		esPosible = true;
		
		}
		
		return esPosible;
	}
	
	/**
	 * Funcion para mostrar todos los empleados en la lista
	 */
	public void listarTodos() {
		
		for(Empleado empleado: listado ) {
			System.out.println(empleado);
			System.out.println("-----------------------------------------------------");	
		}
	}
	
	/**
	 * Funcion para modificar las horas extras realizadas
	 * @param dni del empleado
	 * @param horas extras realizadas
	 * @return devuelve true si es posible modificar las horas extras y false si no es posible
	 */
	public boolean modificarHorasExtra(String dni, double horas) {
		
		boolean esPosible = false;
		
		Empleado persona = buscarPorDni(dni);
		
		if(persona != null) {
			
			persona.setHoraExtraRealizada(horas);
			esPosible = true;
		}
		
		return esPosible;	
	}
	
	/**
	 * Funcion para modificar la bonificacion de un empleado
	 * @param dni del empleado
	 * @param porcentaje de bonificacion a cambiar
	 * @return devuelve true si es posible modificar la bonificacion y false si no es posible
	 */
	public boolean modificarBonificacion(String dni, double porcentaje) {
		
		boolean esPosible = false;
		
		Empleado persona = buscarPorDni(dni);
		
		if(persona != null && porcentaje >= 0 || porcentaje <= 15) {
			
			persona.setPorcBonificacion(porcentaje);
			esPosible = true;
		}
		
		return esPosible;	
	}
	
	/**
	 * Funcion que permite eliminar a un empleado de la lista
	 * @param dni del empleado
	 * @return devuelve true si es posible eliminar al empleado de la lista y false si no es posible
	 */
	public boolean eliminarPorDni(String dni) {
		
		boolean esPosible = false;
		
		Empleado persona = buscarPorDni(dni);
		
		if(persona != null) {
			
			listado.remove(persona);
			esPosible = true;
		}
		
		return esPosible;
	}
	
	/**
	 * Funcion que calcula los gastos de bonificaciones totales de todos los empleados
	 * @return devuelve el total de bonificaciones de todos los empleados
	 */
	public double calcularGastoBonificaciones() {
		
		double total = 0;
		
		for (Empleado persona: listado) {
			
			total += persona.importeBonificacion();
		}
		
		return total;
	}
	
	/**
	 * Funcion que muestra a los empleados con un mayor porcentaje de bonificacion del 15%
	 */
	public void listarEmpleadosAltoDesempenio() {
		
		for(Empleado persona : listado) {
			
			if (persona.bonificacionMayor()) {
				
				System.out.println(persona);
				System.out.println("-------------------");
			}	
		}
	}
	
	
}
