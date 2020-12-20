package com.lbruges.bowling.game;

import com.lbruges.bowling.model.score.IScore;
import com.lbruges.bowling.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BowlingGameTest {

    @Test
    public void scoreGame_allFramesAreZero() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllZeroesFrames());
        List<IScore> result = bowlingGame.scoreGame();
        Assertions.assertEquals(0, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_allFramesAreFouls() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllFoulsFrames());
        List<IScore> result = bowlingGame.scoreGame();
        Assertions.assertEquals(0, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_allFramesAreStrikes() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllStrikesFrames());
        List<IScore> result = bowlingGame.scoreGame();
        Assertions.assertEquals(300, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_allFramesAreSameSpares() {
        // All frames are 5 + 5 spares
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllSameSparesFrames());
        List<IScore> result = bowlingGame.scoreGame();
        Assertions.assertEquals(150, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_testJeffGame() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.getJeffGameFrames());
        List<IScore> result = bowlingGame.scoreGame();
        Assertions.assertEquals(167, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_testJohnGame() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.getJohnGameFrames());
        List<IScore> result = bowlingGame.scoreGame();
        Assertions.assertEquals(151, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

}
