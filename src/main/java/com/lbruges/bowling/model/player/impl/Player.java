package com.lbruges.bowling.model.player.impl;

import com.lbruges.bowling.board.BoardObserver;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.player.IPlayer;
import com.lbruges.bowling.model.score.IScore;
import lombok.Data;

import java.util.List;

@Data
public class Player implements IPlayer {

    private String name;
    private List<IFrame> frameList;
    private List<IScore> scoreList;
    private List<BoardObserver> observers;

    public Player(String name) {
        this.name = name;
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
            o.update(name, frameList, scoreList);
        }
    }
}
