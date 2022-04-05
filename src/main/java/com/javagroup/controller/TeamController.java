package com.javagroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.javagroup.bean.Match;
import com.javagroup.bean.Team;
import com.javagroup.repository.MatchRepository;
import com.javagroup.repository.TeamRepository;

@RestController
public class TeamController {

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private MatchRepository matchRepository;

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName) {
		Team team = teamRepository.findByTeamName(teamName);
		List<Match> list = matchRepository.findLatestMatchesByTeam(teamName, 4);
		team.setMatches(list);
		return team;
	}

}
