package br.com.am.dao.interfaces;

import java.util.List;

import br.com.am.model.Titulo;


/**
 * 
 * @author Rodrigo Joubert<br>
 * Turma:  1TDSR<br>
 * Ano:    2012<br>	
 */
public interface TituloDAOInterface {
	
	public List<Titulo> consultarTitulos(int numeroProcesso);

}