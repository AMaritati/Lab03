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
	parola = new RichWord(null, null);
	}
	
	/**
	 * Permette di caricare parole corrette dal dizionario.
	 * @param language passata come parametro, scelta dal menuButton
	 * @throws IOException
	 */
	public void loadDictionary(String language) throws IOException {
		
		if (language.equals("English")) {
		try {
			FileReader fr = new FileReader("src/main/resources/English.txt");
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
		else if (language.equals("Italian")) {
			try {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
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
		String testo="";
		boolean flag=false;
		List<RichWord> temp = new ArrayList<RichWord>();
		for (String a : inputTextList) {
			testo+=a.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]","");
		}
		testo.toLowerCase();
		String tokens[] = testo.split(" ");
		int N = tokens.length;
		int i = 0;

		for (i=0;i<N;i++) {
		
			for (String a : uk) {
			//comparare token con parola del dizionario
			if (tokens[i].equals(a)) {
				flag = true;}
			}
			temp.add(new RichWord (tokens[i],flag));
		}
		return temp;
	}

}
