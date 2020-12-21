package com.lbruges.bowling.inputhandling;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.model.frame.IFrame;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Class for handling file reading and frame conversion.
 *
 * @author Laura Bruges
 */
public class FrameFileReader {

    /**
     * Reads a text file and converts the line stream to a player frames map.
     * @param inputFilename file name
     * @return a map holding the game frames per player
     * @throws ApplicationException thrown in case any input validation fails
     */
    public static Map<String, List<IFrame>> getPlayerFrameMap(String inputFilename) throws ApplicationException {
        Map<String, List<IFrame>> frameMap;
        try (Stream<String> lines = Files.lines(Paths.get(inputFilename))) {
            frameMap = InputHandler.streamToFrameMap(lines);
        } catch (ApplicationException ae) {
            throw ae;
        } catch (Exception e) {
            throw new ApplicationException(ExceptionEnum.IO_ERROR, e);
        }

        return frameMap;
    }
}
