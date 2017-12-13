package br.ufal.aracomp.ufalagenda.controladorDeDialogo;

import java.util.List;

import br.ufal.aracomp.ufalagenda.operacoesCalendario.ICalendario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public class Dialogo implements IDialogo{
	private ICalendario calendario;

	private Usuario user;
	
	public Dialogo(Usuario user){
		this.user=user;
	}
	
	@Override
	public List<Definido> listaEventos() {
		return calendario.acessarEventosAgenda(null,null,null);
	}
	
	@Override
	public Definido criarEvento(Compromisso c){
		return calendario.criarEvento(c, null);
	}
	
}