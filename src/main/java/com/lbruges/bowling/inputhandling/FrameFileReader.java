package com.lbruges.bowling.inputhandling;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.inputhandling.parser.impl.StringToFrameParser;
import com.lbruges.bowling.model.frame.IFrame;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Class for handling file reading and frame conversion.
 *
 * @author Laura Bruges
 */
public class FrameFileReader {

    private static final StringToFrameParser STRING_TO_FRAME_PARSER = new StringToFrameParser();

    /**
     * Reads a text file and converts the line stream to a player frames map.
     * @param inputFilename file name
     * @return a map holding the game frames per player
     * @throws ApplicationException thrown in case any input validation fails
     */
    public static Map<String, List<IFrame>> getPlayerFrameMap(String inputFilename) throws ApplicationException {
        Map<String, List<IFrame>> frameMap;
        try (Stream<String> lines = Files.lines(Paths.get(inputFilename))) {
            Map<String, List<String>> strRollsPerPlayer = new LinkedHashMap<>();
            lines.filter(l -> StringUtils.isNoneBlank(l))
                    .map(l -> l.split("\t"))
                    .forEach(sL -> addToRollsMap(strRollsPerPlayer, sL));

            frameMap = STRING_TO_FRAME_PARSER.parseTo(strRollsPerPlayer);
        } catch (ApplicationException ae) {
            throw ae;
        } catch (Exception e) {
            throw new ApplicationException(ExceptionEnum.IO_ERROR, e);
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
