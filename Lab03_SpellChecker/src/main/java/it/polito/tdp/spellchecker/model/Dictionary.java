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
	
	public List<String> StringToList (String testo) {
		
			testo.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_'()\\[\\]\"]","");
			testo.toLowerCase();
			String tokens[] = testo.split(" ");
			List<String> list = Arrays.asList(tokens);
		
			return list;
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		boolean flag=false;
		List<RichWord> lista = new ArrayList<RichWord>();
		for(String a : elenco) {
			for (String b : inputTextList) {
				if ( a.equals(b)) {
					flag = true;
					lista.add(new RichWord (b,flag));}
		}
			}
		return lista;
	}

}
