package com.javagroup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javagroup.bean.Team;

public interface TeamRepository extends JpaRepository<Team,Long>{
	Team findByTeamName(String teamName);
}
