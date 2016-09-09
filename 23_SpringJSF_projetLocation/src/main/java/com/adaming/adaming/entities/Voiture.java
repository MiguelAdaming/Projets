package com.adaming.adaming.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voiture {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_voiture")
	private Long id;
	private long kilometrage;
	private String model;
	private int annee;
	private double prix;
	private String immatriculation;
	
	//clés étrangères
	@OneToMany(mappedBy="voiture", cascade = CascadeType.ALL)
	private List<Reservation> listeReservation;
	
	@ManyToOne
	@JoinColumn(name="agence_id", referencedColumnName="id_agence")
	private Agence agence;

	/**
	 * Ctor vide
	 */
	public Voiture() {
		super();
	}


	/**
	 * 
	 * @param kilometrage
	 * @param model
	 * @param annee
	 * @param prix
	 * @param immatriculation
	 */
	public Voiture(long kilometrage, String model, int annee, double prix, String immatriculation) {
		super();
		this.kilometrage = kilometrage;
		this.model = model;
		this.annee = annee;
		this.prix = prix;
		this.immatriculation = immatriculation;
	}


	/**
	 * 
	 * Getters et setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(long kilometrage) {
		this.kilometrage = kilometrage;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * to String
	 */
	@Override
	public String toString() {
		return "Voiture [id=" + id + ", kilometrage=" + kilometrage + ", model=" + model + ", annee=" + annee
				+ ", prix=" + prix + ", immatriculation=" + immatriculation + ", agence=" + agence + "]";
	}
	
	
	
}
