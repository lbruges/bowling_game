package com.lbruges.bowling.model.player;

import com.lbruges.bowling.board.BoardSubject;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;

import java.util.List;

public interface IPlayer extends BoardSubject {

    String getName();
    List<IFrame> getFrameList();
    List<IScore> getScoreList();

}
