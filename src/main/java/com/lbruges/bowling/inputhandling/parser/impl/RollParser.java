package com.lbruges.bowling.inputhandling.parser.impl;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.exception.ExceptionEnum;
import com.lbruges.bowling.inputhandling.factory.RollFactory;
import com.lbruges.bowling.inputhandling.parser.IParser;
import com.lbruges.bowling.model.roll.IRoll;

import java.util.LinkedList;
import java.util.List;

/**
 * String roll list to IRoll list parser.
 *
 * @author Laura Bruges
 */
public class RollParser implements IParser<List<String>, List<IRoll>> {

    private static final RollFactory ROLL_FACTORY = new RollFactory();

    public List<IRoll> parseTo(List<String> strRolls) throws ApplicationException {
        if (strRolls.size() < 12 || strRolls.size() > 20) {
            throw new ApplicationException(ExceptionEnum.INVALID_ROLL_COUNT);
        }

        List<IRoll> rolls = new LinkedList<>();

        for (String strRoll : strRolls) {
            rolls.add(ROLL_FACTORY.getRoll(strRoll));
        }

        return rolls;
    }

}
