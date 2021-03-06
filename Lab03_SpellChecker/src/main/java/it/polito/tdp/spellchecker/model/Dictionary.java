package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
	List<String> elenco;
	
	
	public Dictionary() {
	elenco = new ArrayList<String>();
	
	}
	
	/**
	 * Permette di caricare parole corrette dal dizionario.
	 * @param language passata come parametro, scelta dal menuButton
	 * @throws IOException
	 */
	public void loadDictionary(String language) throws IOException {
		
		
		try {
			FileReader fr = new FileReader("src/main/resources/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				elenco.add(word);
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		    }
		
	}
	
	
	public String cercaParola (String parola) {
		for (String s:elenco) 
			if(parola.equals(s))
				return s;
		return null;
	}
	
	public List<RichWord> spellCheckText(String[] inputTextList){
		
		List<RichWord> lista = new ArrayList<RichWord>();
		
			for (String s : inputTextList) {
				if ( cercaParola(s)!=null) 
					lista.add(new RichWord(s,true));
				else
					lista.add(new RichWord(s,false));
			}			
		return lista;
	}

}
