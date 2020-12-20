package com.lbruges.bowling.utils;

import com.lbruges.bowling.model.frame.Frame;
import com.lbruges.bowling.model.frame.Spare;
import com.lbruges.bowling.model.frame.Strike;
import com.lbruges.bowling.model.roll.FoulRoll;
import com.lbruges.bowling.model.roll.Roll;

import java.util.LinkedList;
import java.util.List;

public class TestUtils {

    public static List<Frame> generateAllZeroesFrames() {
        List<Frame> frameList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            frameList.add(new Frame(new Roll()));
        }
        return frameList;
    }

    public static List<Frame> generateAllFoulsFrames() {
        List<Frame> frameList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            frameList.add(new Frame(new FoulRoll(), new FoulRoll()));
        }
        return frameList;
    }

    public static List<Frame> generateAllStrikesFrames() {
        List<Frame> frameList = new LinkedList<>();
        try {
            for (int i = 0; i < 12; i++) {
                frameList.add(new Strike(new Roll(10)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frameList;
    }

    public static List<Frame> generateAllSameSparesFrames() {
        List<Frame> frameList = new LinkedList<>();
        try {
            for (int i = 0; i < 10; i++) {
                frameList.add(new Spare(new Roll(5), new Roll(5)));
            }
            frameList.add(new Frame(new Roll(5), new FoulRoll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frameList;
    }

}
