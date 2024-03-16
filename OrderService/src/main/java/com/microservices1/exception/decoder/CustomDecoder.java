package com.microservices1.exception.decoder;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices1.exception.ErrorResponse;
import com.microservices1.exception.OrderServiceCustomException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomDecoder implements ErrorDecoder{

	@Override
	public Exception decode(String methodKey, Response response) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			ErrorResponse errorResponse=mapper.readValue(response.body().asInputStream(), ErrorResponse.class);
			return new OrderServiceCustomException(errorResponse.getMessage(),errorResponse.getErrorCode());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OrderServiceCustomException("ServiceInternalException","Service Exception");
	}

}
