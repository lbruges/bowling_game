package com.lbruges.bowling.board.impl;

import com.lbruges.bowling.board.BoardObserver;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.score.IScore;

import java.util.List;

import static com.lbruges.bowling.utils.Constants.MAX_GAME_FRAMES;
import static com.lbruges.bowling.utils.UtilFunctions.collectionToJoinedStr;
import static com.lbruges.bowling.utils.UtilFunctions.generateFrameTitle;

public class PlayerBoard implements BoardObserver {

    private static final String FRAME_TITLE_FORMAT = "Pinfalls\t%s";
    private static final String SCORE_TITLE_FORMAT = "Score\t\t%s";
    private String playerName;
    private List<IFrame> frameList;
    private List<IScore> scoreList;

    @Override
    public void update(String playerName, List<IFrame> frameList, List<IScore> scoreList) {
        this.playerName = playerName;
        this.frameList = frameList;
        this.scoreList = scoreList;
        display();
    }

    @Override
    public void display() {
        String frameTitle = generateFrameTitle(MAX_GAME_FRAMES);
        System.out.println(frameTitle);

        System.out.println(playerName);

        String framesToDisplay = String.format(FRAME_TITLE_FORMAT, collectionToJoinedStr(frameList, "\t"));
        System.out.println(framesToDisplay);

        String scoresToDisplay = String.format(SCORE_TITLE_FORMAT, collectionToJoinedStr(scoreList, "\t\t"));
        System.out.println(scoresToDisplay);
    }

}
