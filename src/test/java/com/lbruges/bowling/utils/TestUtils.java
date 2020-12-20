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
            for (int i = 0; i < 11; i++) {
                frameList.add(new Spare(new Roll(5), new Roll(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frameList;
    }

    public static List<Frame> getJeffGameFrames() {
        List<Frame> frameList = new LinkedList<>();
        try {
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Spare(new Roll(7), new Roll(3)));
            frameList.add(new Frame(new Roll(9), new Roll(0)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Frame(new Roll(0), new Roll(8)));
            frameList.add(new Spare(new Roll(8), new Roll(2)));
            frameList.add(new Frame(new FoulRoll(), new Roll(6)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Frame(new Roll(8), new Roll(1)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frameList;
    }

    public static List<Frame> getJohnGameFrames() {
        List<Frame> frameList = new LinkedList<>();
        try {
            frameList.add(new Spare(new Roll(3), new Roll(7)));
            frameList.add(new Frame(new Roll(6), new Roll(3)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Frame(new Roll(8), new Roll(1)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Frame(new Roll(9), new Roll(0)));
            frameList.add(new Spare(new Roll(7), new Roll(3)));
            frameList.add(new Frame(new Roll(4), new Roll(4)));
            frameList.add(new Strike(new Roll(10)));
            frameList.add(new Frame(new Roll(9), new Roll(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frameList;
    }

}
