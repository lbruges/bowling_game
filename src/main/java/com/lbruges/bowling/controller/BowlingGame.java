package com.lbruges.bowling.controller;

import com.lbruges.bowling.board.impl.PlayerGameBoard;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.board.impl.Game;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * Handles all players bowling games.
 *
 * @author Laura Bruges
 */
@Setter
public class BowlingGame {

    private List<Game> playerGames;

    public BowlingGame() {
        playerGames = new LinkedList<>();
    }

    /**
     * Creates and adds a player game to all player games collection.
     * @param playerName player name
     * @param gameFrames player game frames
     */
    public void registerPlayerGame(String playerName, List<IFrame> gameFrames) {
        Game game = new Game(playerName, gameFrames);
        game.registerObserver(new PlayerGameBoard());

        playerGames.add(game);
    }

    /**
     * Displays bowling game boards for all the registered players.
     */
    public void displayGameScores() {
        for (Game game: playerGames) {
            game.notifyObservers();
        }
    }

}
