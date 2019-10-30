package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;

public class Blogg {

	// TODO: objektvariabler 
	private Innlegg[] innleggTabell;
	private int nesteLedige;

	public Blogg() {
		innleggTabell = new Innlegg[20];
		nesteLedige = 0; 
	}

	public Blogg(int lengde) {
		innleggTabell = new Innlegg[lengde];
		nesteLedige = 0;
	}

	public int getAntall() {
		return nesteLedige;
	}
	
	public Innlegg[] getSamling() {
		return innleggTabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int pos = -1; 
		int i = 0;
		while (i < nesteLedige && pos == -1) {
			if (innleggTabell[i].getId() == innlegg.getId()) {
				pos = i;
			}
			i++;
		}
		return pos;
	}

	public boolean finnes(Innlegg innlegg) {
		boolean funnet = false; 
		if (finnInnlegg(innlegg) >= 0) {
			funnet = true;
		} else {
			funnet = false;
		}
		return funnet;
	}

	public boolean ledigPlass() {
		boolean ledig = false; 
		if (nesteLedige < innleggTabell.length) {
			ledig = true; 
		} else {
			ledig = false; 
		}
		return ledig;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false; 
		if (!finnes(innlegg)) {
			innleggTabell[nesteLedige] = innlegg;
			nesteLedige++;
			lagtTil = true;
		} else {
			return lagtTil;
		}
		return lagtTil;

	}
	
	public String toString() {
		String ut = String.valueOf(nesteLedige) + "\n";
		for (int i = 0; i < nesteLedige; i++) {
			ut = ut + innleggTabell[i].toString();
		}
		return ut; 
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[innleggTabell.length * 2];
		for (int i = 0; i < nesteLedige; i++) {
			ny[i] = innleggTabell[i];
		}
		innleggTabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = false; 
		if (finnes(innlegg)) { 
			return lagtTil;
		} else { 
			if (leggTil(innlegg)) {
				lagtTil = true;
			} else { 
				utvid();
				leggTil(innlegg);
				lagtTil = true;
			}
		}
		return lagtTil;
	}
	
	public boolean slett(Innlegg innlegg) {
		int p = finnInnlegg(innlegg);
		if (p >= 0) {
			nesteLedige--;
			innleggTabell[p] = innleggTabell[nesteLedige];
			innleggTabell[nesteLedige] = null;
			return true;
		} else {
			return false;
		} 
    }
	
	public int[] search(String ord) {
		int[] treffTabell = new int[nesteLedige];
		for (int i = 0; i < nesteLedige; i++) {
			//Hvordan referere til tekst variabelen i et innlegg i tabellen? 
			Tekst test = new Tekst();
			test.getTekst();
			
		}
		
		return treffTabell;
	}
}






