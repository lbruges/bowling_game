package com.lbruges.bowling.utils;

public class Constants {

    public static final int REGULAR_GAME_FRAMES = 10;
    public static final String FOUL_REP = "F";
    private static final String TAB_FORMAT = "%s\t";

    public static String getValueWithTabFormat(String value) {
        return String.format(TAB_FORMAT, value);
    }

}
