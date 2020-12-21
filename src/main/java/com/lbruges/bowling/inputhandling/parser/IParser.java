package com.lbruges.bowling.inputhandling.parser;

import com.lbruges.bowling.exception.ApplicationException;

public interface IParser<T, R> {

    R parseTo(T obj) throws ApplicationException;

}
