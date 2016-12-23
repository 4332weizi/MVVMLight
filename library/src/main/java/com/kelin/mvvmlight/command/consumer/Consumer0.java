package com.kelin.mvvmlight.command.consumer;

/**
 * A functional interface (callback) that accepts a single value.
 */
public interface Consumer0 {
    /**
     * Consume the given value.
     *
     * @throws Exception on error
     */
    void accept() throws Exception;
}