package com.swan.ChallengeApp;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    @GetMapping("/challenges/{month}")
    public Challenge getChallengeByMonth(@PathVariable String month) {
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if (challenge != null)
            return challenge;
        else
            return null;
    }
//    @GetMapping("/challenges/{id}")
//    public Challenge getChallengeById(@PathVariable Long id) {
//        Challenge challenge = challengeService.getChallengeById(id);
//        if (challenge != null)
//            return challenge;
//        else
//            return null;
//    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if (isChallengeAdded)
            return "Challenge added successfully";
        else
            return "Challenge could not be added";
    }
}
