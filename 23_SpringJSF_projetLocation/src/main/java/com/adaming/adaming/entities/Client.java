package com.adaming.adaming.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_client")
	private Long id;
	private String nom;
	private String prenom;
	private Date dateDeNaissance;
	private Date datePermis;
	private long telephone;
	private String adresse;
	private String mail;
	
	//clés étrangères
		@OneToMany(mappedBy="client", cascade = CascadeType.ALL)
		private List<Reservation> listeReservation;

		
		/**
		 * Ctor vide
		 */
		public Client() {
			super();
		}


		/**
		 * 
		 * @param nom
		 * @param prenom
		 * @param dateDeNaissance
		 * @param datePermis
		 * @param telephone
		 * @param adresse
		 * @param mail
		 */
		public Client(String nom, String prenom, Date dateDeNaissance, Date datePermis, long telephone, String adresse,
				String mail) {
			super();
			this.nom = nom;
			this.prenom = prenom;
			this.dateDeNaissance = dateDeNaissance;
			this.datePermis = datePermis;
			this.telephone = telephone;
			this.adresse = adresse;
			this.mail = mail;
		}



		/**
		 * getters et setters
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


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public Date getDateDeNaissance() {
			return dateDeNaissance;
		}


		public void setDateDeNaissance(Date dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}


		public Date getDatePermis() {
			return datePermis;
		}


		public void setDatePermis(Date datePermis) {
			this.datePermis = datePermis;
		}


		public long getTelephone() {
			return telephone;
		}


		public void setTelephone(long telephone) {
			this.telephone = telephone;
		}


		public String getAdresse() {
			return adresse;
		}


		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}


		public String getMail() {
			return mail;
		}


		public void setMail(String mail) {
			this.mail = mail;
		}


		public List<Reservation> getListeReservation() {
			return listeReservation;
		}


		public void setListeReservation(List<Reservation> listeReservation) {
			this.listeReservation = listeReservation;
		}


		/**
		 * to String
		 */
		@Override
		public String toString() {
			return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
					+ ", datePermis=" + datePermis + ", telephone=" + telephone + ", adresse=" + adresse + ", mail="
					+ mail + "]";
		}
		
		

}
