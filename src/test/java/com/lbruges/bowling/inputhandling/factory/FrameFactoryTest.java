package com.lbruges.bowling.inputhandling.factory;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.frame.impl.Regular;
import com.lbruges.bowling.model.frame.impl.Spare;
import com.lbruges.bowling.model.frame.impl.Strike;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.utils.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FrameFactoryTest {

    private FrameFactory frameFactory = new FrameFactory();
    private List<IRoll> baseRollList = TestUtils.getJeffRollList();

    @Test
    public void getFrame_strike() throws ApplicationException {
        IFrame frame = frameFactory.getFrame(baseRollList, 0);
        Assertions.assertTrue(frame instanceof Strike);
        Assertions.assertEquals(10, frame.getTotalKnockedPins());
        Assertions.assertEquals(10, frame.getFirstRollKnockedPins());
    }

    @Test
    public void getFrame_spare() throws ApplicationException {
        IFrame frame = frameFactory.getFrame(baseRollList, 1);
        Assertions.assertTrue(frame instanceof Spare);
        Assertions.assertEquals(10, frame.getTotalKnockedPins());
        Assertions.assertEquals(7, frame.getFirstRollKnockedPins());
    }

    @Test
    public void getFrame_regularFrame() throws ApplicationException {
        IFrame frame = frameFactory.getFrame(baseRollList, 3);
        Assertions.assertTrue(frame instanceof Regular);
        Assertions.assertEquals(9, frame.getTotalKnockedPins());
        Assertions.assertEquals(9, frame.getFirstRollKnockedPins());
    }

    @Test
    public void getFrame_invalidFrame() {
        Assertions.assertThrows(ApplicationException.class, () -> frameFactory.getFrame(baseRollList, 2));
    }

}
