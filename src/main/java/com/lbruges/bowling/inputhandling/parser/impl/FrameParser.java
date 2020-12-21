package com.lbruges.bowling.inputhandling.parser.impl;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.inputhandling.factory.FrameFactory;
import com.lbruges.bowling.inputhandling.parser.IParser;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.roll.IRoll;

import java.util.LinkedList;
import java.util.List;

import static com.lbruges.bowling.model.frame.FrameType.*;

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
            if (STRIKE.equals(frame.getFrameType())) {
                i++;
            } else {
                i += 2;
            }
            frames.add(frame);
        }

        IFrame lastRegularFrame = frames.get(9);
        if ((STRIKE.equals(lastRegularFrame.getFrameType()) && (frames.size() < 11) || frames.size() > 12) ||
                (SPARE.equals(lastRegularFrame.getFrameType()) && frames.size() != 11) ||
                (REGULAR.equals(lastRegularFrame.getFrameType()) && frames.size() > 10)) {
                throw new ApplicationException(ExceptionEnum.INVALID_FRAME_COUNT);
        }

        return frames;
    }

}
