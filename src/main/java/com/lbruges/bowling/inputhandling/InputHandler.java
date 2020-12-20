package com.lbruges.bowling.inputhandling;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.inputhandling.parser.FrameParser;
import com.lbruges.bowling.inputhandling.parser.RollParser;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.board.impl.Game;
import com.lbruges.bowling.model.roll.IRoll;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class InputHandler {

    private static final FrameParser FRAME_PARSER = new FrameParser();
    private static final RollParser ROLL_PARSER = new RollParser();

    public static Map<String, List<IFrame>> streamToFrameMap(Stream<String> lines) throws ApplicationException {
        List<Game> games = new LinkedList<>();

        Map<String, List<String>> strRollsPerPlayer = new LinkedHashMap<>();
        lines.filter(l -> StringUtils.isNoneBlank(l))
                .map(l -> l.split("\t"))
                .forEach(sL -> addToRollsMap(strRollsPerPlayer, sL));

        Map<String, List<IFrame>> frameMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : strRollsPerPlayer.entrySet()) {
            List<IRoll> rolls = ROLL_PARSER.parseTo(entry.getValue());
            List<IFrame> frames = FRAME_PARSER.parseTo(rolls);
            frameMap.put(entry.getKey(), frames);
        }

        return frameMap;
    }

    private static void addToRollsMap(Map<String, List<String>> rollsPerPlayer, String[] splitLine) {
        String playerName = splitLine[0].trim();
        String roll = splitLine[1].trim();

        if (!rollsPerPlayer.containsKey(playerName)) {
            rollsPerPlayer.put(playerName, new LinkedList<>());
        }

        rollsPerPlayer.get(playerName).add(roll);
    }

}
