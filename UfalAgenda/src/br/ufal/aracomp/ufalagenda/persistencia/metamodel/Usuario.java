package br.ufal.aracomp.ufalagenda.persistencia.metamodel;

import java.util.ArrayList;
import java.util.List;
import br.ufal.aracomp.ufalagenda.persistencia.util.SecurityUtil;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "usuario")
public class Usuario {
	//atributos
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String login;
	private String hashSenha;
	private String email;
	private String facebook;
	
	//associacoes
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	private List<OpcaoDeHorario> opcoesHorario;
	
	@OneToOne(mappedBy="proprietario", fetch=FetchType.LAZY)
	private Agenda agenda;
	
	@OneToMany(mappedBy="autor", fetch=FetchType.LAZY)
	private List<Compromisso> compromissosAutor;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="convidados_compromissos", joinColumns={@JoinColumn(name="id_usuario")},
	inverseJoinColumns={@JoinColumn(name="id_compromisso")})
	@Cascade(CascadeType.ALL)
	//private List<Compromisso> compromissosConvidado;
	
	private List<Convite> convidadoConvite;
	
	//construtores
	public Usuario() {
		// Gerado para o Hibernate
	}
	
	public Usuario(String login, String senha, String email, String facebook) {
		this.login = login;
		this.hashSenha = SecurityUtil.gerarHash(senha);
		this.email = email;
		this.facebook = facebook;
		this.compromissosAutor = new ArrayList<>();
		this.convidadoConvite = new ArrayList<>();
	}
	
	public Usuario(int id, String login, String senha, String email, String facebook) {
		this(login, senha, email, facebook);
		this.id = id;
	}
	
	//metodos
	public int getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public boolean validarSenha(String senha) {
		if(SecurityUtil.gerarHash(senha).equals(this.hashSenha))
			return true;
		else
			return false;
	}
	public String getEmail() {
		return email;
	}
	public String getFacebook() {
		return facebook;
	}
	public List<OpcaoDeHorario> getOpcoesHorario() {
		return opcoesHorario;
	}
	public Agenda getAgenda() {
		return agenda;
	}
	
	public List<Compromisso> getCompromissosAutor() {
		return compromissosAutor;
	}
	
	public List<Compromisso> getCompromissosConvidado() {
		return compromissosConvidado;
	}
	
	public void definirSenha(String senha) {
		this.hashSenha = SecurityUtil.gerarHash(senha);
	}
	
	public void addCompromissoAutor(Compromisso c) {
		if(!this.compromissosAutor.contains(c))
			this.compromissosAutor.add(c);
	}
	
	public void removeCompromissoAutor(Compromisso c) {
		if(this.compromissosAutor.contains(c))
			this.compromissosAutor.remove(c);
	}
	
	public void addCompromissoConvidado(Compromisso c) {
		if(!this.compromissosConvidado.contains(c))
			this.compromissosConvidado.add(c);
	}
	
	public void removeCompromissoConvidado(Compromisso c) {
		if(this.compromissosConvidado.contains(c))
			this.compromissosConvidado.remove(c);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean out = false;
	
		if(obj instanceof Usuario) {
			if(((Usuario)obj).getId()==this.id)
				obj = true;
		}
		return out;
	}
}
