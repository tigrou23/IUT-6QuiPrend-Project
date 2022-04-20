package tests;

import static org.junit.Assert.*;
import game.Carte;
import game.Paquet;
import game.Plateau;
import org.junit.Test;

public class PlateauTest {

	@Test
	public void test_Plateau() {
		Paquet pa = new Paquet();
		Plateau pl = new Plateau(pa);
		for (int i = 0; i < 4; ++i) {
			assertTrue(pl.sommet(i).getNumero() <= 104 && pl.sommet(i).getNumero() >= 1);
		}
	}

	@Test
	/** Je teste que sommet renvoie pas le meme sommet si les series sont differentes
	 */
	public void test_sommet() {
		Paquet pa = new Paquet();
		Plateau pl = new Plateau(pa);
		int serie1 = 1, serie2 = 2;
		assertFalse(pl.sommet(serie1) == pl.sommet(serie2));
	}

	@Test
	/** Je test que lors de l'empilement, le sommet d'une meme serie n'est plus le
	 * meme
	 */
	public void test_empiler() {
		Paquet pa = new Paquet();
		Plateau pl = new Plateau(pa);
		Carte c1 = new Carte(1, 1);
		int serie = 1;
		pl.empiler(serie, c1);
		assertTrue(pl.sommet(serie) == c1);
	}

	@Test
	/** Je test que lors du depilement, le sommet d'une meme serie n'est plus le meme
	 */
	public void test_depiler() {
		Paquet pa = new Paquet();
		Plateau pl = new Plateau(pa);
		Carte c1 = new Carte();
		Carte c2 = new Carte(0, 1);
		Carte c3 = new Carte();
		int serie = 1;
		c1 = pl.sommet(serie - 1);
		pl.empiler(serie - 1, c2);
		assertFalse(c1.getNumero() == pl.sommet(serie).getNumero());
		pl.depiler(serie - 1);
		c2 = pl.sommet(serie);
	}

	@Test
	/** Je test qu'a l'initialisation, la methode renvoie 1 carte Puis si on empile,
	 * la serie comporte 2 cartes
	 */
	public void test_nbCarte() {
		Paquet pa = new Paquet();
		Plateau pl = new Plateau(pa);
		Carte c1 = new Carte(1, 1);
		int serie = 1;
		for (int i = 0; i < 4; ++i)
			assertTrue(pl.nbCarte(i) == 1);
		pl.empiler(serie, c1);
		assertTrue(pl.nbCarte(serie) == 2);
	}

}