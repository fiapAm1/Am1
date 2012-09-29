<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../util/css.jsp" />
<jsp:include page="../../util/js.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Lançamento de Despesas</title>
</head>
<body>
	<s:form id="form_LancarDepesas" 
				action="cadastrarDespesa" 
				method="post" 
				class="formee"
				theme="simple">
		<fieldset>
			<legend>Lançar Despesas</legend>
			<div class="grid-6-12">
				<div class="grid-5-12">
					<s:label value="Código do Processo" for="textfield_Codigo" />
				</div>
				<div class="grid-7-12">
					<s:text id="textfield_Codigo" name="numeroProcesso" />
				</div>
			</div>
			<div class="grid-6-12" style="text-align: left;">
				<s:submit id="submit_Pesquisar"
						  value="Pesquisar"
						  action="pesquisarProcessoDespesas"/>
			</div>
			<div class="grid-12-12">
				<table id="table_Audiencias"
					   class="lawyer-table">
					<caption>Processo</caption>
					<thead>
						<tr>
							<th width="15%" class="par">Número do Processo</th>
							<th width="15%" class="par">Descrição do Processo</th>
							<th width="10%" class="par" >Cliente</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator id="iterator_Processo"
									value="processos">
							<tr>
								<td class="par"><s:property value="numeroProcesso"/></td>
								<td class="par"><s:property value="processo"/></td>
								<td class="par"><s:property value="cliente.nomePessoa"/></td>
							</tr>			
						</s:iterator>
					</tbody>
				</table>
				<table id="table_Audiencias"
					   class="lawyer-table">
					<caption>Despesas Filtadas</caption>
					<thead>
						<tr>
							<th></th>
							<th width="15%" class="par">Tipo da Despesa</th>
							<th width="15%" class="par">Valor</th>
							<th width="10%" class="par" >Data de Lançamento</th>
							<th width="30%" class="par">Observação</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator id="iterator_Despesas"
									value="despesas">
							<tr>
								<td><input type="radio" name="selected" value="true"/></td>
								<td class="par"><s:property value="source.tipoDespesa.despesa"/></td>
								<td class="par"><s:property value="source.valorDespesa"/></td>
								<td class="par"><s:date name="source.dataDespesa" format="dd/MM/yyyy"/></td>
								<td class="par"><label title="<s:property value="source.observacao"/>"/></td>
							</tr>			
						</s:iterator>
					</tbody>
				</table>
				<div class="grid-12-12">
					<div class="grid-6-12">
						<s:label value="Selecione um Tipo de Despesa:"
								 for="select_TipoDespesa"/>
						<s:select id="select_TipoDespesa"
								  headerKey="0"
								  headerValue="Selecione"
								  list="tiposDespesas"
								  listKey="codigoDespesa"
								  listValue="despesa"
								  name="depesa.tipoDespesa.codigoDespesa"
								  required="true"/>
						
					</div>
					<div class="grid-2-12">
						<s:label value="Código do Processo" for="textfield_Codigo" />
					</div>
					<div class="grid-4-12">
						<s:text id="textfield_Codigo" name="numeroProcesso" />
					</div>
				</div>
				<div class="grid-12-12">
					<s:label value="Descrição:"
					 		 for="textarea_Descricao"/>
					<s:textarea id="textarea_Descricao"
								name="despesa.observacao"/>
				</div>
			</div>
			<div class="grid-12-12">
				<hr></hr>
			</div>
			<div class="grid-12-12" style="text-align: right;">
				<s:submit id="submit_Incluir"
						  action="cadastrarDespesa"
						  value="Incluir"/>
				<s:submit id="submit_Alterar"
						  action="alterarDespesa"
						  value="Alterar"/>
				<s:submit id="submit_Excluir"
						  action="excluirDespesa"
						  value="Excluir"/>
				<s:submit id="submit_Voltar"
						  action="home"
						  value="Voltar"/>
			</div>
		</fieldset>
	</s:form>
</body>
</html>