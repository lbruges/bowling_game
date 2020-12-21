package com.lbruges.bowling.inputhandling.parser.impl;

import com.lbruges.bowling.exception.ApplicationException;
import com.lbruges.bowling.inputhandling.parser.IParser;
import com.lbruges.bowling.inputhandling.parser.impl.FrameParser;
import com.lbruges.bowling.inputhandling.parser.impl.RollParser;
import com.lbruges.bowling.model.frame.IFrame;
import com.lbruges.bowling.model.roll.IRoll;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Handles the conversion from the text file lines to a bowling frame list per player using roll lists as a basis.
 *
 * @author Laura Bruges
 */
public class StringToFrameParser implements IParser<Map<String, List<String>>, Map<String, List<IFrame>>> {

    private static final FrameParser FRAME_PARSER = new FrameParser();
    private static final RollParser ROLL_PARSER = new RollParser();

    @Override
    public Map<String, List<IFrame>> parseTo(Map<String, List<String>> strRollsPerPlayer) throws ApplicationException {
        Map<String, List<IFrame>> frameMap = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : strRollsPerPlayer.entrySet()) {
            List<IRoll> rolls = ROLL_PARSER.parseTo(entry.getValue());
            List<IFrame> frames = FRAME_PARSER.parseTo(rolls);
            frameMap.put(entry.getKey(), frames);
        }

        return frameMap;
    }
}
