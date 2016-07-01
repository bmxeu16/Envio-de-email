package email;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Envio conc = new Envio();
		
		//host, porta, remetente, destinatario, assunto, conteudo, usuario, senha
		conc.conecta("hostSMTP", "porta","Remetente","Destinarario",
				"Assunto","Enviado pela aplicação Java", "usuario", "senha");
	}
}