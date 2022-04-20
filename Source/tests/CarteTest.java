package tests;

import static org.junit.Assert.*;
import game.Carte;
import org.junit.Test;

public class CarteTest {

	@Test
	/** Je test si 2 cartes differentes sont bien initialisees */
	public void test_Carte() {
		Carte c1 = new Carte(1, 1);
		Carte c2 = new Carte(2, 1);
		assertFalse(c1.getNumero() == c2.getNumero() && c1.getNbTete() == c2.getNbTete());
	}

	@Test
	/** Je teste si 2 meme cartes ont le meme affichage */
	public void test_toString() {
		Carte c1 = new Carte(1, 1);
		Carte c2 = new Carte(1, 1);
		assertTrue(c1.toString().equals(c2.toString()));
	}
}