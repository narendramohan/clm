package com.clm.mmm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.clm.tree.parsing.ParseTree;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class SemanticMapping {

	public String semanticSpaceMapping(List<ParseTree> list) {
		return null;

	}

	public Parse[] parseTree(String message) {
		Parse topParses[] = null;
		InputStream modelIn = null;
		//sm.
		try {
			modelIn = new FileInputStream("en-parser-chunking.bin");
			ParserModel model = new ParserModel(modelIn);
			Parser parser = ParserFactory.create(model);
			topParses = ParserTool.parseLine(message, parser, 1);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn != null) {
				try {
					modelIn.close();
				} catch (IOException e) {
				}
			}
		}
		return topParses;
	}
	
	public static void main(String args[]){
		SemanticMapping sm = new SemanticMapping();
		String msg ="any tips for keeping fit?";
		Parse ps[] = sm.parseTree(msg);
		for(Parse p: ps){
			System.out.println(p.getType());
			System.out.println(p.getText());
		}
	}
}
