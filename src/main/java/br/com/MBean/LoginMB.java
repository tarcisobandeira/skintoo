package br.com.MBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.DAO.LoginDAO;
import br.com.Entities.Usuario;

@ManagedBean
@SessionScoped
public class LoginMB {

	LoginDAO ldao = new LoginDAO();
	Usuario u = new Usuario();

	public String login;
	public String senha;
	public boolean logado = false;

	@ManagedProperty(value = "#{templateMB}")
	TemplateMB tMB;

	public void logar() {
		u = ldao.buscarUsuario(login);
		if (u != null && u.getSenha().equals(senha)) {
			System.out.println("Skintoo: " + u.getNome() + " fez login.");
			mensagem(FacesMessage.SEVERITY_INFO, u.getNome() + " " + u.getSobrenome(), "Bem Vindo");
			logado = true;
			limpar();
			tMB.setOpt(1);
		} else {
			System.out.println("Skintoo: Usuário ou Senha invalida.");
			mensagem(FacesMessage.SEVERITY_WARN, "", "Usuário ou Senha invalida.");
		}
	}

	public String deslogar() {
		System.out.println("Skintoo: Usuário " + u.getNome() + " deslogou.");
		u = new Usuario();
		logado = false;
		tMB.setOpt(1);
		return "home?faces-redirect=true";
	}

	public void limpar() {
		login = null;
		senha = null;
	}

	public void mensagem(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public LoginDAO getLdao() {
		return ldao;
	}

	public void setLdao(LoginDAO ldao) {
		this.ldao = ldao;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public TemplateMB gettMB() {
		return tMB;
	}

	public void settMB(TemplateMB tMB) {
		this.tMB = tMB;
	}

}
