package br.com.startup.fucapi.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarEmail {

	final static String empresaEmail = "eventos.gerenciar@gmail.com";
	final static String senhaEmail   = "evento123";

	public static  void enviarEmail (String destinatario, String codigo) {

		/**
		 * Propriedade de conexão via Gmail SMTP server usando SSL connection.
		 * Caso não funcione altere a porta para 587
		 * Configure a sua conta de envio de Gmail: Verificação em duas etapas
		 * desmarque esta opção na configuração de seguranã 
		 * E por fim tente mudar o as regras do Firewall caso esteja em ambiente
		 * corporativo. 
		 * **/

		Properties propiedade = new Properties();
		propiedade.put("mail.smtp.host", "smtp.gmail.com");
		propiedade.put("mail.smtp.socketFactory.port", "465");
		propiedade.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		propiedade.put("mail.smtp.auth", "true");
		propiedade.put("mail.smtp.port", "465");

		// CRIA A SESSÃO
		Session session = Session.getDefaultInstance(propiedade,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(empresaEmail,
								senhaEmail);
					}
				});

		session.setDebug(true);

		try {

			// MENSAGEM CRIADA
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(empresaEmail));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario));

			

			message.setSubject("Alguém solicitou uma nova senha para sua conta do ManagerEvents");
			message.setText("Olá, "
					+ destinatario+" Alguém solicitou recentemente a redefinicao de sua senha do Gerenciador de Eventos."
					+"\n"+"Você pode inserir o código de redefinição a seguir: "
					+"\n"+"|-----------|"
					+"\n|"+codigo+"|"
					+"\n"+"|-----------|" 
					+"\n\n"+ "Não solicitou esta alteração?"
					+ "\n\n"+"Se você não solicitou uma nova senha, avise-nos imediatamente.  eventos.gerenciar@gmail.com"
					+"\n\n"+ "Atenciosamente, "
					+"\n"+ "Startup Fucapi"
					+"\n"+ "");

			//ENVIA A MENSAGEM
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
