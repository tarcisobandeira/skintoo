package br.com.Entities;

public class Produtos {

	private Integer id;
	private String nome;
	private Integer quantidade;
	private String endereco;

	public Produtos(Integer id, String nome, Integer quantidade, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.endereco = endereco;
	}

	public Produtos() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
