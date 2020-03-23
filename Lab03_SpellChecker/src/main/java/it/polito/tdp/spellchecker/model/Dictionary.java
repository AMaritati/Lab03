package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
	List<String> uk;
	List<String> ita;
	RichWord parola;
	
	public Dictionary() {
	uk = new ArrayList<String>();
	ita = new ArrayList<String>();
	parola = new RichWord();
	}
	
	/**
	 * Permette di caricare parole corrette dal dizionario.
	 * @param language passata come parametro, scelta dal menuButton
	 * @throws IOException
	 */
	public void loadDictionary(String language) throws IOException {
		
		if (language.equals("English")) {
		try {
			FileReader fr = new FileReader("English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				uk.add(word);
			}
			br.close();
			
		} catch (IOException e) {
			System.out.println("Errore nella lettura del file");
		    }
		
		}
		else if (language.equals("Italiano")) {
			try {
				FileReader fr = new FileReader("Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					ita.add(word);
				}
				br.close();
				
			} catch (IOException e) {
				System.out.println("Errore nella lettura del file");
			}
		}
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> temp = new ArrayList<RichWord>();
		String testo = inputTextList.toString().toLowerCase();
		testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]","");
		String tokens[] = testo.split(" ");
		int i = 0;
		for (String a : uk) {
			if (a.equals(tokens[i])) {
				
			}
		}
		
		
		
		
		return temp;
	}

}
