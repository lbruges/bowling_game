package com.lbruges.bowling.model.game.impl;

import com.lbruges.bowling.board.BoardObserver;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.game.IGame;
import com.lbruges.bowling.model.score.IScore;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Game implements IGame {

    private String playerName;
    private List<IFrame> frameList;
    private List<IScore> scoreList;
    private List<BoardObserver> observers;

    public Game(String playerName) {
        this.playerName = playerName;
        observers = new LinkedList<>();
    }

    @Override
    public void registerObserver(BoardObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(BoardObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (BoardObserver o : observers) {
            o.update(playerName, frameList, scoreList);
        }
    }
}
