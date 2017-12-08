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
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;
/**
 * Servlet implementation class Auth
 */
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAutenticacao auth;
	private Usuario user;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Auth() {
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
				this.user=this.auth.autenticarFacebook(result.getString("email"),result.getString("id"));
			}catch (Exception e){
				this.user=null;
			}
			if(this.user!=null){
	        	request.getSession().setAttribute("user", this.user);
	        	response.sendRedirect("/home.jsp");
        	}else{
        		request.getSession().invalidate();    
		        request.setAttribute("erro","Usuario não Registrado!");  
		        request.getRequestDispatcher("/index.jsp").forward(request, response);    
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
        		this.user = this.auth.autenticarEmail(email,senha);
        	}catch (Exception e) {
				this.user=null;
			}
        	if(this.user!=null){
	        	request.getSession().setAttribute("user", this.user);
	        	response.sendRedirect("/home.jsp");
        	}else{
        		request.getSession().invalidate();    
		        request.setAttribute("erro","Email e/ou Senha Inválido!");  
		        request.getRequestDispatcher("/index.jsp").forward(request, response);    
        	}
        }	
	}
}