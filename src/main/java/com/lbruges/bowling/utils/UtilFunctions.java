package com.lbruges.bowling.utils;

import java.util.Collection;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * Simple string utilities.
 *
 * @author Laura Bruges
 */
public class UtilFunctions {

    private static final String TAB_FORMAT = "%s\t";

    public static String getValueWithTabFormat(String value) {
        return String.format(TAB_FORMAT, value);
    }

    public static String collectionToJoinedStr(Collection collection, String delimiter) {
        return (String) collection.stream().map(o -> o.toString()).collect(Collectors.joining(delimiter));
    }

    public static String generateFrameTitle(int frameNumber) {
        StringJoiner joiner = new StringJoiner("\t\t");
        for (int i = 1; i <= frameNumber; i++) {
            joiner.add(String.valueOf(i));
        }

        return String.format("Frame\t\t%s", joiner.toString());
    }

}
