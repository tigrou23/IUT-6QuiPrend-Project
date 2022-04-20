package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Carte;
import game.Paquet;
import game.Plateau;
import game.Player;

public class PlayerTest {

	@Test
	/** Je test si le ramassage de la bonne serie a ete effectue D'abord si le nombre
	 * de penalites ont augmente Puis si la carte qui remplace la serie est bien au
	 * sommet de la serie
	 */
	public void test_ramasser() {
		Paquet pa = new Paquet();
		Plateau pl = new Plateau(pa);
		Carte c1 = new Carte(1, 1);
		Player p1 = new Player("P1", pa);
		int serie = 1;
		p1.ramasser(serie, pl, c1);
		assertTrue(p1.penalite() > 0);
		assertTrue(pl.sommet(serie - 1).equals(c1));
	}

	@Test
	/** Je test si l'affichage entre 2 joueurs est different D'abord si
	 * l'initialisation est coherente
	 */
	public void test_toString() {
		Paquet pa = new Paquet();
		Player p1 = new Player("P1", pa);
		assertTrue(p1.toString().compareTo("P1") == 0);
		assertTrue(p1.penalite() == 0);
		assertTrue(p1.ordre() == 0);
		Player p2 = new Player("P2", pa);
		assertFalse(p1.toString().compareToIgnoreCase(p2.toString()) == 1);
	}
}