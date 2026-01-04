package com.swan.ChallengeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeService.addChallenge(challenge);
        if (isChallengeAdded)
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
        else
            return new  ResponseEntity<>("Challenge could not be added", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenges() {
        return new ResponseEntity<>(challengeService.getAllChallenges(), HttpStatus.OK);
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallengeByMonth(@PathVariable String month) {
        Challenge challenge = challengeService.getChallengeByMonth(month);
        if (challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge) {
        boolean isChallengeUpdated = challengeService.updateChallenge(id, updatedChallenge);
        if (isChallengeUpdated)
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        else
            return new  ResponseEntity<>("Challenge could not be updated", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id) {
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);
        if (isChallengeDeleted)
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        else
            return new  ResponseEntity<>("Challenge could not be deleted", HttpStatus.BAD_REQUEST);
    }

    //    @GetMapping("/{id}")
//    public Challenge getChallengeById(@PathVariable Long id) {
//        Challenge challenge = challengeService.getChallengeById(id);
//        if (challenge != null)
//            return challenge;
//        else
//            return null;
//    }
}
