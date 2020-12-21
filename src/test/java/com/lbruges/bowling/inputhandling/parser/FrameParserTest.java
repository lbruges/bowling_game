package com.lbruges.bowling.inputhandling.parser;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.inputhandling.parser.impl.FrameParser;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.model.roll.impl.Roll;
import com.lbruges.bowling.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FrameParserTest {

    private FrameParser frameParser = new FrameParser();

    @Test
    public void parseTo_invalidFrameSize_lastStrike() {
        List<IRoll> baseRollList = TestUtils.getJeffRollList();
        Assertions.assertThrows(ApplicationException.class, () -> frameParser.parseTo(baseRollList.subList(0, baseRollList.size() - 2)));
    }

    @Test
    public void parseTo_invalidFrameSize_lastSpare() {
        List<IRoll> baseRollList = TestUtils.getJeffRollListLastSpare();
        Assertions.assertThrows(ApplicationException.class, () -> frameParser.parseTo(baseRollList.subList(0, baseRollList.size() - 1)));
    }

    @Test
    public void parseTo_invalidFrameSize_lastRegular() {
        List<IRoll> baseRollList = TestUtils.getJeffRollListLastRegular();
        baseRollList.add(new Roll(5));
        Assertions.assertThrows(ApplicationException.class, () -> frameParser.parseTo(baseRollList));
    }

    @Test
    public void parseTo_valid_lastStrike() throws ApplicationException {
        List<IRoll> baseRollList = TestUtils.getJeffRollList();
        List<IFrame> frames = frameParser.parseTo(baseRollList);
        Assertions.assertEquals(11, frames.size());
    }

    @Test
    public void parseTo_valid_lastSpare() throws ApplicationException {
        List<IRoll> baseRollList = TestUtils.getJeffRollListLastSpare();
        List<IFrame> frames = frameParser.parseTo(baseRollList);
        Assertions.assertEquals(11, frames.size());
    }

    @Test
    public void parseTo_valid_lastRegular() throws ApplicationException {
        List<IRoll> baseRollList = TestUtils.getJeffRollListLastRegular();
        List<IFrame> frames = frameParser.parseTo(baseRollList);
        Assertions.assertEquals(10, frames.size());
    }

    @Test
    public void parseTo_valid_perfectGame() throws ApplicationException {
        List<IFrame> frames = frameParser.parseTo(TestUtils.getPerfectGameRollList());
        Assertions.assertEquals(12, frames.size());
    }

}
