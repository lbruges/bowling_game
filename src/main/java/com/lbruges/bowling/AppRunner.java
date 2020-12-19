package com.lbruges.bowling;


import com.lbruges.bowling.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class AppRunner {

    public static void main(String[] args) {
        String filename = "bowling_game.txt";
        if (args.length > 0 && StringUtils.isNoneEmpty(filename)) {
            filename = args[0];
        }

        FileUtils.readFile(filename);
    }

}
