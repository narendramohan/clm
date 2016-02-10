package com.clm.tree.parsing;

/******************************************************************************
 * File: ParserUtils.java
 *
 * Utility functions for manipulating parsers.
 */

import java.util.*;

import com.clm.tree.parsing.exception.ParseErrorException;
import com.clm.tree.parsing.grammar.Terminal;

/**
 * A class containing utility functions for working with parsers.
 *
 */
public final class ParserUtils {
    /* This class is not meant to be instantiated. */
    private ParserUtils() {

    }

    /**
     * Runs a parser on a given stream of terminals.
     * <p>
     * This function either hands back the completed parse tree or raises an
     * exception if a parse error occurs.
     * 
     * @param parser The parser to run.
     * @param terminals The input to parse.
     * @return The completed parse tree.
     * @throws ParseErrorException If a parse error occurs.
     */
    public static ParseTree 
        parseSequence(Parser parser,
                      List<Terminal> terminals) throws ParseErrorException {
        for (Terminal t: terminals)
            parser.nextTerminal(t);
        return parser.inputComplete();
    }
}