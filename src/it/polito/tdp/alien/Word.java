package it.polito.tdp.alien;

public class Word {
	
	private String alienWord;
	private String translation;
	
	/**
	 * @param alienWord
	 * @param translation
	 */
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public void setTranslation(String translation) {

		this.translation = translation;
		
	}

	public boolean compare(String alienWord) {

		if(this.alienWord.equals(alienWord)){
			return true;
		}else{
			return false;
		}
	}

	public String getTranslation() {
		return this.translation;
	}

}
