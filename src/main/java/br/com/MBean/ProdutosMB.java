package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
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
	List<Produtos> ppList = new ArrayList<Produtos>();

	public ProdutosMB() {
		updateList();
	}

	public void addProc() {
		if (pDAO.inserir(p)) {
			System.out.println("Skintoo: Produto adicionado ao estoque.");
			mensagem(FacesMessage.SEVERITY_INFO, "", "Produto: " + p.getNome() + " adicionado ao estoque.");
			updateList();
			limpar();
		} else {
			System.out.println("Skintoo: Erro ao adicionar no estoque");
			mensagem(FacesMessage.SEVERITY_ERROR, "Error",
					"Problemas na comunicação com o servidor, chame um tecnico ou faça novamente mais tarde.");
		}
	}

	public void edtProc() {
		if (pDAO.updateProc(p)) {
			System.out.println("Skintoo: Produto editado com sucesso.");
			mensagem(FacesMessage.SEVERITY_INFO, "", "Produto: " + p.getNome() + " editado com sucesso.");
			updateList();
			limpar();
		} else {
			System.out.println("Skintoo: Erro ao editar o produto.");
			mensagem(FacesMessage.SEVERITY_ERROR, "Error",
					"Problemas na comunicação com o servidor, chame um tecnico ou faça novamente mais tarde.");
		}
	}

	public void upAuto(FileUploadEvent event) {
		p.setEndereco(super.addAnexo(event).getName());
		if (p.getEndereco() != null) {
			pDAO.updateImgProc(p);
			System.out.println("Skintoo: Imagem adicionada.");
			mensagem(FacesMessage.SEVERITY_INFO, "", "A imagem foi adicionada.");
		} else {
			System.out.println("Skintoo: Erro ao adicionar imagem.");
			mensagem(FacesMessage.SEVERITY_WARN, "", "Erro ao adicionar a imagem.");
		}
	}

	public void desativarP(int id) {
		if (pDAO.desativarProc(id)) {
			updateList();
			System.out.println("Skintoo: Produto desativado.");
			mensagem(FacesMessage.SEVERITY_INFO, "", "Produto desativado.");
		} else {
			System.out.println("Skintoo: Erro ao desativar o produto.");
			mensagem(FacesMessage.SEVERITY_WARN, "", "Erro ao desativar o produto.");
		}
	}

	public void ativarP(int id) {
		if (pDAO.ativarProc(id)) {
			updateList();
			System.out.println("Skintoo: Produto ativado.");
			mensagem(FacesMessage.SEVERITY_INFO, "", "Produto ativado.");
		} else {
			System.out.println("Skintoo: Erro ao ativar o produto.");
			mensagem(FacesMessage.SEVERITY_WARN, "", "Erro ao ativar o produto.");
		}
	}

	public void updateList() {
		pList = pDAO.listaProdutos();
		ppList = pDAO.listaProdutosPub();
	}

	public void limpar() {
		p = new Produtos();
	}

	public void mensagem(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
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

	public List<Produtos> getPpList() {
		return ppList;
	}

	public void setPpList(List<Produtos> ppList) {
		this.ppList = ppList;
	}

}
