package com.lbruges.bowling.board;

/**
 * Observable board subject interface.
 *
 * @author Laura Bruges
 */
public interface BoardSubject {

    /**
     * Allows to register a new observer.
     * @param observer observer object
     */
    void registerObserver(BoardObserver observer);

    /**
     * Notifies changes to all observers.
     */
    void notifyObservers();

}
