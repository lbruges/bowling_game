package com.lbruges.bowling.board;

import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;

import java.util.List;

public interface BoardObserver {

    void update(String playerName, List<IFrame> frameList, List<IScore> scoreList);
    void display();

}
