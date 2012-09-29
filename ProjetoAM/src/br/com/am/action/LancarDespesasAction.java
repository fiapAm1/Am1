package br.com.am.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.DespesaBO;
import br.com.am.model.Despesa;
import br.com.am.model.Processo;
import br.com.am.model.SelectObject;

/**
 * Class Action LancarDespesas
 * @author JDGR�
 * @since 18/09/2012
 */
public class LancarDespesasAction extends GenericAction{
	
	private static final long serialVersionUID = 6688816828187072391L;
	private Processo processo;
	private List<Processo> processos;
	private List<SelectObject> despesas;
	private Despesa despesa;
	
	/**
	 * Action que direciona para as p�ginas da funcionalidade de lan�ar despesas.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="forwardLancarDespesa", results={
			@Result(location="/pages/despesa/lancarDepesa.jsp", name="lancar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardLancarDespesa(){
		if(PaginaEnum.LANCAR_DESPESA.getDescricao().equals(paginaDirecionar)){
			return PaginaEnum.LANCAR_DESPESA.getDescricao();
		} else {
			return String.valueOf(PaginaEnum.ERRO.getDescricao());
		}
	}
	
	/**
	 * Action que cadastra despesas.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="cadastrarDespesa", results={
			@Result(location="/pages/despesa/lancarDepesa.jsp", name="lancar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String cadastrarDespesa(){
		try {
			DespesaBO.lancarDespesa(despesa);
		} catch (Exception e) {
			mensagem = e.getMessage();
			e.printStackTrace();
		}
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	/**
	 * Action que pesquisa o processo.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="pesquisarProcessoDespesas", results={
			@Result(location="/pages/despesa/lancarDepesa.jsp", name="lancar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String pesquisarProcessoDespesas(){
		try {
			processos = new ArrayList<Processo>();
			processos.add(DespesaBO.consultarProcesso(processo.getNumeroProcesso()));
			//TODO implementar despesas = DespesaBO.consultarDespesas(processo.getNumeroProcesso());
		} catch (Exception e) {
			mensagem = e.getMessage();
			e.printStackTrace();
		}
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	/**
	 * Action que localizar despesa selecionada.
	 * @author JDGR�
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="localizarDespesa", results={
			@Result(location="/pages/despesa/lancarDepesa.jsp", name="lancar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String localizarDespesa(){
		for(SelectObject so: despesas){
			if(so.getSelected()){
				despesa = (Despesa) so.getSource();
			}
		}
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	public Despesa getDespesa() {
		return despesa;
	}
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public List<SelectObject> getDespesas() {
		return despesas;
	}

	public void setDespesas(List<SelectObject> despesas) {
		this.despesas = despesas;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}
}