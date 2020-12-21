package com.lbruges.bowling.calculator;

import com.lbruges.bowling.model.score.IScore;
import com.lbruges.bowling.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameScoreCalculatorTest {

    @Test
    public void scoreGame_allFramesAreZero() {
        GameScoreCalculator gameCalculator = new GameScoreCalculator(TestUtils.generateAllZeroesFrames());
        List<IScore> result = gameCalculator.scoreGame();
        Assertions.assertEquals(0, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_allFramesAreFouls() {
        GameScoreCalculator gameCalculator = new GameScoreCalculator(TestUtils.generateAllFoulsFrames());
        List<IScore> result = gameCalculator.scoreGame();
        Assertions.assertEquals(0, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_allFramesAreStrikes() {
        GameScoreCalculator gameCalculator = new GameScoreCalculator(TestUtils.generateAllStrikesFrames());
        List<IScore> result = gameCalculator.scoreGame();
        Assertions.assertEquals(300, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_allFramesAreSameSpares() {
        // All frames are 5 + 5 spares
        GameScoreCalculator gameCalculator = new GameScoreCalculator(TestUtils.generateAllSameSparesFrames());
        List<IScore> result = gameCalculator.scoreGame();
        Assertions.assertEquals(150, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_testJeffGame() {
        GameScoreCalculator gameCalculator = new GameScoreCalculator(TestUtils.getJeffGameFrames());
        List<IScore> result = gameCalculator.scoreGame();
        Assertions.assertEquals(167, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

    @Test
    public void scoreGame_testJohnGame() {
        GameScoreCalculator gameCalculator = new GameScoreCalculator(TestUtils.getJohnGameFrames());
        List<IScore> result = gameCalculator.scoreGame();
        Assertions.assertEquals(151, result.get(result.size() - 1).getScore());
        Assertions.assertEquals(10, result.size());
    }

}
