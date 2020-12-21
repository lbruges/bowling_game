package com.lbruges.bowling.model.frame.impl;

import com.lbruges.bowling.model.frame.AbstractFrame;
import com.lbruges.bowling.model.frame.FrameType;
import com.lbruges.bowling.model.roll.IRoll;

import static com.lbruges.bowling.utils.UtilFunctions.getValueWithTabFormat;

/**
 * Spare frame representation (all 10 pins knocked down on the two allowed rolls).
 *
 * @author Laura Bruges
 */
public class Spare extends AbstractFrame {

    public Spare(IRoll firstRoll, IRoll secondRoll) {
        super(firstRoll, secondRoll);
    }

    @Override
    public FrameType getFrameType() {
        return FrameType.SPARE;
    }

    public String toString() {
        return getValueWithTabFormat(firstRoll.toString()) + "/";
    }

}
