package com.docconverter.controller;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.docconverter.model.FileDetails;
import com.docconverter.model.FileDetailsResponse;
import com.docconverter.service.FileConversionService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FileConversionController {
	
	@Autowired
	private FileConversionService conversionService;
	
	@PostMapping(path = "/attachment" , produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	//@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public void  fileConvversion(HttpServletResponse response,@RequestBody FileDetails details) throws Exception{
		
		byte[] fileBody = conversionService.fileConversion(details.getFileName());
		
		response.getOutputStream().write(fileBody);		 
	}
	
	@GetMapping("/test")
	public String  helloWorld() throws Exception{
		
		//byte[] fileBody = conversionService.fileConversion(details.getFileName());
		
		return "Hello World"; 
	}

}
