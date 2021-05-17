package br.com.MBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.DAO.CadastroDAO;
import br.com.Entities.Usuario;

@ManagedBean
@SessionScoped
public class CadastroMB {

	Usuario u = new Usuario();
	String senha;
	CadastroDAO cDAO = new CadastroDAO();

	public void criar() {
		if (senha.equals(u.getSenha())) {
			if (cDAO.inserir(u)) {
				System.out.println("Skintoo: Usuário cadastrado com sucesso.");
				mensagem(FacesMessage.SEVERITY_INFO, "Usuário cadastrado,", " favor olhar o email para confirmar o cadastro.");
				limpar();
			} else {
				System.out.println("Skintoo: Erro ao cadastrar o usuário.");
				mensagem(FacesMessage.SEVERITY_ERROR, "Error",
						"Por favor, contate um administrador sobre o erro ou tente novamente mais tarde.");
			}
		} else {
			System.out.println("Skintoo: Senha errada.");
			mensagem(FacesMessage.SEVERITY_WARN, "", "As senhas não estão iguais.");
			senha = null;
			u.setSenha(null);
		}
	}

	public void limpar() {
		u = new Usuario();
		senha = null;
	}

	public void mensagem(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CadastroDAO getcDAO() {
		return cDAO;
	}

	public void setcDAO(CadastroDAO cDAO) {
		this.cDAO = cDAO;
	}

}
