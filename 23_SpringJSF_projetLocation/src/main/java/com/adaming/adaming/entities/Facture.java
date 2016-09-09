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
public class Facture {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_facture")
	private Long id;
	private Date dateFacturation;
	
	//clés étrangères
	@OneToOne
	@JoinColumn(name="reservation_id",referencedColumnName="id_reservation")
	private Reservation reservation;
	
	@ManyToOne
	@JoinColumn(name="agence_id", referencedColumnName="id_agence")
	private Agence agence;


	/**
	 * Ctor vide
	 */
	public Facture() {
		super();
	}

	/**
	 * 
	 * @param dateFacturation
	 */
	public Facture(Date dateFacturation) {
		super();
		this.dateFacturation = dateFacturation;
	}

	/**
	 * Getters et setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateFacturation() {
		return dateFacturation;
	}

	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * To String
	 */
	@Override
	public String toString() {
		return "Facture [id=" + id + ", dateFacturation=" + dateFacturation + "]";
	}

	
}
