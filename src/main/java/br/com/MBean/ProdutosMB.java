package br.com.MBean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import br.com.DAO.InformacoesDAO;
import br.com.DAO.ProdutosDAO;
import br.com.Entities.Produtos;

@ManagedBean
@SessionScoped
public class ProdutosMB extends UploadMB {

	@ManagedProperty(value = "#{templateMB}")
	TemplateMB tMB;

	ProdutosDAO pDAO = new ProdutosDAO();
	InformacoesDAO iDAO = new InformacoesDAO();

	Produtos p = new Produtos();

	Integer quantia;

	List<Produtos> pList = new ArrayList<Produtos>();
	List<Produtos> ppList = new ArrayList<Produtos>();

	public ProdutosMB() {
		updateList();
		quantia = 1;
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

	public void testLoginInfo(int id) {
		if (id != 0) {
			if (iDAO.testInfoCast(id)) {
				tMB.setOpt(10);
			} else {
				limpar();
				tMB.setOpt(9);
				mensagem(FacesMessage.SEVERITY_WARN, "", "Por favor, Preencha suas informações para efetuar a compra.");
			}
		} else {
			limpar();
			tMB.setOpt(2);
			mensagem(FacesMessage.SEVERITY_WARN, "",
					"Por favor, faça login e preencha suas informações para efetuar a compra.");
		}
	}

	public void comprar() {
		int i = p.getQuantidade() - quantia;
		if (pDAO.updateEstoque(p.getId(), i)) {
			System.out.println("Skintoo: Foi comprado " + quantia + " do produto " + p.getNome() + ".");
			mensagem(FacesMessage.SEVERITY_INFO, "",
					"Compra de " + quantia + " do produto " + p.getNome() + " feita com sucesso.");
			mensagem(FacesMessage.SEVERITY_INFO, "", "Favor de olhar o seu Email para finalizar a compra.");
			updateList();
			tMB.setOpt(4);
		} else {
			System.out.println("Skintoo: Erro ao comprar.");
			mensagem(FacesMessage.SEVERITY_WARN, "Error",
					"Por favor, contactar um administrador ou tentar novamente mais tarde.");
		}
	}

	public void updateList() {
		pList = pDAO.listaProdutos();
		ppList = pDAO.listaProdutosPub();
		quantia = 1;
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

	public TemplateMB gettMB() {
		return tMB;
	}

	public void settMB(TemplateMB tMB) {
		this.tMB = tMB;
	}

	public InformacoesDAO getiDAO() {
		return iDAO;
	}

	public void setiDAO(InformacoesDAO iDAO) {
		this.iDAO = iDAO;
	}

	public Integer getQuantia() {
		return quantia;
	}

	public void setQuantia(Integer quantia) {
		this.quantia = quantia;
	}

}
