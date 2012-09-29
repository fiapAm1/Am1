package br.com.am.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;
import br.com.am.bo.TituloBO;
import br.com.am.model.Processo;
import br.com.am.model.TipoCobranca;
import br.com.am.model.Titulo;
import br.com.am.model.TituloPago;

/**
 * Class Action RegistrarPagamento
 * @author Ricardo
 * @since 27/09/2012
 */
public class RegistrarPagamentoAction extends GenericAction{

	private static final long serialVersionUID = -1053449491716658470L;
	
	private List<Processo> processos;
	private List<TipoCobranca> tiposCobranca;
	private List<Titulo> titulos;
	private List<TituloPago> titulosPagos;
	
	private Processo processo;
	
	/**
	 * Action que direciona para página de registro de pagamento.
	 * @author Ricardo
	 * @return String
	 * @since 27/09/2012
	 */
	@Action(value="forwardRegistrarPagamento", results={
			@Result(location="/pages/pagamento/registrarPagamento.jsp", name="registrarPagamento"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String forwardRegistrarPagamento(){
		if(PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao().equals(paginaDirecionar)){
			tiposCobranca = TituloBO.consultarTiposCobrancas();
			return PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao();
		} else {
			return PaginaEnum.ERRO.getDescricao();
		}
	}
	
	/**
	 * Action que registra pagamento de um título.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="registrarPagamento", results={
			@Result(location="/pages/pagamento/registrarPagamento.jsp", name="registrarPagamento"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String registrarPagamento(){
		//TODO implementar
		return PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao();
	}
	
	/**
	 * Action para pesquisar processos
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return String
	 */
	@Action(value="pesquisarProcessos", results={
			@Result(location="/pages/pagamento/registrarPagamento.jsp", name="registrarPagamento"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String pesquisarProcessos(){
		//TODO implementar
		return PaginaEnum.REGISTRAR_PAGAMENTO.getDescricao();
	}
	
	/**
	 * Método para carregar os títulos pagos de um processo.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return List<TituloPago>
	 */
	private List<TituloPago> carregarTitulosPagos(){
		//TODO implementar
		return new ArrayList<TituloPago>();
	}
	
	/**
	 * Método para carregar os títulos de um processo.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return List<Titulo>
	 */
	private List<Titulo> carregarTitulos(){
		//TODO implementar
		return TituloBO.consultarTitulos(processo.getNumeroProcesso());
	}
	
	/**
	 * Método para carregar os tipos de cobranças.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return List<TipoCobranca>
	 */
	private List<TipoCobranca> carregarTiposCobrancas(){
		return TituloBO.consultarTiposCobrancas();
	}
	
	/**
	 * Método para carregar processos.
	 * @author Ricardo
	 * @since 27/09/2012
	 * @return List<Processo>
	 */
	private List<Processo> carregarProcessos(){
		//TODO implementar
		return new ArrayList<Processo>();
	}

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public List<TipoCobranca> getTiposCobranca() {
		return tiposCobranca;
	}

	public void setTiposCobranca(List<TipoCobranca> tiposCobranca) {
		this.tiposCobranca = tiposCobranca;
	}

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public List<TituloPago> getTitulosPagos() {
		return titulosPagos;
	}

	public void setTitulosPagos(List<TituloPago> titulosPagos) {
		this.titulosPagos = titulosPagos;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}
}