package com.lbruges.bowling.game;

import com.lbruges.bowling.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    @Test
    public void scoreGame_allFramesAreZero() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllZeroesFrames());
        Assertions.assertEquals(0, bowlingGame.scoreGame());
    }

    @Test
    public void scoreGame_allFramesAreFouls() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllFoulsFrames());
        Assertions.assertEquals(0, bowlingGame.scoreGame());
    }

    @Test
    public void scoreGame_allFramesAreStrikes() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllStrikesFrames());
        Assertions.assertEquals(300, bowlingGame.scoreGame());
    }

    @Test
    public void scoreGame_allFramesAreSameSpares() {
        // All frames are 5 + 5 spares
        BowlingGame bowlingGame = new BowlingGame(TestUtils.generateAllSameSparesFrames());
        Assertions.assertEquals(150, bowlingGame.scoreGame());
    }

    @Test
    public void scoreGame_testJeffGame() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.getJeffGameFrames());
        Assertions.assertEquals(167, bowlingGame.scoreGame());
    }

    @Test
    public void scoreGame_testJohnGame() {
        BowlingGame bowlingGame = new BowlingGame(TestUtils.getJohnGameFrames());
        Assertions.assertEquals(151, bowlingGame.scoreGame());
    }

}
