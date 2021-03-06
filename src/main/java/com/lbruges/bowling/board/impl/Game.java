package com.lbruges.bowling.board.impl;

import com.lbruges.bowling.board.BoardObserver;
import com.lbruges.bowling.board.BoardSubject;
import com.lbruges.bowling.calculator.GameScoreCalculator;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;

import java.util.LinkedList;
import java.util.List;

/**
 * Single player bowling game representation.
 *
 * @author Laura Bruges
 */
public class Game implements BoardSubject {

    private String playerName;
    private List<IFrame> frameList;
    private List<BoardObserver> observers;

    public Game(String playerName, List<IFrame> frameList) {
        this.playerName = playerName;
        this.frameList = frameList;
        observers = new LinkedList<>();
    }

    public void setFrameList(List<IFrame> frameList) {
        this.frameList = frameList;
    }

    @Override
    public void registerObserver(BoardObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        List<IScore> scoreList = (new GameScoreCalculator(frameList)).scoreGame();
        for (BoardObserver o : observers) {
            o.update(playerName, frameList, scoreList);
        }
    }
}
