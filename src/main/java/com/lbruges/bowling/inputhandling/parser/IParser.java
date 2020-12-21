package com.lbruges.bowling.inputhandling.parser;

import com.lbruges.bowling.exception.ApplicationException;

/**
 * Parser interface.
 * @param <T> input type
 * @param <R> output type
 */
public interface IParser<T, R> {

    /**
     * Parse an object to it's target type representation.
     * @param obj object to be converted
     * @return converted object
     * @throws ApplicationException
     */
    R parseTo(T obj) throws ApplicationException;

}
