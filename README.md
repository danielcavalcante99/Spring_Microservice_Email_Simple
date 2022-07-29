# Spring email simples |SMTP GMAIL
![image](https://user-images.githubusercontent.com/74054701/147880935-fae18e2e-4ab7-4cef-9a98-94fecb05b366.png)


## 1 - Definindo a Estrutura do Projeto

**Projeto:** Maven

**Depedências:**
- Spring Web;
- Java Mail Sender;
- Validation;
- Lombok.

**Copie e cole no arquivo pow.xml**
~~~ 
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
~~~
#
#

## 2 - Definindo Properties

- **O servidor SMTP ao qual se conectar:**
~~~
spring.mail.host=smtp.gmail.com
~~~
- **A porta do servidor SMTP para conexão:**
~~~ 
spring.mail.port=587  
~~~
- **Nome de usuário padrão para SMTP:**
~~~ 
spring.mail.username=******@gmail.com  
~~~
- **Insira a senha(não é a senha tradicional)** </br>
Segue o passo a passo nesse link para gerar essa senha de 16 dígitos: https://support.google.com/accounts/a...
~~~ 
spring.mail.password=****************
~~~ 
- **Se verdadeiro, tente autenticar o usuário usando o comando AUTH. O padrão é falso:**
~~~ 
spring.mail.properties.mail.smtp.auth=true 
~~~ 
- **Se verdadeiro, habilita o uso do STARTTLS comando (se compatível com o servidor) para alternar a conexão para uma conexão protegida por TLS antes de emitir qualquer comando de login. Se o servidor não suportar STARTTLS, a conexão continuará sem o uso de TLS.**

O **Transport Layer Security (TLS)** é um protocolo de **segurança** que **criptografa e-mails** para garantir a segurança. O **TLS** impede o acesso não autorizado ao e-mail quando ele está em trânsito por conexões de Internet.

Por padrão, o **Gmail** sempre tenta usar o **TLS ao enviar e-mails**. No entanto, uma conexão segura TLS exige que o remetente e o destinatário **usem esse protocolo**. Se o servidor de recebimento **não usar o TLS**, o **Gmail ainda entregará a mensagem, mas a conexão não será segura**. 
~~~ 
spring.mail.properties.mail.smtp.starttls.enable=true 
~~~

fonte: https://javaee.github.io/javamail/docs/api/com/sun/mail/smtp/package-summary.html


**Copie e Cole no arquivo application.properties:**
~~~
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=***********@gmail.com
spring.mail.password=****************
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
~~~

#
#
## 3 - implementando a camada model

**Package:** model.enums;

**Enum:** StatusEmail

![image](https://user-images.githubusercontent.com/74054701/147883934-2687b83a-f55c-472d-831b-1bb0cccd5707.png)

**Package:** model;

**Class:** EmailSimpleModel

![image](https://user-images.githubusercontent.com/74054701/147882749-65b02f9a-0e0e-42dd-9401-e657c37c15bb.png)

**@Data:** é como ter implícitos **@Getter**, **@Setter**, **@ToString**, **@EqualsAndHashCodee** e **@RequiredArgsConstructor**.

**@NotBlank:** para **não permitir** valores **nulos** ou **vazios**.

**@Email:** verifica se o que foi digitado no campo contém **características de email**.

#
#
## 4 - Implementando a camada de serviço

**Package:** services;

**Class:** EmailService

![image](https://user-images.githubusercontent.com/74054701/147884037-f3311904-7a3e-43b5-bbd4-d75a7407e738.png)

**@Service:** anotação para classe da camada de serviço, onde estão a regra de negócio. Essa anotação serve como uma especialização de **@Component**.

**@Autowired:** usado para injeção de depedência.

**Classe SimpleMailMessage:** usada para criar uma mensagem de correio simples.

**Classe JavaMailSender:** irá nos fornecer um método chamado send que aceita o **tipo SimpleMailMessage** para o envio de email.

#
#
## 5 - Implementando a camada de controler

**Package:** controllers;

**Class:** EmailController

![image](https://user-images.githubusercontent.com/74054701/147886115-9144a59c-75d0-4f26-aadc-1e03cd87adc0.png)

**@RestController:** é para marcar que o controlador está fornecendo serviços REST com o tipo de resposta JSON,  é composição das
anotações **@Controller** e **@ResponseBody**.

**@RequestMapping:** usamos aqui para definir uma **rota inicial** para realizar as **requisições**.

**@PostMapping:** usamos para definir uma **rota** para a **requisição** do **tipo POST**.

**@RequestBody:** uma anotação indicando que **um parâmetro** de método deve ser **associado** ao **corpo da solicitação HTTP**.

**@Valid:** irá verificar se todos os campos foram **preenchidos corretamente**, respeitando as **regras** das anotações **@NotBlank**, **@Email**, **@NotEmpty** e etc... 

**Classe ResponseEntity:** representa toda a **resposta HTTP:** **código de status**, **cabeçalhos** e **corpo**. Podemos usa-la para **configurar** totalmente a **resposta HTTP**.

#
#
## 6 - Enviar o email

- **Requisição:** Post
- **URL da requisição:** http://localhost:8080/email/sendSimpleEmail

![image](https://user-images.githubusercontent.com/74054701/147888101-23de2872-7c5c-4b63-9d0e-57e34d2ceb25.png)

