package br.ufal.aracomp.ufalagenda.controladorDeDialogo;

import java.util.List;

import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Usuario;

public interface IDialogo {

	public List <Definido> listaEventos();
	public Definido criarEvento(Compromisso c);
}
