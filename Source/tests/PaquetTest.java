package tests;

import static org.junit.Assert.*;
import game.Carte;
import game.Paquet;
import org.junit.Test;

public class PaquetTest {

	@Test
	/** Je test d'abord si toutes les cartes du paquet sont entre 1 et 104 et si la
	 * distribution renvoie une carte valide
	 */
	public void test_distributionCarte() {
		Paquet p = new Paquet();
		Carte c = new Carte();
		for (int i = 0; i < 104; ++i) {
			c = p.distributionCarte();
			assertTrue(c.getNumero() <= 104 && c.getNumero() >= 1);
		}
	}

}