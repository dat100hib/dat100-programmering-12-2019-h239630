package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

import java.io.*;

import no.hvl.dat100.jplab12.oppgave1.Innlegg;
import no.hvl.dat100.jplab12.oppgave3.*;


public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	public static boolean skriv(Blogg samling, String filnavn) throws Exception {
		boolean skrevet = false;
		try {
			File fil = new File(MAPPE + filnavn);
			PrintWriter skriver = new PrintWriter(fil);
			Innlegg[] innleggTabell = samling.getSamling();
			
			for (int i = 0; i < samling.getAntall(); i++) {
				skriver.print(innleggTabell[i].toString());
			}
			skrevet = true;
			skriver.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Feil filnavn");
		}
		return skrevet;
	}
}
