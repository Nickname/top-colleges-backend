package com.topcolleguesbackend.entite;

import javax.persistence.*;

@Entity
@Table(name="COLLEGUE")
public class Collegue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String nom;
	@Column
	private String url;
	@Column
	private Integer score;
	
	public Collegue() {
		super();
	}

	public Collegue(String nom, String url, Integer score) {
		super();
		this.nom = nom;
		this.url = url;
		this.score = score;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}
