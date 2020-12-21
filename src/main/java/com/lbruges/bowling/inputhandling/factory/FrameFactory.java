package com.lbruges.bowling.inputhandling.factory;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.frame.impl.Regular;
import com.lbruges.bowling.model.frame.impl.Spare;
import com.lbruges.bowling.model.frame.impl.Strike;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.model.roll.impl.Dummy;

import java.util.List;

/**
 * Frame factory.
 *
 * @author Laura Bruges
 */
public class FrameFactory {

    /**
     * Creates a frame based on knocked down pins per single roll or roll pair.
     * @param rolls roll list
     * @param i current roll index
     * @return a frame list
     * @throws ApplicationException in case any input validation fails
     */
    public IFrame getFrame(List<IRoll> rolls, int i) throws ApplicationException {
        IRoll firstRoll = rolls.get(i);

        if (firstRoll.getKnockedPins() == 10) {
            return new Strike(firstRoll);
        }

        // Taking into account a last regular spare as possible scenario
        if ((i + 1) == rolls.size()) {
            return new Regular(firstRoll, new Dummy());
        }

        IRoll secondRoll = rolls.get(i + 1);

        int totalFrameValue = firstRoll.getKnockedPins() + secondRoll.getKnockedPins();
        if (totalFrameValue > 10) {
            throw new ApplicationException(ExceptionEnum.INVALID_FRAME_VALUE);
        }

        if (totalFrameValue == 10) {
            return new Spare(firstRoll, secondRoll);
        } else {
            return new Regular(firstRoll, secondRoll);
        }
    }

}
