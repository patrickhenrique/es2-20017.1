package br.ufal.aracomp.ufalagenda.httpservlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao.IAutenticacao;
import br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao.LoginFacebook;
import br.ufal.aracomp.ufalagenda.persistencia.UsuarioDAO;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAutenticacao auth;
	private Usuario user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        this.auth 	= null;
    	this.user   = new Usuario();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		String token = request.getParameter("token");
		LoginFacebook fb = new LoginFacebook();
		JSONObject result = fb.obterUsuarioFacebook(token);
		if(result==null){
			request.getSession().invalidate();  
			request.setAttribute("erro","Usuario não Registrado!");  
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{			
			try{
				UsuarioDAO daoUser = new UsuarioDAO();
				daoUser.insert(new Usuario(null, result.getString("id"), result.getString("email"), null));
				request.getSession().invalidate();    
		        request.setAttribute("success","Usuario Cadastrado com Sucesso!");  
		        request.getRequestDispatcher("/index.jsp").forward(request, response);
			}catch (Exception e){
				
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("password");
		
		if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
			request.getSession().invalidate();    
	        request.setAttribute("erro","Email e/ou Senha Inválido!");  
	        request.getRequestDispatcher("/index.jsp").forward(request, response);
        }else{
        	try{
        		UsuarioDAO daoUser = new UsuarioDAO();
				daoUser.insert(new Usuario(null, senha, email, null));
				request.getSession().invalidate();    
		        request.setAttribute("success","Usuario Cadastrado com Sucesso!");  
		        request.getRequestDispatcher("/index.jsp").forward(request, response);
        	}catch (Exception e) {
				
			}
        }	
	}
}