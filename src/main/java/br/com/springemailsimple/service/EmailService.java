package br.com.springemailsimple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.springemailsimple.model.EmailSimpleModel;
import br.com.springemailsimple.model.enums.StatusEmail;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	private SimpleMailMessage message = new SimpleMailMessage();

	public EmailSimpleModel sendSimpleEmail(EmailSimpleModel emailSimple) {
		try {
		message.setSubject(emailSimple.getSubject());
		message.setFrom(emailSimple.getEmailFrom());
		message.setTo(emailSimple.getEmailTo());
		message.setText(emailSimple.getText());
		emailSimple.setStatus(StatusEmail.SENT);
		mailSender.send(message);
		}
		catch (MailException e) {
			emailSimple.setStatus(StatusEmail.ERROR);
		}
		return emailSimple;
	}
	
	
}
