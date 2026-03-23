package gestionEmpleados;

/**
 * Empleados participantes en la gestion de empleados
 */
public class Empleado {

	private String dni;
	private String nombre;
	private double salarioBase;
	private double porcBonificacion;
	private static double precioHoraExt;
	private double horaExtraRealizada;
	
	/**
	 * Constructor inicial
	 * @param dni
	 * @param nombre
	 * @param salarioBase
	 * @param porcBonificacion
	 * @param precioHoraExt
	 * @param horaExtraRealizada
	 */
	public Empleado(String dni, String nombre, double salarioBase, double porcBonificacion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.salarioBase = salarioBase;
		this.porcBonificacion = porcBonificacion;
	}
	
	//Getters y setters necesarios
	public String getDni() {
		return dni;
	}
	
	public void setPorcBonificacion(double porcBonificacion) {
		if(porcBonificacion >= 0 || porcBonificacion <= 30) {
			this.porcBonificacion = porcBonificacion;
		}
	}

	public static void setPrecioHoraExt(double precioHorasExt) {
		precioHoraExt = precioHorasExt;
	}
	
	public void setHoraExtraRealizada(double horaExtraRealizada) {
		this.horaExtraRealizada = horaExtraRealizada;
	}
	
	/**
	 * Funcion para calcular el importe de la bonificación
	 * @return cantidad de importe de bonificacion
	 */
	public double importeBonificacion() {
		
		return salarioBase * porcBonificacion / 100;
	}
	
	/**
	 * Funcion para calcular cuanto hay que pagar por las horas extras
	 * @return cantidad de dinero a pagar por horas extras 
	 */
	public double horasAPagar() {
		
		return horaExtraRealizada * precioHoraExt;
	}
	
	/**
	 * Funcion que permite calcular el importe total
	 * @return importe total
	 */
	public double importeTotal() {
		
		return salarioBase + importeBonificacion() + horasAPagar();
	}


	@Override
	public String toString() {
		return dni + " - " + nombre + " | Salario Base: " + salarioBase +
				" | Bonificación: " + importeBonificacion() + " (" + porcBonificacion + "%) || Horas Extra: " +
				horaExtraRealizada + " | Total Bruto: " + importeTotal();
	}
	
	/**
	 * Funcion para comprobar si la bonificacion es mayor del 15%
	 * @return true si es mayor al 15% y false si es menor al 15%
	 */
	public boolean bonificacionMayor() {
		
		boolean esMayor = false;
		
		if (porcBonificacion > 15) {
			
			esMayor = true;
		}
		
		return esMayor;
	}
	
	
}
