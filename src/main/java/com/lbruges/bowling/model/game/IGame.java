package com.lbruges.bowling.model.game;

import com.lbruges.bowling.board.BoardSubject;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;

import java.util.List;

public interface IGame extends BoardSubject {

    String getPlayerName();
    List<IFrame> getFrameList();
    List<IScore> getScoreList();

}
