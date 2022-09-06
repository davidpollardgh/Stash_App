package com.codingdojo.dojosninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.dojosninjas.models.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

//public interface UserRepository extends CrudRepository<User, Long> {
//	Optional<User> findByEmail(String email);
//}

@Repository
public interface UserRepository extends CrudRepository<User,Long>
{
	public ArrayList<User> findAll();
	
	public User findByEmail(String email);
};