package com.exp.exptracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.JpaRepositoryConfigExtension;
import org.springframework.stereotype.Repository;

import com.exp.exptracker.model.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, Integer> {

	List<UserDetails> findById(int userid);

	}
