package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.DAO.ProdutosDAO;
import br.com.Entities.Produtos;

@ManagedBean
@SessionScoped
public class ProdutosMB {

	ProdutosDAO pDAO = new ProdutosDAO();

	Produtos p = new Produtos();

	List<Produtos> pList = new ArrayList<Produtos>();

	public ProdutosMB() {
		pList = pDAO.listaProdutos();
	}

	public void addProc() {

	}
	
	public void updateList() {
		pList = pDAO.listaProdutos();
	}

	public ProdutosDAO getpDAO() {
		return pDAO;
	}

	public void setpDAO(ProdutosDAO pDAO) {
		this.pDAO = pDAO;
	}

	public List<Produtos> getpList() {
		return pList;
	}

	public void setpList(List<Produtos> pList) {
		this.pList = pList;
	}

	public Produtos getP() {
		return p;
	}

	public void setP(Produtos p) {
		this.p = p;
	}

}
