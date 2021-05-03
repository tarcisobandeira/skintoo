package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import br.com.DAO.ProdutosDAO;
import br.com.Entities.Produtos;

@ManagedBean
@SessionScoped
public class ProdutosMB extends UploadMB {

	ProdutosDAO pDAO = new ProdutosDAO();

	Produtos p = new Produtos();

	List<Produtos> pList = new ArrayList<Produtos>();

	public ProdutosMB() {
		updateList();
		String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("");
		System.out.println(path);
	}

	public void upAuto(FileUploadEvent event) {
		p.setEndereco(super.addAnexo(event).getName());
		if (p.getEndereco() != null) {
			pDAO.updateProc(p);
		}
	}

	public void addProc() {
		if (pDAO.inserir(p)) {
			System.out.println("Deu");
			updateList();
		} else {
			System.out.println("Não DEu");
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

}
