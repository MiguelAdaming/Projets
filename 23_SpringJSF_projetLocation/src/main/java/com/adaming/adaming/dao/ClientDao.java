package com.adaming.adaming.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.adaming.adaming.entities.Client;

@Repository
public class ClientDao implements IGenericDao<Client>{
	
	@PersistenceContext
	private EntityManager em;
	
	Logger log = Logger.getLogger("ClientDao");

	@Override
	public Client add(Client client) {
		em.persist(client);
		log.info("le client a bien été ajouté : "+client.getId());
		return client;
	}

	@Override
	public Client update(Client client) {
		em.merge(client);
		log.info("client modifié"+client.getId());
		return client;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Client> getAll() {
		Query query = em.createQuery("from Client");
		log.info("il existe "+query.getResultList().size()+" dans la liste client");
		return query.getResultList();
	}

	@Override
	public Client getById(Long id) {
		Client c = em.find(Client.class,id);
		return c;
	}

	@Override
	public void delete(Long id) {
		Client rechercheId = getById(id);
		em.remove(rechercheId);
		log.info("le client a été supprimé : " +rechercheId.getId());
		
	}

}
