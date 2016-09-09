package com.adaming.adaming.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reservation")
	private Long id;
	private Date dateDebut;
	private Date dateFin;
	private double prixTotal;
	
	//clés étrangères
	
	@ManyToOne
	@JoinColumn(name="voiture_id", referencedColumnName="id_voiture")
	private Voiture voiture;
	
	@ManyToOne
	@JoinColumn(name="client_id", referencedColumnName="id_client")
	private Client client;
	
	@OneToOne
	@JoinColumn(name="facture_id",referencedColumnName="id_facture")
	private Facture facture;

	/**
	 * Ctor vide
	 */
	public Reservation() {
		super();
	}

	/**
	 * 
	 * @param dateDebut
	 * @param dateFin
	 * @param prixTotal
	 */
	public Reservation(Date dateDebut, Date dateFin, double prixTotal) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prixTotal = prixTotal;
	}

	
	/**
	 * Getters et Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}


	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", prixTotal="
				+ prixTotal + "]";
	}


}
