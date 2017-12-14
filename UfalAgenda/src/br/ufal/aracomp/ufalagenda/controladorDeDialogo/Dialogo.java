package br.ufal.aracomp.ufalagenda.controladorDeDialogo;
import java.util.List;
import br.ufal.aracomp.ufalagenda.operacoesAgendamento.IAgendamento;
import br.ufal.aracomp.ufalagenda.operacoesCalendario.ICalendario;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Compromisso;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.Definido;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.EmAberto;

public class Dialogo implements IDialogo{
	private ICalendario calendario;
	private IAgendamento emAberto;
	
	@Override
	public List<Definido> listaEventos() {
		return calendario.acessarEventosAgenda(null,null,null);
	}
	
	@Override
	public Definido criarEvento(Compromisso c){
		return calendario.criarEvento(c, null);
	}

	@Override
	public EmAberto criarEventoEmAberto(Compromisso c) {
		// TODO Auto-generated method stub
		return emAberto.criarAgendamento(c);
	}

	@Override
	public boolean EditarEventoEmAberto(EmAberto evento) {
		// TODO Auto-generated method stub
		return emAberto.editarAgendamento(evento);
	}
	@Override
	public boolean EditarEvento(Definido evento) {
		// TODO Auto-generated method stub
		return calendario.editarEvento(evento);
	}
	
	@Override
	public boolean excluirEventoEmAberto(int id) {
		// TODO Auto-generated method stub
		return emAberto.excluirAgendamento(id);
	}
	
	@Override
	public boolean excluirEvento(int id) {
		// TODO Auto-generated method stub
		return calendario.excluirEvento(id);
	}
}