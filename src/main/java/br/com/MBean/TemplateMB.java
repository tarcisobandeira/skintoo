package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TemplateMB {

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
		} else if (opt == 7) {
			return "/Template/Produtos/addProdutos.xhtml";
		} else if (opt == 8) {
			return "/Template/Produtos/edtProdutos.xhtml";
		} else if (opt == 9) {
			return "/Template/Usuario/informacoes.xhtml";
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

}
