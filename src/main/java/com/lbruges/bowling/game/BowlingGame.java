package com.lbruges.bowling.game;

import com.lbruges.bowling.model.frame.Frame;
import com.lbruges.bowling.utils.Constants;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BowlingGame {

    private List<Frame> frames;

    public int scoreGame() {
        int score = 0;
        for (int i = 0; i < Constants.REGULAR_GAME_FRAMES; i++) {
            if (frames.get(i).isStrike()) {
                score += frames.get(i).getTotalKnockedPins() + getStrikeBonus(i);
            } else if (frames.get(i).isSpare()) {
                score += frames.get(i).getTotalKnockedPins() + getSpareBonus(i);
            } else {
                score += frames.get(i).getTotalKnockedPins();
            }
        }
        return score;
    }

    private int getSpareBonus(int i) {
        return frames.get(i+1).getFirstRollKnockedPins();
    }

    private int getStrikeBonus(int i) {
        int bonus = frames.get(i+1).getTotalKnockedPins();
        if (frames.get(i+1).isStrike()) {
            bonus += frames.get(i+2).getFirstRollKnockedPins();
        }

        return bonus;
    }

}
