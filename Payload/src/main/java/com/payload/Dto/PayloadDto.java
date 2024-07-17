package com.payload.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PayloadDto {
	
		
		private Long loadId;
		
		
		private String loadingPoint;
		
		
		private String unloadingPoint;
		
		
		private String productType;
		
		
		private String truckType;
		
		
		private Long noOfTrucks;
		
	
		private Long weight;
		
		
		private String optional;
		
		
		private Long shipperId;
		
		private LocalDate date;

	

}
