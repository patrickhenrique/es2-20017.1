package br.ufal.aracomp.ufalagenda.controladorDeDialogo;
import java.util.List;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;

public interface IDialogo {
	public List <Definido> listaEventos();
	public Definido criarEvento(Compromisso c);
	public EmAberto criarEventoEmAberto(Compromisso c);	
	public boolean EditarEventoEmAberto(EmAberto evento);
	public boolean EditarEvento(Definido evento);
	public boolean excluirEventoEmAberto(int id);
	public boolean excluirEvento(int id);
	
}