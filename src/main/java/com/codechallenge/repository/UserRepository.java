package com.codechallenge.repository;
import org.springframework.data.repository.CrudRepository;
import com.codechallenge.entity.User;

public interface UserRepository extends CrudRepository< User, Long> {

}


