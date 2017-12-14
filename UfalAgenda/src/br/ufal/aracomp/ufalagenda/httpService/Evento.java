package br.ufal.aracomp.ufalagenda.httpService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.ufal.aracomp.ufalagenda.controladorDeDialogo.Dialogo;
import br.ufal.aracomp.ufalagenda.controladorDeDialogo.IDialogo;
import br.ufal.aracomp.ufalagenda.persistencia.UsuarioDAO;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

/**
 * Servlet implementation class Evento
 */
@WebServlet("/Evento")
public class Evento extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDialogo dialogo; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Evento() {
        super();
        // TODO Auto-generated constructor stub
        this.dialogo = new Dialogo();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(!request.getParameter("idEvento").isEmpty()){
			int id = Integer.parseInt(request.getParameter("idEvento"));
			if(request.getParameter("opcao").equals("definido")){
				this.dialogo.excluirEvento(id);
			}else{
				this.dialogo.excluirEventoEmAberto(id);
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compromisso c =new Compromisso((String)request.getParameter("descricao"), (String)request.getParameter("local") ,null,(Usuario)request.getSession().getAttribute("user"));
		String ids=request.getParameter("convidados");
		String[] lista= ids.split(",");
		UsuarioDAO u = new UsuarioDAO();
		for(String userConvidado:lista){
			c.addConvidado(u.getById(Integer.parseInt(userConvidado)));
		}
		if(request.getParameter("idEvento").isEmpty()){
			if(request.getParameter("opcao").equals("definido")){
				this.dialogo.criarEvento(c);
			}else{
				this.dialogo.criarEventoEmAberto(c);
			}
		}else{
			if(request.getParameter("opcao").equals("definido")){
				this.dialogo.EditarEvento(new Definido());
			}else{
				this.dialogo.EditarEventoEmAberto(new EmAberto());
			}
		}
	}

}
