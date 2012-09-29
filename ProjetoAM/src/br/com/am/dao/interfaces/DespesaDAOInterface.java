/**
 * 
 */
package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Despesa;

/**
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>
 *
 */
public interface DespesaDAOInterface {
	
	/**
	 * Busca todos lançamentos de despesa existentes na tabela AM__DESPESA
	 * @return List<Despesa>
	 */
	public List<Despesa> consultarDespesas();
	
	/**
	 *  Listar Processos válidos por despesa
	 * @param numeroProcesso
	 * @return
	 */
	
	public List<Despesa> consultarDespesasPorProcesso(int numeroProcesso );
	
	/**
	 * Busca um lançamento de despesa específico através do código do lançamento fornecido
	 * @param codigoLancamento
	 * @return TipoDespesa
	 */
	public Despesa consultarDespesa(int codigoLancamento);
	
	/**
	 * Insere uma nova despesa na tabela AM_DESPESA relacionada a um processo
	 * @param despesa
	 */
	public void lancarDespesa(Despesa despesa);
	
	/**
	 * Somar os valores do Processo
	 * @param codigoProcesso
	 * @return
	 */
	
	public double somarDespesaPorProcesso (int codigoProcesso);
	

}
