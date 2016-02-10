package com.clm.tree.parsing.grammar;
/******************************************************************************
 * File: Terminal.java
 *
 * A class representing a terminal symbol in a grammar.
 */

/**
 * A class representing a terminal symbol in a grammar.
 */
public final class Terminal extends Symbol {
    /**
     * Creates a new terminal symbol with the given name, which must not be
     * null or the empty string.
     *
     * @param name The name of the terminal.
     */
    public Terminal(String name) {
        super(name, true);
    }
}