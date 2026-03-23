package gestionEmpleados;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ListadoEmpleado lista = new ListadoEmpleado();
		
		int opcion = 0;
		
		do {
			
			//Mostrar menu de opciones
			System.out.println("--Menu Gestion Empleados--");
			System.out.println("1. Añadir empleados");
			System.out.println("2. Listar empleados");
			System.out.println("3. Buscar empleados por DNI");
			System.out.println("4. Modificar horas extras");
			System.out.println("5. Modificar bonificaciones");
			System.out.println("6. Modificar precio hora extra");
			System.out.println("7. Eliminar empleado");
			System.out.println("8. Ver estadísticas");
			System.out.println("9. Salir del programa");
			System.out.println("Elige una de las opciones: ");
			
			try {
				opcion = sc.nextInt();
			}catch (Exception e) {
				System.out.println("ERROR: Introduzca un numero entero");
				sc.next();
				opcion = 0;
			}
			
			//Switch para recoger y ejecutar la opcion escrita por escaner
			switch(opcion) {
			
			/**
			 * Case que pide el dni del empleado y si no esta en la lista el empleado lo añade
			 */
			case 1:
				
				System.out.println("Introduzca el dni del empleado:");
				String dni = sc.next();
				
				if(lista.buscarPorDni(dni) != null ) {
					System.out.println("ERROR: Ese Empleado ya esta introducido por ese Dni.");
					break;
				}
				
				System.out.println("Introduzca el nombre del empleado:");
				String nombre = sc.next();
				
				System.out.println("Introduzca el salario base del empleado:");
				double salarioBase = sc.nextDouble();
				
				System.out.println("Introduzca el porcentaje de bonificación del empleado:");
				double porcBonificacion = sc.nextDouble();
				
				Empleado empleado = new Empleado(dni, nombre, salarioBase, porcBonificacion);
				lista.añadirEmpleado(empleado);
				
				System.out.println("Empleado registrado correctamente.");
				
				break;
			/**
			 * Case que llama a la funcion listarTodos() para mostrar a los empleados añadido a la lista	
			 */
			case 2:
				
				lista.listarTodos();
				break;
			/**	
			 * Case que pide el dni del empleado para buscar si pertenece a la lista
			 */
			case 3:
				
				System.out.println("Introduzca el dni del empleado a buscar:");
				dni = sc.next();
				
				Empleado empleadoABuscar = lista.buscarPorDni(dni);
				
				if(empleadoABuscar == null) {
					
					System.out.println("Ese empleado no existe");
				} else {
					System.out.println(empleadoABuscar);
				}
				
				break;
			/**	
			 * Case que pide el dni del empleado para modificar el numero de horas extras del empleado en cuestion
			 */
			case 4:
				
				System.out.println("Introduzca el dni del empleado:");
				dni = sc.next();
				
				System.out.println("Introduzca el nuevo numero de horas extras:");
				double horasExtras = sc.nextDouble();
				
				if(lista.modificarHorasExtra(dni, horasExtras)) {
					
					System.out.println("Se ha modificado correctamente.");
				} else {
					
					System.out.println("No se ha podido modificar.");
				}
	
				break;
			/**	
			 * Case que pide el dni del empleado para modificar la bonificacion del empleado en cuestion
			 */
			case 5:
				
				System.out.println("Introduzca el dni del empleado:");
				dni = sc.next();
				
				System.out.println("Introduzca el nuevo porcentaje de bonificaciones(0%-30%):");
				porcBonificacion = sc.nextDouble();
				
				if(lista.modificarBonificacion(dni, porcBonificacion)) {
					System.out.println("Se ha podido modificar las bonificaciones.");
				} else {
					System.out.println("No se ha podido modificar las bonificaciones");
				}
				
	
				break;
			/**	
			 * Case que pide el nuevo precio de las horas extras para modificarlo
			 */
			case 6:
				
				System.out.println("Nuevo precio horas extras:");
				double nuevoPrecioHoras = sc.nextDouble();
				
				Empleado.setPrecioHoraExt(nuevoPrecioHoras);
				System.out.println("Precio de las horas extras actualizado.");
				
				break;
			/**	
			 * Case que pide el dni del empleado para verificar si esta en la lista y si esta eliminarlo
			 */
			case 7:
				
				System.out.println("Introduzca el dni del empleado a eliminar: ");
				dni = sc.next();
	
				Empleado empleadoAEliminar = lista.buscarPorDni(dni);
				
				if (empleadoAEliminar == null) {
					System.out.println("Ese empleado no existe.");
				} else {
					lista.eliminarPorDni(dni);
					System.out.println("Empleado eliminado.");
				}
				
				break;
			/**	
			 * Case que muestra las estadisticas de los empleados(Total de gastos de bonificacion y empleados Premium(<15%))
			 */
			case 8:
				
				System.out.println("Total gastos bonificaciones: " + lista.calcularGastoBonificaciones());
				System.out.println("Empleados Premium: ");
				lista.listarEmpleadosAltoDesempenio();
				
				break;
			/**	
			 * Case que muestra por pantalla la finalización del programa
			 */
			case 9:
			
				System.out.println("Saliendo del programa...");
				break;
			/**	
			 * Default en el caso de que no seelija una de las opciones dadas mandar un mensaje
			 */
			default:
				
				System.out.println("Esa opción no es valida.");
			
			}
			
			
		}while(opcion != 9);
		
		sc.close();
		
	}
	
	
}
