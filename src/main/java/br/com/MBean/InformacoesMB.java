package br.com.MBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.DAO.InformacoesDAO;
import br.com.Entities.Informacoes;

@ManagedBean
@SessionScoped
public class InformacoesMB {

	Informacoes i = new Informacoes();
	InformacoesDAO iDAO = new InformacoesDAO();

	int id;
	String cpf;
	String telefone;
	String cep;

	public void busca() {
		i = iDAO.selecInfo(id);
	}

	public void info() {
		i.setId_usuario(id);
		i.setCpf(tratamentoCpf(cpf));
//		if (iDAO.testInfo(id)) {
//			if (iDAO.editInfo(i)) {
//				System.out.println("Deuuuu edit");
//			} else {
//				System.out.println("Deuuuu não edit");
//			}
//		} else {
//			if (iDAO.criarInfo(i)) {
//				System.out.println("Deuuuu edit");
//			} else {
//				System.out.println("Deuuuu não edit");
//			}
//		}
	}

	public Integer tratamentoCpf(String cpf) {
		Integer n1 = null;

		System.out.println(cpf);
		return n1;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
