package com.javagroup.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javagroup.bean.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {
	List<Match> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2,Pageable pageable);
	default List<Match> findLatestMatchesByTeam(String team,int count){
		return getByTeam1OrTeam2OrderByDateDesc(team,team,PageRequest.of(0, count));
	}
}
