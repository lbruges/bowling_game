package com.lbruges.bowling.utils;

import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.frame.impl.Regular;
import com.lbruges.bowling.model.frame.impl.Spare;
import com.lbruges.bowling.model.frame.impl.Strike;
import com.lbruges.bowling.model.roll.IRoll;
import com.lbruges.bowling.model.roll.impl.Foul;
import com.lbruges.bowling.model.roll.impl.Roll;

import java.util.LinkedList;
import java.util.List;

public class TestUtils {

    public static List<IFrame> generateAllZeroesFrames() {
        List<IFrame> frameList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            frameList.add(new Regular(new Roll(), new Roll()));
        }
        return frameList;
    }

    public static List<IFrame> generateAllFoulsFrames() {
        List<IFrame> frameList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            frameList.add(new Regular(new Foul(), new Foul()));
        }
        return frameList;
    }

    public static List<IFrame> generateAllStrikesFrames() {
        List<IFrame> frameList = new LinkedList<>();
        for (int i = 0; i < 12; i++) {
            frameList.add(new Strike(new Roll(10)));
        }
        return frameList;
    }

    public static List<IFrame> generateAllSameSparesFrames() {
        List<IFrame> frameList = new LinkedList<>();
        for (int i = 0; i < 11; i++) {
            frameList.add(new Spare(new Roll(5), new Roll(5)));
        }
        return frameList;
    }

    public static List<IFrame> getJeffGameFrames() {
        List<IFrame> frameList = new LinkedList<>();
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Spare(new Roll(7), new Roll(3)));
        frameList.add(new Regular(new Roll(9), new Roll(0)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Regular(new Roll(0), new Roll(8)));
        frameList.add(new Spare(new Roll(8), new Roll(2)));
        frameList.add(new Regular(new Foul(), new Roll(6)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Regular(new Roll(8), new Roll(1)));

        return frameList;
    }

    public static List<IFrame> getJohnGameFrames() {
        List<IFrame> frameList = new LinkedList<>();
        frameList.add(new Spare(new Roll(3), new Roll(7)));
        frameList.add(new Regular(new Roll(6), new Roll(3)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Regular(new Roll(8), new Roll(1)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Regular(new Roll(9), new Roll(0)));
        frameList.add(new Spare(new Roll(7), new Roll(3)));
        frameList.add(new Regular(new Roll(4), new Roll(4)));
        frameList.add(new Strike(new Roll(10)));
        frameList.add(new Regular(new Roll(9), new Roll(0)));

        return frameList;
    }

    public static List<IRoll> getJeffRollList() {
        List<IRoll> rolls = new LinkedList<>();
        rolls.add(new Roll(10));
        rolls.add(new Roll(7));
        rolls.add(new Roll(3));
        rolls.add(new Roll(9));
        rolls.add(new Roll(0));
        rolls.add(new Roll(10));
        rolls.add(new Roll(0));
        rolls.add(new Roll(0));
        rolls.add(new Roll(8));
        rolls.add(new Roll(2));
        rolls.add(new Foul());
        rolls.add(new Roll(6));
        rolls.add(new Roll(10));
        rolls.add(new Roll(10));
        rolls.add(new Roll(10));
        rolls.add(new Roll(8));
        rolls.add(new Roll(1));

        return rolls;
    }

}
