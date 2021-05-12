package br.com.Entities;

public class Informacoes {

	private Integer id;
	private Integer id_usuario;
	private long cpf;
	private String telefone;
	private String estado;
	private String cidade;
	private String rua;
	private Integer numero_casa;
	private String complemento;
	private String referencia;
	private Integer cep;
	private Integer cadastrado;

	public Informacoes(Integer id, Integer id_usuario, long cpf, String telefone, String estado, String cidade,
			String rua, Integer numero_casa, String complemento, String referencia, Integer cep, Integer cadastrado) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.cpf = cpf;
		this.telefone = telefone;
		this.estado = estado;
		this.cidade = cidade;
		this.rua = rua;
		this.numero_casa = numero_casa;
		this.complemento = complemento;
		this.referencia = referencia;
		this.cep = cep;
		this.cadastrado = cadastrado;
	}

	public Informacoes() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero_casa() {
		return numero_casa;
	}

	public void setNumero_casa(Integer numero_casa) {
		this.numero_casa = numero_casa;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getCadastrado() {
		return cadastrado;
	}

	public void setCadastrado(Integer cadastrado) {
		this.cadastrado = cadastrado;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

}
