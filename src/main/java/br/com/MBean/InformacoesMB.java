package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.DAO.InformacoesDAO;
import br.com.Entities.Informacoes;

@ManagedBean
@SessionScoped
public class InformacoesMB {

	Informacoes i = new Informacoes();
	Informacoes in = new Informacoes();
	InformacoesDAO iDAO = new InformacoesDAO();

	Integer id;
	String cpf;
	String cep;
	String telefone;

	public void busca() {
		in = iDAO.selecInfo(id);
		if (in != null) {
			i = in;
		}
	}

	public void info() {

	}

	public Informacoes getI() {
		return i;
	}

	public void setI(Informacoes i) {
		this.i = i;
	}

	public InformacoesDAO getiDAO() {
		return iDAO;
	}

	public void setiDAO(InformacoesDAO iDAO) {
		this.iDAO = iDAO;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
