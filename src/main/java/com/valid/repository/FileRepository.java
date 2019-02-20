package com.valid.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.valid.model.Documento;

@Transactional
public interface FileRepository extends JpaRepository<Documento, Long>{
	public Documento findByNombre(String nombre);
}