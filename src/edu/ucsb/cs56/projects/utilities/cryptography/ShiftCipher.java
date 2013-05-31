package edu.ucsb.cs56.projects.utilities.cryptography;

/**
   A class to implement the Shift Cipher.
   @author Miranda Aperghis
   @author Callum Steele
   @version Project CS56, S13, 05/29/2013
 */
public class ShiftCipher{
    private int cipherKey;

    /**
       Default no-arg constructor.
    */
    public ShiftCipher(){}

    /**
       One-arg constructor.
       @param cipherKey an integer that is used to encrypt the plaintext
    */
    public ShiftCipher(int cipherKey){
	if(cipherKey<0 || cipherKey>26) throw new IllegalArgumentException();
	this.cipherKey = cipherKey;
    }

    /**
       Getter for the cipher key
       @return cipher key integer
    */
    public int getCipherKey(){
	return this.cipherKey;
    }

    /** 
	Setter for the cipher key
	@param cipherKey an integer is used to encrypt the plaintext
    */
    public void setCipherKey(int cipherKey){
	if(cipherKey<0 || cipherKey>26) throw new IllegalArgumentException();
	this.cipherKey = cipherKey;
    }

    /**
       Encryption algorithm for the shift cipher.
       Takes a word and then shifts the characters by a given number of places through the alphabet, defined by the cipherKey.
       @param word a plaintext word that is to be encrypted
       @return the ciphertext (the encrypted plaintext)
    */
    public String encrypt(String word){
	if(word == null) throw new IllegalArgumentException();
	String result = "";
	for(int i=0; i<word.length(); i++){
	    if(word.charAt(i)<97 || word.charAt(i)>122)
		throw new IllegalArgumentException();
	    int k = (((word.charAt(i)-97)+this.cipherKey)%26)+97;
	    result += Character.toString((char)k);
	}
	return result;
    }

}
