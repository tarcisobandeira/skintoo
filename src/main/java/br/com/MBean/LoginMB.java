package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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

	public String logar() {
		u = ldao.buscarUsuario(login);
		if (u != null && u.getSenha().equals(senha)) {
			System.out.println("deu");
			logado = true;
			limpar();
			tMB.setOpt(1);
			return "home?faces-redirect=true";
		} else {
			System.out.println("não deu");
			return null;
		}
	}

	public String deslogar() {
		u = new Usuario();
		logado = false;
		tMB.setOpt(1);
		return "home?faces-redirect=true";
	}

	public void limpar() {
		login = null;
		senha = null;
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
