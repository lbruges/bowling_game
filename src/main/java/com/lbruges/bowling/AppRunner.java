package com.lbruges.bowling;


import com.lbruges.bowling.controller.BowlingGame;
import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.utils.Constants;
import com.lbruges.bowling.inputhandling.FrameFileReader;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class AppRunner {

    public static void main(String[] args) throws ApplicationException {
        String filename = Constants.DEFAULT_FILENAME;
        if (args.length > 0 && StringUtils.isNoneEmpty(args[0])) {
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
