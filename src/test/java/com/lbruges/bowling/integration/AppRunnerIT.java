package com.lbruges.bowling.integration;

import com.lbruges.bowling.AppRunner;
import com.lbruges.bowling.exception.ApplicationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppRunnerIT {

    private static final String TEST_FILES_FORMAT = "src/test/resources/%s.txt";

    /**
     * Test with a non-existing file.
     */
    @Test
    public void testFileNotFound() {
        Assertions.assertThrows(ApplicationException.class, () -> {
            AppRunner.main(new String[]{String.format(TEST_FILES_FORMAT, "dhfkf")});
        });
    }

    /**
     * Same sample two player game.
     * @throws ApplicationException
     */
    @Test
    public void testTwoPlayersGame() throws ApplicationException {
        AppRunner.main(new String[]{String.format(TEST_FILES_FORMAT, "bowling_game")});
    }

    @Test
    public void testPerfectGame() throws ApplicationException {
        AppRunner.main(new String[]{String.format(TEST_FILES_FORMAT, "perfect_game")});
    }

    /**
     * Tests a single player foul game.
     * @throws ApplicationException
     */
    @Test
    public void singlePlayerValidAllFoulGame() throws ApplicationException {
        AppRunner.main(new String[]{String.format(TEST_FILES_FORMAT, "single_player_foul")});
    }

    /**
     * Includes two regular valid games + a perfect game + all zeroes game + all fouls game
     * @throws ApplicationException
     */
    @Test
    public void allValidBowlingGame() throws ApplicationException {
        AppRunner.main(new String[]{String.format(TEST_FILES_FORMAT, "complete_bowling_game")});
    }

}
