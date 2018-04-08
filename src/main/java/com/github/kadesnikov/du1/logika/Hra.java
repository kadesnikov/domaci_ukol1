package com.github.kadesnikov.du1.logika;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hra {
	private boolean konecHry = false;
	private List<Slovo> words;
	private Integer spravne = 0;
	private Integer spatne = 0;
	private String guessed;

	public Hra() {
		words = new ArrayList<Slovo>();
		Slovo bear = new Slovo("bear");
		words.add(bear);
		Slovo cow = new Slovo("cow");
		words.add(cow);
		Slovo horse = new Slovo("horse");
		words.add(horse);
		Slovo butterfly = new Slovo("butterfly");
		words.add(butterfly);
		Slovo monkey = new Slovo("monkey");
		words.add(monkey);
		Slovo dolphin = new Slovo("dolphin");
		words.add(dolphin);
	}
	
	public List<Slovo> getWords(){
		return words;
	}
	
	public void vyberSlovo() {
    	Random randomWord = new Random();
    	guessed = words.get(randomWord.nextInt(words.size())).getNazev();
    }
	
    public boolean konecHry() {
        return konecHry;
    }
    
    public boolean guessedRight(String slovo) {
    	if (slovo.equals(guessed)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    
    public void setScore(String slovo) {
    	if (guessedRight(slovo)) {
    		spravne = spravne + 1;
    	}
    	else
    	{
    		spatne = spatne + 1;
    	}
    }
    public String getGuessed() {
    	return guessed;
    }
    
    public Integer getSpatne() {
        return spatne;
    }
    
    public Integer getSpravne() {
        return spravne;
    }
    
    
}
