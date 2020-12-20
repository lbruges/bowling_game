package com.lbruges.bowling.model.frame;

import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.model.roll.impl.Roll;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractFrame implements IFrame {

    protected IRoll firstRoll;
    protected IRoll secondRoll;

    public AbstractFrame(IRoll firstRoll) {
        this.firstRoll = firstRoll;
        secondRoll = new Roll();
    }

    @Override
    public int getTotalKnockedPins() {
        return firstRoll.getKnockedPins() + secondRoll.getKnockedPins();
    }

    @Override
    public int getFirstRollKnockedPins() {
        return firstRoll.getKnockedPins();
    }
}
