package com.kelin.mvvmlight.command.function;

/**
 * A functional interface that takes a value and returns another value, possibly with a
 * different type and allows throwing a checked exception.
 *
 * @param <R> the output value type
 */
public interface Function0<R> {
    /**
     * Apply some calculation to the input value and return some other value.
     *
     * @return the output value
     * @throws Exception on error
     */
    R apply() throws Exception;
}
