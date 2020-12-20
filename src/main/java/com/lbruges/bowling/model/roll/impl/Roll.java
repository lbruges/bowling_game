package com.lbruges.bowling.model.roll.impl;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.utils.Constants;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Roll implements IRoll {

    private int knockedPins;

    public Roll(int knockedPins) throws ApplicationException {
        if (knockedPins < 0) {
            throw new ApplicationException(ExceptionEnum.NEGATIVE_ROLL_VALUE);
        }

        if (knockedPins > 10) {
            throw new ApplicationException(ExceptionEnum.GREATER_ROLL_VALUE);
        }
        this.knockedPins = knockedPins;
    }

    @Override
    public int getKnockedPins() {
        return knockedPins;
    }

    @Override
    public String toString() {
        String knockedPinsStr = String.valueOf(knockedPins);

        return Constants.getValueWithTabFormat(knockedPinsStr);
    }

}