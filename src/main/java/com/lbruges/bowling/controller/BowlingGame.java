package com.lbruges.bowling.controller;

import com.lbruges.bowling.board.impl.PlayerGameBoard;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.game.impl.Game;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Setter
public class BowlingGame {

    private List<Game> playerGames;

    public BowlingGame() {
        playerGames = new LinkedList<>();
    }

    public void registerPlayerGame(String playerName, List<IFrame> gameFrames) {
        Game game = new Game(playerName);
        game.setFrameList(gameFrames);

        GameScoreCalculator calculator = new GameScoreCalculator(gameFrames);
        game.setScoreList(calculator.scoreGame());

        game.registerObserver(new PlayerGameBoard());

        playerGames.add(game);
    }

    public void displayGameScores() {
        for (Game game: playerGames) {
            game.notifyObservers();
        }
    }

}
