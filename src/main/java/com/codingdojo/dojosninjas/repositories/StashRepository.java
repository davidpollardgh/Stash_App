package com.codingdojo.dojosninjas.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojosninjas.models.Stash;

@Repository
public interface StashRepository extends CrudRepository<Stash, Long> {
	public ArrayList<Stash> findAll();
	
	public ArrayList<Stash> findByStashLocation(String location);	
}
