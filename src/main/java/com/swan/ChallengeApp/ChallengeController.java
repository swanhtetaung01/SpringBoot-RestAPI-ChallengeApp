package com.swan.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallengeByMonth(@PathVariable String month) {
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if (challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if (isChallengeAdded)
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
        else
            return new  ResponseEntity<>("Challenge could not be added", HttpStatus.BAD_REQUEST);
    }
}
