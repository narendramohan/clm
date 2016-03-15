package com.clm.mmm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
//Algorithm 1
/**
*	Algorithm 1 Tree Fragments Generation
*	Input: microblogging message corpus M
*	Output: a set of tree fragments (F)
*	1: F   null
*	2: for m in M do
*	3: m0 =  Lexical Tokens (m)
*	4: T  = Parse Tree Construction (m0)
*	5: T0 = {t1, t2,..., tn}   SubTrees Selection(T)
*	6: for sub tree t in T0 do
*	7: if t in {NP, VP, NN, VB} then
*	8: {f1, f2,..., fn} =  Fragments Selection(t)
*	9: F   F + {f1; f2,..., fn}
*	10: end if
*	11: end for
*	12: end for
*	13: return F
*
*/
public class SyntacticDecomposition {

	public List createTreeFragment(List<String> msgs){
		List fragment= new ArrayList();
		for(String message:msgs){
			Parse topParses[] = parseTree(message);
			Parse subTree[] = selectSubTree(topParses);
			for (Parse p:subTree){
				if(Arrays.asList(new String()).contains(p.getLabel())){
					fragment.add(selectFragment(p));
				}
			}
		}
		
		return fragment;
	}
	private String selectFragment(Parse p) {
		
		return p.getLabel();
	}
	public Parse[] parseTree(String message) {
		Parse topParses[] = null;
		InputStream modelIn = null;
		String [] frg=new String[] {"NP", "VP","NN","VB"};
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
	
	private Parse[] selectSubTree(Parse[] topParses) {
		List<Parse> lst = new ArrayList<Parse>();
		for(Parse p:topParses){
			if(p.isChunk()){
				lst.add(p);
			}
				
		}
		return lst.toArray(new Parse[lst.size()]);
	}

	public static void main(String args[]){
		SyntacticDecomposition sm = new SyntacticDecomposition();
		String msg ="any tips for keeping fit?";
		Parse ps[] = sm.parseTree(msg);
		for(Parse p: ps){
			System.out.println(p.getType());
			System.out.println(p.getText());
		}
	}
}
