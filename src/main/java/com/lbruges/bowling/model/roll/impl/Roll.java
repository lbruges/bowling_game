package com.lbruges.bowling.model.roll.impl;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.model.roll.IRoll;
import lombok.NoArgsConstructor;

import static com.lbruges.bowling.utils.UtilFunctions.getValueWithTabFormat;

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
        return String.valueOf(knockedPins);
    }

}
