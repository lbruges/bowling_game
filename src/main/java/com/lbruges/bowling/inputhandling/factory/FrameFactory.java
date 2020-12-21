package com.lbruges.bowling.inputhandling.factory;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.frame.impl.Regular;
import com.lbruges.bowling.model.frame.impl.Spare;
import com.lbruges.bowling.model.frame.impl.Strike;
import com.lbruges.bowling.model.roll.IRoll;

import java.util.List;

public class FrameFactory {

    public IFrame getFrame(List<IRoll> rolls, int i) throws ApplicationException {
        IRoll firstRoll = rolls.get(i);

        if (firstRoll.getKnockedPins() == 10) {
            return new Strike(firstRoll);
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
