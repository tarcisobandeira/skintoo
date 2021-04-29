package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TemplateMB {

	@ManagedProperty(value = "#{produtosMB}")
	ProdutosMB pMB;

	public int opt = 1;

	public String mudar() {
		if (opt == 1) {
			return "/Template/Inicio/inicio.xhtml";
		} else if (opt == 2) {
			return "/Template/Login/login.xhtml";
		} else if (opt == 3) {
			return "/Template/Login/cadastro.xhtml";
		} else if (opt == 4) {
			return "/Template/Produtos/produtos.xhtml";
		} else if (opt == 5) {
			return "/Template/Produtos/admProdutos.xhtml";
		} else if (opt == 6) {
			return "/Template/Opnioes/opnioes.xhtml";
		}
		return null;
	}

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
		mudar();
	}

	public ProdutosMB getpMB() {
		return pMB;
	}

	public void setpMB(ProdutosMB pMB) {
		this.pMB = pMB;
	}

}
