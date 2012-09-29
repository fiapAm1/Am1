package br.com.am.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import br.com.am.action.enuns.PaginaEnum;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Class Action Genérica
 * @author Ricardo
 * @since 18/09/2012
 */
public class GenericAction extends ActionSupport{

	private static final long serialVersionUID = -3767734831406044587L;
	
	private HttpSession session;
	
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
	public HttpSession getSession() {
		session = ServletActionContext.getRequest().getSession(false);
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
}
