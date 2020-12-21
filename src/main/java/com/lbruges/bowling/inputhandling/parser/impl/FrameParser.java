package com.lbruges.bowling.inputhandling.parser.impl;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.inputhandling.factory.FrameFactory;
import com.lbruges.bowling.inputhandling.parser.IParser;
import com.lbruges.bowling.model.frame.FrameType;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.roll.IRoll;

import java.util.LinkedList;
import java.util.List;

/**
 * Roll list to frame list parser.
 * @author Laura Bruges
 */
public class FrameParser implements IParser<List<IRoll>, List<IFrame>> {

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

        IFrame lastRegularFrame = frames.get(9);
        if (FrameType.STRIKE.equals(lastRegularFrame)) {
            if (frames.size() != 12) {
                throw new ApplicationException(ExceptionEnum.INVALID_FRAME_COUNT);
            }
        }
        if (FrameType.SPARE.equals(lastRegularFrame)) {
            if (frames.size() != 11) {
                throw new ApplicationException(ExceptionEnum.INVALID_FRAME_COUNT);
            }
        }

        return frames;
    }

}
