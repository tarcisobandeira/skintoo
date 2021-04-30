package br.com.MBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.file.UploadedFile;

import br.com.DAO.ProdutosDAO;
import br.com.Entities.Produtos;

@ManagedBean
@RequestScoped
public class ProdutosMB extends UploadMB {

	ProdutosDAO pDAO = new ProdutosDAO();

	Produtos p = new Produtos();
	private UploadedFile up;

	List<Produtos> pList = new ArrayList<Produtos>();

	public ProdutosMB() {
		updateList();
	}

	public void addProc() {
		if (up != null) {
			File file = super.addAnexo(up);
			p.setEndereco(file.getName());
			if (pDAO.inserir(p)) {
				System.out.println("Deu");
				updateList();
			} else {
				System.out.println("Não DEu");
			}
		} else {
			System.out.println("up ta null");
		}
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

	public UploadedFile getUp() {
		return up;
	}

	public void setUp(UploadedFile up) {
		this.up = up;
	}

}
