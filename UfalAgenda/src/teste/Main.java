package teste;

import java.util.ArrayList;

import br.ufal.aracomp.ufalagenda.operacoesAutenticacaoNotificacao.AutenticacaoController;
import br.ufal.aracomp.ufalagenda.persistencia.metamodel.*;
public class Main {
	
	
	
	public static void main(String[] args) {
		
		AutenticacaoController controlleruser = new AutenticacaoController();
		
		/*Autenticar Login*/
		Usuario resultado = controlleruser.autenticarLogin("maurinho", "eusoulindinho");
		System.out.println(resultado.toString());
		
		/*Autenticar Email*/
		Usuario resultado2 = controlleruser.autenticarEmail("maurinho@arroba.kilo", "eusoulindinho");
		System.out.println(resultado2.toString());
		
		/*Autenticar Email*/
		Usuario resultado3 = controlleruser.autenticarEmail("maurinho@arroba.kilos", "eusoulindinho");
		System.out.println(resultado3.toString());
		
	}
	
	
}
