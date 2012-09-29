package br.com.am.bo;

import java.util.List;

import br.com.am.dao.factory.DAOFactory;
import br.com.am.dao.interfaces.TituloDAOInterface;
import br.com.am.model.Titulo;

/**
 * Business Object Título. Contém os métodos que vão ser usados, apenas para a funcionalidade de Registrar Pagamento.
 * @author Ricardo
 * @since 26/09/2012
 */
public class TituloBO extends GenericBO{

	/**
	 * Método que retorna uma lista de títulos por processo, a partir do número do processo passado como paramentro.
	 * @author Rodrigo
	 * @since 26/09/2012
	 * @param numeroProcesso
	 * @return
	 */
	public static List<Titulo> consultarTitulos(int numeroProcesso) {
		TituloDAOInterface tituloDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE).getTituloDAO();
		return tituloDAO.consultarTitulos(numeroProcesso);
	}
}