package com.lbruges.bowling.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

    BAD_ROLL_VALUE("001", "An invalid knocked down pins value was found while reading the input"),
    NEGATIVE_ROLL_VALUE("002", "Knocked down pins number cannot be negative"),
    GREATER_ROLL_VALUE("003", "Knocked down pins number cannot be greater than 10");

    private String exceptionCode;
    private String description;

    ExceptionEnum(String exceptionCode, String description) {
        this.exceptionCode = exceptionCode;
        this.description = description;
    }

}
