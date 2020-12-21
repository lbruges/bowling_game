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

    /**
     * Single perfect game.
     * @throws ApplicationException
     */
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
     * Tests a single player zeroes game.
     * @throws ApplicationException
     */
    @Test
    public void singlePlayerValidAllZeroesGame() throws ApplicationException {
        AppRunner.main(new String[]{String.format(TEST_FILES_FORMAT, "single_player_zeroes")});
    }

    /**
     * Tests Jeff's game with last regular play set to Spare.
     * @throws ApplicationException
     */
    @Test
    public void singlePlayerLastSpare() throws ApplicationException {
        AppRunner.main(new String[]{String.format(TEST_FILES_FORMAT, "jeff_game_last_spare")});
    }

}
