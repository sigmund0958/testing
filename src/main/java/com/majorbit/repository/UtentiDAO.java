package com.majorbit.repository;

import com.majorbit.model.Utenti;

public interface UtentiDAO {

	public void create(Utenti u);
	public Utenti read(Integer id);
}
