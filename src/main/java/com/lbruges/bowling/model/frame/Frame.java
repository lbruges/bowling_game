package com.lbruges.bowling.model.frame;

import com.lbruges.bowling.model.roll.Roll;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Frame {

    public Frame(Roll firstRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = new Roll();
    }

    protected Roll firstRoll;
    protected Roll secondRoll;

    public int getTotalKnockedPins() {
        return firstRoll.getKnockedPins() + secondRoll.getKnockedPins();
    }

    public int getFirstRollKnockedPins() {
        return firstRoll.getKnockedPins();
    }

    public boolean isStrike() {
        return false;
    }
    public boolean isSpare() {
        return false;
    }

    public String toString() {
        return firstRoll.toString() + secondRoll.toString();
    }

}
