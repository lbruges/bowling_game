package com.lbruges.bowling.board.impl;

import com.lbruges.bowling.board.BoardObserver;
import com.lbruges.bowling.board.BoardSubject;
import com.lbruges.bowling.calculator.GameScoreCalculator;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;

import java.util.LinkedList;
import java.util.List;

public class Game implements BoardSubject {

    private String playerName;
    private List<IFrame> frameList;
    private List<IScore> scoreList;
    private List<BoardObserver> observers;

    public Game(String playerName) {
        this.playerName = playerName;
        observers = new LinkedList<>();
    }

    public void setFrameList(List<IFrame> frameList) {
        this.frameList = frameList;
        GameScoreCalculator scoreCalculator = new GameScoreCalculator(frameList);
        setScoreList(scoreCalculator.scoreGame());
    }

    private void setScoreList(List<IScore> scoreList) {
        this.scoreList = scoreList;
    }

    @Override
    public void registerObserver(BoardObserver observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (BoardObserver o : observers) {
            o.update(playerName, frameList, scoreList);
        }
    }
}
