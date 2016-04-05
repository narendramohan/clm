package com.clm.mmm;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;



import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
/*
Algorithm 2 Semantic Space Mapping
Input: a set of Tree Fragments, Wikipedia, WordNet
Output: Semantic Feature Space (SF)
1: SF  = null
2: for tree fragment f in F do
3: if f in Phrase-Level then
4: f.Query   SolrSyntax(f, AND)
5: Wikip =  RetrievePages(f.Query)
6: SF =  SF + WikiConcepts(Wikip)
7: SF =  SF + WikiTopics(Wikip)
8: else
9: WNconcept =  WordNet.Synsets(f)
10: SF =  SF + WNconcept
11: end if
12: end for
13: return SF 
*/
public class SemanticMapping {

	public String semanticSpaceMapping(List<Parse> list, List fragList) { 	
		SyntacticDecomposition sd = new SyntacticDecomposition();
		
		String sf=null;
		String query=null;
		for(Parse p:list){
			if(fragList.contains(p)){
				query = solrSyntax(p,"AND");
				String wikip = retrievePages(query);
				sf = sf+wikiConcept(wikip);
				sf=sf+wikiTopic(wikip);
			} else{
				/*String wNConcept = WordNet.Synsets(p);
				sf=sf+wNConcept;*/
			}
		}
		return null;

	}

	private String wikiTopic(String wikip) {
		// TODO Auto-generated method stub
		return null;
	}

	private String wikiConcept(String wikip) {
		// TODO Auto-generated method stub
		return null;
	}

	private String retrievePages(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	private String solrSyntax(Parse p, String string) {
		// TODO Auto-generated method stub
		return null;
	}


}
