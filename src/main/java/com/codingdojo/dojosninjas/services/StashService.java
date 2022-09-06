package com.codingdojo.dojosninjas.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Stash;
import com.codingdojo.dojosninjas.repositories.StashRepository;

@Service
public class StashService {
	@Autowired
	private StashRepository stashRepository;
	
	public void create(Stash stash) {
		stashRepository.save(stash);
	}
	
	public void update(Stash stash) {
		stashRepository.save(stash);
	}
	
	public ArrayList<Stash> findAll(){
		return stashRepository.findAll(); 
	}
	
	public Stash findById(long id) {
		return stashRepository.findById(id).orElse(null);
	}
	
	public ArrayList<Stash> findByStashLocation(String location) {
		return stashRepository.findByStashLocation(location);
	}
	

	public void deleteById(Long id) {
		stashRepository.deleteById((long) id);
	}
} 
