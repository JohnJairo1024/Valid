package com.valid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.valid.model.fecha.Fecha;

@Entity
@Table(name="documento")
public class Documento extends Fecha {
	@Id
	@GeneratedValue
    @Column(name = "id")
    private Long id;
	
    @Column(name = "nombre")
	private String nombre;
    
    @Column(name = "mimetype")
	private String mimetype;
	
	@Lob
    @Column(name="data")
    private byte[] data;
	
	public Documento(){}
	
	public Documento(String nombre, String mimetype, byte[] data){
		this.nombre = nombre;
		this.mimetype = mimetype;
		this.data = data;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getMimetype(){
		return this.mimetype;
	}
	
	public void setMimetype(String mimetype){
		this.mimetype = mimetype;
	}
	
	public byte[] getData(){
		return this.data;
	}
	
	public void setData(byte[] data){
		this.data = data;
	}
}