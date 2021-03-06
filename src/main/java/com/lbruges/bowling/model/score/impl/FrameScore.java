package com.lbruges.bowling.model.score.impl;

import com.lbruges.bowling.model.score.IScore;
import lombok.AllArgsConstructor;

/**
 * Model to hold per frame score.
 *
 * @author Laura Bruges
 */
@AllArgsConstructor
public class FrameScore implements IScore {

    private int score;

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }

}
