package com.payload.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.payload.Dto.PayloadDto;
import com.payload.Service.PayloadService;

@RestController
@RequestMapping("/load")
public class PayloadController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(PayloadController.class);
//	@Autowired
	private PayloadService payloadService;
	 	@Autowired
	    public PayloadController(PayloadService payloadService) {
	        this.payloadService = payloadService;
	    }
	 	
	 	
	
	@PostMapping("/load")
	public ResponseEntity<PayloadDto> createPayload(@RequestBody PayloadDto payloadDto){
	PayloadDto savedPayload =payloadService.createPayload(payloadDto);
	return new ResponseEntity<>(savedPayload, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("{loadId}")
	public ResponseEntity<PayloadDto> getEmployeeById(@PathVariable("loadId") Long payloadId){
		PayloadDto payloadDto =payloadService.getPayloadById(payloadId);
		return ResponseEntity.ok(payloadDto);
	}
	
	
	@GetMapping
	public ResponseEntity<List<PayloadDto>> getAllPayloads(){
	List<PayloadDto>payloads =	payloadService.getAllPayloads();
	return ResponseEntity.ok(payloads);
		
	}
	
	@PutMapping("{loadId}")
	public ResponseEntity<PayloadDto> updatedPayload(@PathVariable("loadId") Long payloadId, 
			@RequestBody PayloadDto updatedPayload){
		PayloadDto payloadDto = payloadService.updatePayload(payloadId, updatedPayload);
		return ResponseEntity.ok(payloadDto);
	}
	
	
	@DeleteMapping("{loadId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("loadId") Long payloadId){
		payloadService.deletePayload(payloadId);
		return ResponseEntity.ok("Payload Deleted Successfully!");
	}
	
	
	@GetMapping("/loads")
    public ResponseEntity<List<PayloadDto>> getLoadsByShipperId(@RequestParam("shipperId") Long shipperId) {
        logger.info("Received request to get loads by shipperId: {}", shipperId);
        try {
            List<PayloadDto> loads = payloadService.getLoadsByShipperId(shipperId);
            return ResponseEntity.ok(loads);
        } catch (Exception e) {
            logger.error("Error fetching loads by shipperId", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
