package br.com.crud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.GuiaTuristico;

public class GuiaTuristicoDAO {
	
public void save (GuiaTuristico guiaTuristico) {
	String sql = "INSERT INTO guiaturistico (nome,email,preco)" +
		"VALUES (?,?,?)";
	Connection conn = null;
	PreparedStatement pstm = null;
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, guiaTuristico.getNome());
		pstm.setString(2, guiaTuristico.getEmail());
		pstm.setDouble(3, guiaTuristico.getPreco());
		pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public void removeById(int id_guiaturistico) {
	String sql = "DELETE FROM guiaturistico WHERE id_guiaturistico = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id_guiaturistico);
		pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public void update (GuiaTuristico guiaTuristico) {
	String sql = "UPDATE guiaturistico SET nome = ?, email = ?, preco = ?"
			+ "WHERE id_guiaturistico = ?";
	Connection conn = null;
	PreparedStatement pstm = null;
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		
		pstm = conn.prepareStatement(sql);
		pstm.setString(1, guiaTuristico.getNome());
		pstm.setString(2, guiaTuristico.getEmail());
		pstm.setDouble(3,guiaTuristico.getPreco());
		pstm.setInt(4, guiaTuristico.getId_guiaturistico());
		pstm.execute();
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
public List<GuiaTuristico> getUsuarios(){
	String sql = "SELECT * FROM guiaturistico";
	
	List<GuiaTuristico> guiaTuristicos = new ArrayList<GuiaTuristico>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = conn.prepareStatement(sql);
		rset = pstm.executeQuery();
		
		while(rset.next()) {
			GuiaTuristico guiaTuristico = new GuiaTuristico();
			guiaTuristico.setId_guiaturistico(rset.getInt("id_guiaturistico"));
			guiaTuristico.setNome(rset.getString("nome"));
			guiaTuristico.setEmail(rset.getString("email"));
			guiaTuristico.setPreco(rset.getDouble("preco"));
			guiaTuristicos.add(guiaTuristico);
		}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(rset != null) {
				rset.close();
			}
			if(pstm != null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	return guiaTuristicos;
}
}
