package br.com.am.action;

import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import br.com.am.action.enuns.PaginaEnum;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Class Action Genérica
 * @author Ricardo
 * @since 18/09/2012
 */
public class GenericAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -3767734831406044587L;
	
	private Map<String, Object> session;
	
	protected String paginaDirecionar;
	protected String mensagem;
	
	/**
	 * Action que direciona para as páginas comuns a todas as funcionalidades.
	 * @author Ricardo
	 * @return String
	 * @since 25/09/2012
	 */
	@Action(value="forwardPaginas", results={
			@Result(location="/pages/home.jsp", name="home"),
			@Result(location="/erro.jsp", name="erro")
	})
	public String direcionar(){
		if(PaginaEnum.HOME.getDescricao().equals(paginaDirecionar)){
			return PaginaEnum.HOME.getDescricao();
		} else {
			return PaginaEnum.ERRO.getDescricao();
		}
	}
	
	public String getPaginaDirecionar() {
		return paginaDirecionar;
	}
	public void setPaginaDirecionar(String paginaDirecionar) {
		this.paginaDirecionar = paginaDirecionar;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		if(session == null){
			session = ActionContext.getContext().getSession();
		}
		return session;
	}
}