package br.com.ujr.isus.model;

import java.math.BigDecimal;

public class Produto {
	
	private Integer id;
	private String descricao;
	private BigDecimal preco;
	private Enum<Unidade> unidade;
	
	public Produto(Integer id, String descricao, BigDecimal preco, Enum<Unidade> unidade) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.unidade = unidade;
	}
	private Produto() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	public Enum<Unidade> getUnidade() {
		return unidade;
	}
	public void setUnidade(Enum<Unidade> unidade) {
		this.unidade = unidade;
	}

	public enum Unidade {
		LITRO,PACOTE,UNITARIO
	}
	
	/**
	 * Builder (Pattern)
	 * Usage: 
	 * Produto produto = Builder.Instance()
	 *							.id(2)
	 *							.descricao("teste")
	 *							.build();
	 * @author Ualter Jr.
	 */
	public static class Builder {
		private Produto produto;
		public static Builder Instance() {
			Builder builder = new Builder();
			return builder;
		}
		private Builder() {
			this.produto = new Produto();
		}
		public Builder id(Integer id) {
			this.produto.setId(id);
			return this;
		}
		public Builder id(int id) {
			this.produto.setId(new Integer(id));
			return this;
		}
		public Builder descricao(String descricao) {
			this.produto.setDescricao(descricao);
			return this;
		}
		public Builder preco(BigDecimal preco) {
			this.produto.setPreco(preco);
			return this;
		}
		public Builder preco(float preco) {
			this.produto.setPreco(new BigDecimal(preco));
			return this;
		}
		public Builder unidade(Enum<Unidade> unidade) {
			this.produto.setUnidade(unidade);
			return this;
		}
		public Produto build() {
			return this.produto;
		}
	}

}
