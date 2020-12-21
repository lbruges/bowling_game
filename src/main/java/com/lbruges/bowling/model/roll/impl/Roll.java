package com.lbruges.bowling.model.roll.impl;

import com.lbruges.bowling.model.roll.IRoll;
import lombok.NoArgsConstructor;

/**
 * Regular roll representation.
 *
 * @author Laura Bruges
 */
@NoArgsConstructor
public class Roll implements IRoll {

    private int knockedPins;

    public Roll(int knockedPins) {
        this.knockedPins = knockedPins;
    }

    @Override
    public int getKnockedPins() {
        return knockedPins;
    }

    @Override
    public String toString() {
        return String.valueOf(knockedPins);
    }

}
