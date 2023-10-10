package com.majorbit.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.majorbit.model.Utenti;

public class UtentiDAOImpl implements UtentiDAO{
	
	private UtentiDAOImpl() {};
	private static UtentiDAOImpl instance= null;
	public static UtentiDAOImpl getInstance() {
		if(instance==null) {
			instance= new UtentiDAOImpl();
		}
		return instance;
	}

	@Override
	public void create(Utenti u) {
		
		Connection connection= DBConnection.getInstance().getConnection();
		String query= "insert into utenti_Fazi( id, nome, cognome) values ("+u.getId()+",'"+u.getNome()+"','"+u.getCognome()+"')";
		try {
			Statement stmt= connection.createStatement();
			stmt.execute(query);
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
		Utenti u=new Utenti();
		String query="select * from utenti_Fazi where id="+id;
		try {
			Statement stmt= connection.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			while(rs.next()) {
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
