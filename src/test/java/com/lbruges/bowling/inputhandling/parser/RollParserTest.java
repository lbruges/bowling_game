package com.lbruges.bowling.inputhandling.parser;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.inputhandling.parser.impl.RollParser;
import com.lbruges.bowling.model.roll.IRoll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RollParserTest {

    private RollParser rollParser = new RollParser();

    @Test
    public void parseTo_emptyList() {
        Assertions.assertThrows(ApplicationException.class, () -> rollParser.parseTo(Arrays.asList()));
    }

    @Test
    public void parseTo_lowerRollCount() {
        List<String> test = Arrays.asList("10","10","10","10","10","10","10","10","10","10","10");
        Assertions.assertThrows(ApplicationException.class, () -> rollParser.parseTo(test));
    }

    @Test
    public void parseTo_greaterRollCount() {
        List<String> test = Arrays.asList("0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0");
        Assertions.assertThrows(ApplicationException.class, () -> rollParser.parseTo(test));
    }

    @Test
    public void parseTo_validParsing() throws ApplicationException {
        List<String> test = Arrays.asList("10","7","3","9","0","10","0","8","8","2","F","6","10","10","10","8","1");
        List<IRoll> rolls = rollParser.parseTo(test);
        Assertions.assertEquals(test.size(), rolls.size());
    }

}
