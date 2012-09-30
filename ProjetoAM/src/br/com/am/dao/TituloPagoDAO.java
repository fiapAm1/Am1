package br.com.am.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.am.bo.ProcessoBO;
import br.com.am.bo.TituloBO;
import br.com.am.dao.connections.ConnectionFactory;
import br.com.am.dao.interfaces.TituloPagoDAOInterface;
import br.com.am.model.Processo;
import br.com.am.model.Titulo;
import br.com.am.model.TituloPago;

public class TituloPagoDAO implements TituloPagoDAOInterface{

	@Override
	public void registrarTituloPago(TituloPago tituloPago) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TituloPago> consultarTitulosPagosPorProcesso(int numeroProcesso) {
		
		//Conexão
		Connection conn = ConnectionFactory.getConnectionOracle();
		
		//Comunicação
		String sql = "SELECT AM_TITULO_PAGO.NR_TITULO AS TITULO, DT_PAGAMENTO, VL_PAGO " +
				     "FROM AM_TITULO INNER JOIN  AM_TITULO_PAGO " +
				     "ON AM_TITULO.NR_TITULO = AM_TITULO_PAGO.NR_TITULO " +
				     "WHERE NR_PROCESSO = ? ";
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		TituloPago tituloPago = null;
		List<TituloPago> titulosPagos = new ArrayList<TituloPago>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroProcesso);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tituloPago = new TituloPago();
				
				Titulo titulo = TituloBO.consultarTitulo(rs.getInt("TITULO"));
				tituloPago.setTitulo(titulo);
				
				tituloPago.setDataPagamento(rs.getDate("DT_PAGAMENTO"));
				tituloPago.setValorPago(rs.getDouble("VL_PAGO"));
				
				titulosPagos.add(tituloPago);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, ps, rs);
		}
		
		return titulosPagos;

	}


}
