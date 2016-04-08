<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="cabecalho.jsp"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de contatos</title>
</head>
<body>
	<!-- cria o DAO -->
	<!--	<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"/> -->
	
	<table>
		<!-- percorre contatos montando as linhas da tabela  -->
		<c:forEach var="c" items="${contatos}">
			<tr>
				<td>${c.nome}</td>
				<td>
					<c:choose>
						<c:when test="${not empty c.email}"> 
							<a href="mailto:${c.email}">${c.email}</a>
						</c:when>
						<c:otherwise>E-mail não informado</c:otherwise>
					</c:choose>				
				</td>
				<td>${c.endereco}</td>
				<td><fmt:formatDate value="${c.dataNascimento.time}" pattern="dd/MM/yyyy"/></td>
				
				<td>
					<a href="mvc?logica=RemoveContatoLogic&id=${c.id}">Remover</a>
				</td>
			</tr>> 
		</c:forEach>
	</table>	
	
	<c:import url="rodape.jsp"/>
	
</body>
</html>