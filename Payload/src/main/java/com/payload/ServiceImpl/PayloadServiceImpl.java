package com.payload.ServiceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.payload.Dto.PayloadDto;
import com.payload.Entity.Payload;
import com.payload.Repository.PayloadRepository;
import com.payload.Service.PayloadService;
import com.payload.mapper.PayloadMapper;
import com.payload.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PayloadServiceImpl implements PayloadService {
	
	private PayloadRepository payloadRepository;
	
	
	@Override
	public PayloadDto createPayload(PayloadDto payloadDto) {
		// TODO Auto-generated method stub
		Payload payload = PayloadMapper.mapToPayload(payloadDto);
		Payload savedPayload = payloadRepository.save(payload);
		
		
		return PayloadMapper.mapToPayloadDto(savedPayload);
	}


	@Override
	public PayloadDto getPayloadById(Long payloadId) {
		
		Payload payload =	payloadRepository.findById(payloadId)
			       .orElseThrow(()-> 
			       new ResourceNotFoundException("Payload is not exist with given id :"+ payloadId)
			       );
			
			return PayloadMapper.mapToPayloadDto(payload);
		
	}


	@Override
	public List<PayloadDto> getAllPayloads() {
		
		List<Payload> payloads =payloadRepository.findAll();
		return payloads.stream().map((payload)->PayloadMapper.mapToPayloadDto(payload))
				.collect(Collectors.toList());
	}


	@Override
	public PayloadDto updatePayload(Long payloadId, PayloadDto updatedPayload) {
		Payload payload = payloadRepository.findById(payloadId).orElseThrow(
				
				() -> new ResourceNotFoundException("payload is not exist with given id:" +payloadId)
				
				);
		payload.setLoadingPoint(updatedPayload.getLoadingPoint());
		payload.setUnloadingPoint(updatedPayload.getUnloadingPoint());
		payload.setProductType(updatedPayload.getProductType());
		payload.setTruckType(updatedPayload.getTruckType());
		payload.setNoOfTrucks(updatedPayload.getNoOfTrucks());
		payload.setWeight(updatedPayload.getWeight());
		payload.setOptional(updatedPayload.getOptional());
		payload.setShipperId(updatedPayload.getShipperId());
		payload.setDate(updatedPayload.getDate());
		
		
		
		Payload updatedPayloadObj = payloadRepository.save(payload);
		return PayloadMapper.mapToPayloadDto(updatedPayloadObj);
	}


	@Override
	public void deletePayload(Long payloadId) {
		Payload payload = payloadRepository.findById(payloadId).orElseThrow(
				
				()-> new ResourceNotFoundException("Payload is not exist with given id: " + payloadId)
				
				);
			payloadRepository.deleteById(payloadId);
		
		
	}


	@Override
	public List<PayloadDto> getLoadsByShipperId(Long shipperId) {
        Payload payload = payloadRepository.findById(shipperId)
                           .orElseThrow(() -> new ResourceNotFoundException("Shipper not found with id: " + shipperId));

        return (List<PayloadDto>) PayloadMapper.mapToPayloadDto(payload);
		
	}


	
	


	

}
