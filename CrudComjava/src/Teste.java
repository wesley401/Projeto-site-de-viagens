
import br.com.crud.DAO.PassageiroDAO;
import br.com.crud.DAO.UsuarioDAO;
import br.com.crud.model.Passageiro;
import br.com.crud.model.Usuario;

public class Teste {

	public static void main(String[] args) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PassageiroDAO passageiroDAO = new PassageiroDAO();
		Usuario usuario = new Usuario();
		Passageiro passageiro = new Passageiro();
		
		passageiro.setNome("caio");
		passageiro.setCpf(596345);
		passageiro.setTelefone(1198584442);
		
		usuario.setNome("catia");
		usuario.setLogin("catia@123.com");
		usuario.setSenha("125436");
		
		usuarioDAO.save(usuario);
		passageiroDAO.save(passageiro);
		
		Usuario usuario1 = new Usuario();
		
		usuario1.setNome("marcia");
		usuario1.setLogin("marcia@gmail.com");
		usuario1.setSenha("12345");
		
		usuarioDAO.update(usuario1);
		
		usuarioDAO.removeById(1);
		
		for(Usuario u : usuarioDAO.getUsuarios()) {
			System.out.println("nome:" + u.getNome() + " " + u.getLogin());
		}
		for(Passageiro p : passageiroDAO.getPassageiro()) {
			System.out.println("nome:" + p.getNome() + " " + p.getCpf());
		}
	}

}
