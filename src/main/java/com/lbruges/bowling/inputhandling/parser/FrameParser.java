package com.lbruges.bowling.inputhandling.parser;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.inputhandling.factory.FrameFactory;
import com.lbruges.bowling.model.frame.FrameType;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.roll.IRoll;

import java.util.LinkedList;
import java.util.List;

public class FrameParser {

    private static final FrameFactory FRAME_FACTORY = new FrameFactory();

    public List<IFrame> parseTo(List<IRoll> rolls) throws ApplicationException {
        int i = 0;

        List<IFrame> frames = new LinkedList<>();

        while (i < rolls.size()) {
            IFrame frame = FRAME_FACTORY.getFrame(rolls, i);
            if (FrameType.STRIKE.equals(frame.getFrameType())) {
                i++;
            } else {
                i += 2;
            }
            frames.add(frame);
        }

        return frames;
    }

}
