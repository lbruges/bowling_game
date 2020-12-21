package com.lbruges.bowling.exception;

/**
 * Custom application exception.
 *
 * @author Laura Bruges
 */
public class ApplicationException extends Exception {

    public ApplicationException(ExceptionEnum exceptionEnum) {
        super(buildMessage(exceptionEnum));
    }

    public ApplicationException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(buildMessage(exceptionEnum), cause);
    }

    private static String buildMessage(ExceptionEnum exceptionEnum) {
        StringBuilder sb = new StringBuilder();
        sb.append("Exception code: ")
                .append(exceptionEnum.getExceptionCode())
                .append(". ")
                .append(exceptionEnum.getDescription())
                .append(". ");
        return sb.toString();
    }

}
