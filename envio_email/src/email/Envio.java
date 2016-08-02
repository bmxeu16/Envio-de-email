package email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Envio {

	public void conecta(String host, String porta, String remetente, String destinatario, String assunto,
			String conteudo, String usuario, String senha, boolean autenticacao) {

		Properties props = new Properties();

		/** Parâmetros de conexão com servidor SMTP */
		props.put("mail.smtp.host", host); // aqui vai o servidor SMTP
		props.put("mail.smtp.socketFactory.port", porta);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", autenticacao);
		props.put("mail.smtp.port", porta);

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, senha);
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remetente)); // Remetente

			Address[] toUser = InternetAddress // Destinatário(s)
					.parse(destinatario);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto); // Assunto
			message.setText(conteudo);

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("====EMAIL ENVIADO====");

		} catch (MessagingException erros) {
			throw new RuntimeException(erros);
		}
	}
}