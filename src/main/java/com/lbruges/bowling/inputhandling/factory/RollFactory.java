package com.lbruges.bowling.inputhandling.factory;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.model.roll.impl.Foul;
import com.lbruges.bowling.model.roll.impl.Roll;

import static com.lbruges.bowling.utils.Constants.FOUL_REP;

/**
 * Roll factory.
 *
 * @author Laura Bruges
 */
public class RollFactory {

    /**
     * Transform and validates a string roll representation into a roll object.
     * @param strRoll string roll representation
     * @return Roll object list
     * @throws ApplicationException in case any input validation fails
     */
    public IRoll getRoll(String strRoll) throws ApplicationException {
        if (FOUL_REP.equalsIgnoreCase(strRoll)) {
            return new Foul();
        }
        try {
            int rollValue = Integer.valueOf(strRoll);

            if (rollValue < 0) {
                throw new ApplicationException(ExceptionEnum.NEGATIVE_ROLL_VALUE);
            }

            if (rollValue > 10) {
                throw new ApplicationException(ExceptionEnum.GREATER_ROLL_VALUE);
            }

            return new Roll(rollValue);
        } catch (Exception e) {
            throw new ApplicationException(ExceptionEnum.BAD_ROLL_VALUE, e);
        }
    }

}
