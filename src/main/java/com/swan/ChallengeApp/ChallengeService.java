package com.swan.ChallengeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;

    public ChallengeService() {

    }

    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    public Challenge getChallengeByMonth(String month) {
        for (Challenge challenge : challenges) {
            if (challenge.getMonth().equalsIgnoreCase(month))
                return challenge;
        }
        return null;
    }

    public Challenge getChallengeById(Long id) {
        for (Challenge challenge : challenges) {
            if (challenge.getId().equals(id))
                return challenge;
        }
        return null;
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        else {
            return false;
        }
    }
}
