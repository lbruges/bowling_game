package com.lbruges.bowling.model.frame.impl;

import com.lbruges.bowling.model.frame.AbstractFrame;
import com.lbruges.bowling.model.frame.FrameType;
import com.lbruges.bowling.model.roll.IRoll;

public class Strike extends AbstractFrame {

    public Strike(IRoll firstRoll) {
        super(firstRoll);
    }

    @Override
    public FrameType getFrameType() {
        return FrameType.STRIKE;
    }

}
