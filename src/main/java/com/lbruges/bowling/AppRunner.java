package com.lbruges.bowling;


import com.lbruges.bowling.controller.BowlingGame;
import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.utils.FrameFileReader;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class AppRunner {

    private static final BowlingGame BOWLING_GAME = new BowlingGame();

    public static void main(String[] args) throws ApplicationException {
        String filename = "bowling_game.txt";
        if (args.length > 0 && StringUtils.isNoneEmpty(filename)) {
            filename = args[0];
        }

        Map<String, List<IFrame>> frameMap = FrameFileReader.getPlayerFrameMap(filename);
        BowlingGame bowlingGame = new BowlingGame();
        for (Map.Entry<String, List<IFrame>> entry : frameMap.entrySet()) {
            bowlingGame.registerPlayerGame(entry.getKey(), entry.getValue());
        }

        bowlingGame.displayGameScores();
    }

}
