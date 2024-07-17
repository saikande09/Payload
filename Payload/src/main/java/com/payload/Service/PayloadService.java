package com.payload.Service;

import java.util.List;


import com.payload.Dto.PayloadDto;


public interface PayloadService {
	
	PayloadDto createPayload(PayloadDto payloadDto);
	
	PayloadDto getPayloadById(Long payloadId);
	
	List<PayloadDto> getAllPayloads();

	PayloadDto updatePayload(Long payloadId , PayloadDto updatedPayload);
	
	void deletePayload(Long payloadId);
	
	List<PayloadDto> getLoadsByShipperId(Long shipperId);
	
	

}
