package br.com.augusto.dao;

import java.util.List;

public interface DAOBase<T> {
	public List<T> list();
	
	public void persistir(T objeto);
	
	public void excluir(T objeto);
	
	public T get(Integer id);
	
	public void altera(T objeto);
}
