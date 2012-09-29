package br.com.am.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.model.Despesa;
import br.com.am.model.Processo;

/**
 * Class Action LancarDespesas
 * @author JDGR²
 * @since 18/09/2012
 */
public class LancarDespesasAction extends GenericAction{
	
	private static final long serialVersionUID = 6688816828187072391L;
	private Processo processo;
	private List<Despesa> despesas;
	private Despesa despesa;
	
	/**
	 * Action que direciona para as páginas da funcionalidade de lançar despesas.
	 * @author JDGR²
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="forwardLancarDespesa", results={
			@Result(location="/pages/despesa/lancarDepesa.jsp", name="lancar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardLancarDespesa(){
		if(PaginaEnum.LANCAR_DESPESA.getDescricao().equals(paginaDirecionar)){
			//TODO implementar
			return PaginaEnum.LANCAR_DESPESA.getDescricao();
		} else {
			return String.valueOf(PaginaEnum.ERRO.getDescricao());
		}
	}
	
	/**
	 * Action que cadastra despesas.
	 * @author JDGR²
	 * @return String
	 * @since 18/09/2012
	 */
	@Action(value="cadastrarDespesa", results={
			@Result(location="/pages/despesa/lancarDepesa.jsp", name="lancar"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String cadastrarDespesa(){
		//TODO implementar
		return PaginaEnum.LANCAR_DESPESA.getDescricao();
	}
	
	public Processo getProcesso() {
		return processo;
	}
	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
	public List<Despesa> getDespesas() {
		return despesas;
	}
	public void setDespesas(List<Despesa> despesas) {
		this.despesas = despesas;
	}
	public Despesa getDespesa() {
		return despesa;
	}
	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}	
}