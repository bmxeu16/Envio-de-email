package email;

/*
 * Executar por linha de comando em Linux
  
   java -jar envia_email.jar "hsot" "porta" "remetente" "destinatario" "assunto" "conteudo" "usuario" "senha" "true ou false para autenticação"
 */

public class Principal {

	public static void main(String[] args) {

		Envio conc = new Envio();

		String host = args[0];
		String porta = args[1];
		String remetente = args[2];
		String destinatario = args[3];
		String assunto = args[4];
		String conteudo = args[5];
		String user = args[6];
		String senha = args[7];
		String autenticacao = args[8];

		boolean retorno_autenticacao = Boolean.getBoolean(autenticacao); // converte String para Boolean

		conc.conecta(host, porta, remetente, destinatario, assunto, conteudo, user, senha, retorno_autenticacao);
	}
}