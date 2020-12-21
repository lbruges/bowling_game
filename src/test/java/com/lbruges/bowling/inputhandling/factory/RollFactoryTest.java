package com.lbruges.bowling.inputhandling.factory;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.model.roll.impl.Foul;
import com.lbruges.bowling.model.roll.impl.Roll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RollFactoryTest {

    private RollFactory rollFactory = new RollFactory();

    @Test
    public void getRoll_foul() throws ApplicationException {
        IRoll roll = rollFactory.getRoll("F");
        Assertions.assertTrue(roll instanceof Foul);
        Assertions.assertEquals(0, roll.getKnockedPins());
        Assertions.assertEquals("F", roll.toString());
    }

    @Test
    public void getRoll_valid() throws ApplicationException {
        IRoll roll = rollFactory.getRoll("10");
        Assertions.assertTrue(roll instanceof Roll);
        Assertions.assertEquals(10, roll.getKnockedPins());
    }

    @Test
    public void getRoll_invalid_negative() {
        Assertions.assertThrows(ApplicationException.class, () -> rollFactory.getRoll("-10"));
    }

    @Test
    public void getRoll_invalid_greaterThan10() {
        Assertions.assertThrows(ApplicationException.class, () -> rollFactory.getRoll("11"));
    }

}
