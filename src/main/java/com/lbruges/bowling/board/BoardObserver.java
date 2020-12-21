package com.lbruges.bowling.board;

import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;

import java.util.List;

/**
 * Board observer interface.
 *
 * @author Laura Bruges
 */
public interface BoardObserver {

    /**
     * Represents an update notification.
     * @param playerName player name
     * @param frameList frame list
     * @param scoreList score list
     */
    void update(String playerName, List<IFrame> frameList, List<IScore> scoreList);

    /**
     * Prints the player game board
     */
    void display();

}
