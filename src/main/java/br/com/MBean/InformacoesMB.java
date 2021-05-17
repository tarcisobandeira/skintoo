package br.com.MBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.DAO.InformacoesDAO;
import br.com.Entities.Informacoes;

@ManagedBean
@SessionScoped
public class InformacoesMB {

	Informacoes i = new Informacoes();
	Informacoes in = new Informacoes();
	InformacoesDAO iDAO = new InformacoesDAO();

	Integer id = 0;
	String cpf;
	String cep;

	public void buscar() {
		in = iDAO.selecInfo(id);
		if (in != null) {
			i = in;
			cpf = String.valueOf(i.getCpf());
			cep = String.valueOf(i.getCep());
		}
	}

	public void info() {
		i.setCpf(tratamentoCPF(cpf));
		i.setCep(tratamentoCEP(cep));
		i.setId_usuario(id);

		if (iDAO.testInfo(id)) {
			if (iDAO.editInfo(i)) {
				System.out.println("Skintoo: Informações editadas.");
				mensagem(FacesMessage.SEVERITY_INFO, "", "Informações editadas com sucesso.");
			} else {
				System.out.println("Skintoo: Erro ao editar informações.");
				mensagem(FacesMessage.SEVERITY_ERROR, "Error",
						"Por favor, contate um administrador sobre o erro ou tente novamente mais tarde.");
			}
		} else {
			if (iDAO.criarInfo(i)) {
				System.out.println("Skintoo: Informações inseridas com sucesso.");
				mensagem(FacesMessage.SEVERITY_INFO, "", "As informações foram adicionadas com sucesso.");
			} else {
				System.out.println("Skintoo: Erro ao inserir informações.");
				mensagem(FacesMessage.SEVERITY_ERROR, "Error",
						"Por favor, contate um administrador sobre o erro ou tente novamente mais tarde.");
			}
		}
	}

	public long tratamentoCPF(String cpf) {
		String r = cpf.replace('.', '#');
		r = r.replace('-', '#');
		r = r.replace("#", "");
		long n1 = Long.parseLong(r);
		return n1;
	}

	public Integer tratamentoCEP(String cep) {
		String r = cep.replace("-", "");
		Integer n1 = Integer.parseInt(r);
		return n1;
	}

	public void mensagem(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		buscar();
	}

}
