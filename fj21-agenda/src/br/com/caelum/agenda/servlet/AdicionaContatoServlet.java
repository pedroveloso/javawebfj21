package br.com.caelum.agenda.servlet;

import java.util.Date;
import java.util.Calendar;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;


@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {
			
			//busca o writer --> para escrever o código HTML como texto no navegador
			PrintWriter out = res.getWriter();
			
				//buscando os parametros vindos da request feita pelo navegador			
				String nome = req.getParameter("nome");
				String endereco = req.getParameter("endereco");
				String email = req.getParameter("email");
				String dataTexto = req.getParameter("dataNasc");
				Calendar dataNasc = null;
			
			//fazendo a conversao da data (Date --> Calendar)
			try{
				
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
				dataNasc = Calendar.getInstance();
				dataNasc.setTime(date);			
				
			}catch (ParseException e){				
				out.println("Erro de conversão de data");
				return; //para a execução do método				
			}
			
			//monta um objeto contato
			Contato contato = new Contato();
			contato.setNome(nome);
			contato.setEndereco(endereco);
			contato.setEmail(email);
			contato.setDataNascimento(dataNasc);
			
			//salva o contato
			ContatoDao dao = new ContatoDao(Connection);
			dao.adiciona(contato);
			
			//imprime o nome do contato que foi adicionado
			RequestDispatcher rd = req.getRequestDispatcher("/contato-adicionado.jsp");			
			rd.forward(req,res);
		}
			
}
	