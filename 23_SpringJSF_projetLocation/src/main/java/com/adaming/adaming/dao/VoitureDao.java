package com.adaming.adaming.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.adaming.entities.Voiture;

@Repository
public class VoitureDao implements IGenericDao<Voiture>{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("VoitureDao");
	
	@Override
	public Voiture add(Voiture voiture) {
		em.persist(voiture);
		log.info("la voiture a bien été ajouté : "+voiture.getId());
		return voiture;
	}

	@Override
	public void delete(Long id) {
		Voiture rechercheId = getById(id);
		em.remove(rechercheId);
		log.info("la voiture a été supprimée : " +rechercheId.getId());
		
	}

	@Override
	public Voiture update(Voiture voiture) {
		em.merge(voiture);
		log.info("voiture modifiée"+voiture.getId());
		return voiture;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Voiture> getAll() {
		Query query = em.createQuery("from Voiture");
		log.info("il existe "+query.getResultList().size()+" dans la liste voiture");
		return query.getResultList();
	}

	@Override
	public Voiture getById(Long id) {
		Voiture v = em.find(Voiture.class,id);
		return v;
	}

}
