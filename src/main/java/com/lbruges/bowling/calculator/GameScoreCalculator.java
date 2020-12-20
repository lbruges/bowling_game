package com.lbruges.bowling.calculator;

import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;
import com.lbruges.bowling.model.score.impl.FrameScore;
import com.lbruges.bowling.utils.Constants;
import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

import static com.lbruges.bowling.model.frame.FrameType.STRIKE;

@AllArgsConstructor
public class GameScoreCalculator {

    private List<IFrame> frames;

    public List<IScore> scoreGame() {
        List<IScore> scores = new LinkedList<>();
        int score = 0;
        for (int i = 0; i < Constants.MAX_GAME_FRAMES; i++) {
            switch (frames.get(i).getFrameType()) {
                case STRIKE:
                    score += frames.get(i).getTotalKnockedPins() + getStrikeBonus(i);
                    break;
                case SPARE:
                    score += frames.get(i).getTotalKnockedPins() + getSpareBonus(i);
                    break;
                default:
                    score += frames.get(i).getTotalKnockedPins();
            }
            scores.add(new FrameScore(score));
        }
        return scores;
    }

    private int getSpareBonus(int i) {
        return frames.get(i+1).getFirstRollKnockedPins();
    }

    private int getStrikeBonus(int i) {
        int bonus = frames.get(i+1).getTotalKnockedPins();
        if (STRIKE.equals(frames.get(i+1).getFrameType())) {
            bonus += frames.get(i+2).getFirstRollKnockedPins();
        }

        return bonus;
    }

}
