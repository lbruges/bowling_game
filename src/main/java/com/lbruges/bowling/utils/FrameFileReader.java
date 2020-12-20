package com.lbruges.bowling.utils;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.inputhandling.InputHandler;
import com.lbruges.bowling.model.frame.IFrame;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FrameFileReader {

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
