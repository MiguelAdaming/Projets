package com.adaming.adaming.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import com.adaming.adaming.entities.Facture;
@Entity
public class Agence {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agence")
	private Long id;
	private String nom;
	private String adresse;
	private long telephone;
	private String mail;
	
	//clés étrangères
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="agence_client")
	private List<Client> listeClient;
	
	@OneToMany(mappedBy="agence", cascade = CascadeType.ALL)
	private List<Voiture> listeVoiture;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="agence_reservations")
	private List<Reservation> listeReservation;
	
	@OneToMany(mappedBy="agence", cascade = CascadeType.ALL)
	private List<Facture> listeFacture;

	/**
	 * Ctor vide
	 */
	public Agence() {
		super();
	}

	/**
	 * 
	 * @param nom
	 * @param adresse
	 * @param telephone
	 * @param mail
	 */
	public Agence(String nom, String adresse, long telephone, String mail) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Client> getListeClient() {
		return listeClient;
	}

	public void setListeClient(List<Client> listeClient) {
		this.listeClient = listeClient;
	}

	public List<Voiture> getListeVoiture() {
		return listeVoiture;
	}

	public void setListeVoiture(List<Voiture> listeVoiture) {
		this.listeVoiture = listeVoiture;
	}

	
	public List<Facture> getListeFacture() {
		return listeFacture;
	}

	public void setListeFacture(List<Facture> listeFacture) {
		this.listeFacture = listeFacture;
	}

	/**
	 * To String
	 */
	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + ", mail="
				+ mail + "]";
	}

	
	
}
