package com.lbruges.bowling.model.roll;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.utils.Constants;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Roll implements IRoll {

    private int knockedPins;

    public Roll(String rolRep) throws ApplicationException {
        try {
            knockedPins = Integer.valueOf(rolRep);
            if (knockedPins < 0) {
                throw new ApplicationException(ExceptionEnum.NEGATIVE_ROLL_VALUE);
            }

            if (knockedPins > 10) {
                throw new ApplicationException(ExceptionEnum.GREATER_ROLL_VALUE);
            }
        } catch (Exception e) {
            throw new ApplicationException(ExceptionEnum.BAD_ROLL_VALUE, e);
        }
    }

    @Override
    public int getKnockedPins() {
        return knockedPins;
    }

    public String toString() {
        String knockedPinsStr = String.valueOf(knockedPins);

        return knockedPinsStr + Constants.ROLL_BASE_BLANK_SPACE.substring(knockedPinsStr.length());
    }

}
