package com.payload.mapper;

import com.payload.Dto.PayloadDto;

import com.payload.Entity.Payload;

public class PayloadMapper {
	
	public static PayloadDto mapToPayloadDto(Payload payload) {
		return new PayloadDto(
				    payload.getLoadId(),
	                payload.getLoadingPoint(),
	                payload.getUnloadingPoint(),
	                payload.getProductType(),
	                payload.getTruckType(),
	                payload.getNoOfTrucks(),
	                payload.getWeight(),
	                payload.getOptional(),
	                payload.getShipperId(),
	                payload.getDate()
				
				);
	}  
	
	public static Payload mapToPayload(PayloadDto payloadDto) {
		return new Payload(
				 	payloadDto.getLoadId(),
	                payloadDto.getLoadingPoint(),
	                payloadDto.getUnloadingPoint(),
	                payloadDto.getProductType(),
	                payloadDto.getTruckType(),
	                payloadDto.getNoOfTrucks(),
	                payloadDto.getWeight(),
	                payloadDto.getOptional(),
	                payloadDto.getShipperId(),
	                payloadDto.getDate()
				
				
				);
	}
	

}
