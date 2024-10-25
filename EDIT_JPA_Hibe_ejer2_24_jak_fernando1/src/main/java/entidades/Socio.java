package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SOCIOS", catalog ="ejercicio2")
public class Socio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_SOCIO", unique= true, nullable=false)
	private String idSocio;
	
	@Column(name="APELLIDOS")
	private String apellidos;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	public Socio() {
		
	}
	
	public Socio(String idSocio, String nombre, String apellidos) {
		super();
		this.idSocio = idSocio;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}



	public String getId_socio() {
		return idSocio;
	}


	public void setId_socio(String idSocio) {
		this.idSocio = idSocio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	@Override
	public String toString() {
		return "Socio [id_socio=" + idSocio + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
	
	
	

}
