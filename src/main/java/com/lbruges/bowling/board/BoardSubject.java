package com.lbruges.bowling.board;

public interface BoardSubject {

    void registerObserver(BoardObserver observer);
    void unregisterObserver(BoardObserver observer);
    void notifyObservers();

}
