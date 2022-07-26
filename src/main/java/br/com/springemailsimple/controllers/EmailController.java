package br.com.springemailsimple.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springemailsimple.model.EmailSimpleModel;
import br.com.springemailsimple.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService service;

	@PostMapping("/send")
	public ResponseEntity<EmailSimpleModel> sendSimpleEmail(@RequestBody @Valid EmailSimpleModel emailSimple) {
		EmailSimpleModel obj = service.sendSimpleEmail(emailSimple);
		return ResponseEntity.ok().body(obj);
	}
}
