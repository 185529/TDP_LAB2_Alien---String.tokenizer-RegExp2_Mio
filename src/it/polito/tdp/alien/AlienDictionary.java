package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	
	private List<Word> dictionary;
	
		/**
	 * @param dictionary
	 */
	public AlienDictionary() {
		super();
		this.dictionary = new LinkedList<Word>();
	}

	public void addWord(String alienWord, String translation) {

		for(Word w : dictionary){
			if(w.compare(alienWord)){
				w.setTranslation(translation);
				return;
			}
		}
		
		Word parola = new Word(alienWord, translation);
		
		dictionary.add(parola);
		
	}

	public String translateWord(String alienWord) {

		for(Word w : dictionary){
			if(w.compare(alienWord)){
				return w.getTranslation();
			}
		}
		
		return null;
	}

}
