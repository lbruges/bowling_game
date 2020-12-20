package com.lbruges.bowling.inputhandling.parser;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.inputhandling.factory.RollFactory;
import com.lbruges.bowling.model.roll.IRoll;

import java.util.LinkedList;
import java.util.List;

public class RollParser {

    private static final RollFactory ROLL_FACTORY = new RollFactory();

    public List<IRoll> parseTo(List<String> strRolls) throws ApplicationException {
        List<IRoll> rolls = new LinkedList<>();

        for (String strRoll : strRolls) {
            rolls.add(ROLL_FACTORY.getRoll(strRoll));
        }

        return rolls;
    }

}
