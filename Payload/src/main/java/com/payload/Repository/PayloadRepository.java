package com.payload.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payload.Entity.Payload;

public interface PayloadRepository extends JpaRepository<Payload, Long> {
	
	

}
