package br.com.springemailsimple.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.springemailsimple.model.enums.StatusEmail;
import lombok.Data;

@Data
public class EmailSimpleModel {

	@NotBlank
	private String subject;
	@NotBlank
	@Email
	private String emailFrom;
	@NotBlank
	@Email
	private String emailTo;
	@NotBlank
	private String text;
	private StatusEmail status;
	

}

