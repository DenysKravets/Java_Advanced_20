package ua.lviv.lgs.repositories;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUserName(String userName);
	
}
