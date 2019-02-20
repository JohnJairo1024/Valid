package com.valid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.valid.model.audit.DateAudit;

@Entity
@Table(name="file_model")
public class Documento extends DateAudit {
	@Id
	@GeneratedValue
    @Column(name = "id")
    private Long id;
	
    @Column(name = "nombre")
	private String nombre;
    
    @Column(name = "mimetype")
	private String mimetype;
	
	@Lob
    @Column(name="pic")
    private byte[] pic;
	
	public Documento(){}
	
	public Documento(String nombre, String mimetype, byte[] pic){
		this.nombre = nombre;
		this.mimetype = mimetype;
		this.pic = pic;
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
	
	public byte[] getPic(){
		return this.pic;
	}
	
	public void setPic(byte[] pic){
		this.pic = pic;
	}
}