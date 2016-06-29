package model.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Transactional
@XmlRootElement
@Entity
@Table(name="TB_ACERVO")
public class Acervo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_ACERVO")
	private Integer codigo;
	
	@Size(min=8,message="Descrição do acervo precisa ter pelo menos 8 caracteres")
	@NotNull(message="O campo descrição é obrigatório")
	@Column(name="DS_ACERVO")
	private String descricao;
	
	@Size(min=2,message="Tipo do acervo precisa ter pelo menos 2 caracteres")
	@NotNull(message="O campo tipo é obrigatório")
	@Column(name="TIPO_ACERVO")
	private String tipoAcervo;
	
	@ManyToMany
	@JoinTable(name="TB_ITEM_EMPRESTIMO", 
			   joinColumns= @JoinColumn(name="CD_ACERVO"), 
			   inverseJoinColumns= @JoinColumn(name="CD_EMPRESTIMO"))
	private List<Emprestimo> emprestimos;
	
	public Acervo() {
		super();
	}

	public Acervo(Integer codigo, String descricao, String tipoAcervo) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipoAcervo = tipoAcervo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoAcervo() {
		return tipoAcervo;
	}

	public void setTipoAcervo(String tipoAcervo) {
		this.tipoAcervo = tipoAcervo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acervo other = (Acervo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
