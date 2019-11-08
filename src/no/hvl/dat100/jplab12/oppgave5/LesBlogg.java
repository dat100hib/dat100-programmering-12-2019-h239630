package no.hvl.dat100.jplab12.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;
import no.hvl.dat100.jplab12.oppgave2.*;
import no.hvl.dat100.jplab12.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String filnavn) {
		Blogg blogg = null;
		try {
		String fil = MAPPE + filnavn;
		Scanner leser = new Scanner(new File(fil));
		int lengde = Integer.parseInt(leser.nextLine());
		blogg = new Blogg(lengde);
		
		
		while(leser.hasNextLine()) {
			if (leser.nextLine().equals(TEKST)) {
					int id = Integer.parseInt(leser.nextLine());
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int likes = Integer.parseInt(leser.nextLine());
					String txt = leser.nextLine();
				
					Tekst tekst = new Tekst(id, bruker, dato, likes, txt);
					blogg.leggTil(tekst);
					
			} else {
					int id = Integer.parseInt(leser.nextLine());
					String bruker = leser.nextLine();
					String dato = leser.nextLine();
					int likes = Integer.parseInt(leser.nextLine());
					String tekst = leser.nextLine();
					String url = leser.nextLine();
					
					Bilde bilde = new Bilde(id, bruker, dato, likes, tekst, url);
					blogg.leggTil(bilde);	
			}
		}
		leser.close();
		
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Fant ikke filen");
		}
		return blogg;
		
	}
}
