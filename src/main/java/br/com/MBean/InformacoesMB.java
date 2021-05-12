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

	public void busca() {
		in = iDAO.selecInfo(id);
		if (in != null) {
			i = in;
		}
	}

	public void info() {
		i.setCpf(tratamentoCPF(cpf));
		i.setCep(tratamentoCEP(cep));
		i.setId_usuario(id);

		if (iDAO.testInfo(id)) {
			if (iDAO.editInfo(i)) {
				System.out.println("DEU cececece edita");
			} else {
				System.out.println("N edita");
			}
		} else {
			if (iDAO.criarInfo(i)) {
				System.out.println("DEU cececece cria");
			} else {
				System.out.println("N cria");
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
	}

}
