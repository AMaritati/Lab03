package it.polito.tdp.spellchecker.model;

public class RichWord {
	private String word;
	private Boolean isCorretta;
	
	public RichWord(String word, Boolean isCorretta) {
		
		this.word = word;
		this.isCorretta = isCorretta;
	}


	public String getWord() {
		return word;
	}


	public Boolean getIsCorretta() {
		return isCorretta;
	}


	public void setIsCorretta(Boolean isCorretta) {
		this.isCorretta = isCorretta;
	}


	public void setWord(String word) {
		this.word = word;
	}
	

}
