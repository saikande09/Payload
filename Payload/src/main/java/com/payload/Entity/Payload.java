package com.payload.Entity;




import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "payload")
public class Payload {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loadId;
	
	@Column(name="loadingPoint")
	private String loadingPoint;
	
	@Column(name="unloadingPoint")
	private String unloadingPoint;
	
	@Column(name="productType")
	private String productType;
	
	@Column(name="truckType")
	private String truckType;
	
	@Column(name="noOfTrucks")
	private Long noOfTrucks;
	
	@Column(name="weight")
	private Long weight;
	
	@Column(name="optional")
	private String optional;
	
	@Column(name="shipperId")
	private Long shipperId;
	
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	    @Column(name="Date")
	    private LocalDate date; // Adjusted to LocalDate

	    
	    public LocalDate getDate() {
	        return date;
	    }

	    public void setDate(LocalDate date) {
	        this.date = date;
	    }

}

	
	

