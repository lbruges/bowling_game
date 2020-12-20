package com.lbruges.bowling.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

    IO_ERROR("001", "Error while trying to read the input file"),
    INVALID_INPUT("002", "An invalid input value was found"),
    BAD_ROLL_VALUE("003", "An invalid knocked down pins value was found while reading the input"),
    NEGATIVE_ROLL_VALUE("004", "Knocked down pins number cannot be negative"),
    GREATER_ROLL_VALUE("005", "Knocked down pins number cannot be greater than 10");

    private String exceptionCode;
    private String description;

    ExceptionEnum(String exceptionCode, String description) {
        this.exceptionCode = exceptionCode;
        this.description = description;
    }

}
