package com.majorbit.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.majorbit.model.Utenti;

public class UtentiPreparedDAOImpl implements UtentiDAO{
	
	private UtentiPreparedDAOImpl() {};
	private static UtentiPreparedDAOImpl instance=null;
	public static UtentiPreparedDAOImpl getInstance() {
		if(instance==null) {
			instance= new UtentiPreparedDAOImpl();
		}
		return instance;
	}

	@Override
	public void create(Utenti u) {
		
		Connection connection= DBConnection.getInstance().getConnection();
		String query="insert into utenti_Fazi(id, nome, cognome) values(?,?,?)";
		try {
			PreparedStatement pstmt= connection.prepareStatement(query);
			pstmt.setInt(1, u.getId());
			pstmt.setString(2, u.getNome());
			pstmt.setString(3, u.getCognome());
			pstmt.execute();
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public Utenti read(Integer id) {
		
		Connection connection= DBConnection.getInstance().getConnection();
		Utenti u= new Utenti();
		String query="select * from utenti_Fazi where id=?";
		try {
			PreparedStatement pstmt= connection.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setCognome(rs.getString("cognome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return u;
	}

}
