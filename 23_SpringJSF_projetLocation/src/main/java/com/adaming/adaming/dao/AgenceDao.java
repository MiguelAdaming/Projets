package com.adaming.adaming.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adaming.adaming.entities.Agence;

@Repository
public class AgenceDao implements IGenericDao<Agence>{

	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("AgenceDao");
	
	@Override
	public Agence add(Agence agence) {
		em.persist(agence);
		log.info("l'agence a bien été ajoutée : "+ agence.getId());
		return agence;
	}

	@Override
	public void delete(Long id) {
		Agence rechercheId = getById(id);
		em.remove(rechercheId);
		log.info("l'agence a été supprimée : " +rechercheId.getId());
		
	}

	@Override
	public Agence update(Agence agence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Agence> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agence getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
