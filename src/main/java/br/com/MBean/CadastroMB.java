package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
				System.out.println("DEU");
			} else {
				System.out.println("NÃO DEU");
			}
		} else {
			System.out.println("Senha Errada");
			
		}
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
