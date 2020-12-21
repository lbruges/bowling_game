package com.lbruges.bowling.inputhandling.parser;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.inputhandling.parser.impl.FrameParser;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.model.roll.impl.Roll;
import com.lbruges.bowling.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FrameParserTest {

    private FrameParser frameParser = new FrameParser();
    private List<IRoll> baseRollList;

    @BeforeEach
    public void init() {
        baseRollList = TestUtils.getJeffRollList();
    }

    @Test
    public void parseTo_invalidFrameSize_lastStrike() {
        Assertions.assertThrows(ApplicationException.class, () -> frameParser.parseTo(baseRollList.subList(0, baseRollList.size() - 2)));
    }

    @Test
    public void parseTo_invalidFrameSize_lastSpare() {
        baseRollList.set(14, new Roll(7));
        baseRollList.set(15, new Roll(3));
        Assertions.assertThrows(ApplicationException.class, () -> frameParser.parseTo(baseRollList.subList(0, baseRollList.size() - 1)));
    }

}
