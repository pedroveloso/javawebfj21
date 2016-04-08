package br.com.caelum.jdbc.teste;

import java.util.*;
import br.com.caelum.jdbc.modelo.*;
import br.com.caelum.jdbc.dao.*;

public class TestaInsere {
	
	public static void main(String args[]){
		
		//pronto para gravar		
		Contato contato = new Contato();
		contato.setNome("Caelum");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj 57");
		contato.setDataNascimento(Calendar.getInstance());
		
		//grave essa conexão!!!
		ContatoDao dao = new ContatoDao();
		
		//método elegante
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
	}

}
