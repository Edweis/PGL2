package application;

import static java.lang.System.out;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import metier.Article;
import metier.Colis;
import metier.Dimension;
import partieMission.GrpColis;
import utilisateur.Bdd;
import utilisateur.Utilisateur;
import view.AfficheurGrp;

public class Main {

	private static final String fmt = "%24s: %s%n";

	// for the morbidly curious
	<E extends RuntimeException> void genericThrow() throws E {

	}

	public static void main(String... args) throws Throwable {
		Bdd<Utilisateur> bddUser = new Bdd<Utilisateur>(Utilisateur.class);
		bddUser.add(new Utilisateur("a","b","c",true,false,"d"));
	}

	public static void exempleAfficheurGrp() {
		JFrame fenetre = new JFrame("Salut !");
		fenetre.setLayout(new GridLayout(2, 0));

		JTabbedPane tabbedPane = new JTabbedPane();

		// ---------------------Onglet1

		JPanel onglet1 = new JPanel();
		AfficheurGrp<Colis> afficheur = new AfficheurGrp<Colis>("Mon nouvel afficheur, il est beau ?");

		// creer mon groupe de colis

		GrpColis grp = new GrpColis();

		Colis c1 = new Colis(10, new Dimension(11, 22, 33));
		c1.setInfos("George", "Paris", "bleue");
		Colis c2 = new Colis(20, new Dimension(11, 22, 33));
		c2.setInfos("René", "NYC", "bleue");
		Colis c3 = new Colis(30, new Dimension(11, 22, 33));
		c3.setInfos("Bob", "OKil", "bleue");

		grp.add(c1);
		grp.add(c2);
		grp.add(c3);

		afficheur.MajGrpColis(grp.getColis());
		onglet1.add(afficheur);

		afficheur.setAllParamFormat(new int[] { 0, 60, 0, 0, 60 });

		// Zone de lecture
		JLabel zone = new JLabel("fghj");
		onglet1.add(zone);

		// Associe l'afficheur avec la zone
		afficheur.ajouterZoneDetail(zone);

		tabbedPane.addTab("onglet1", onglet1);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		// ---------------------Onglet2

		JPanel onglet2 = new JPanel();
		JLabel test = new JLabel("Test de Biatch");
		onglet2.add(test);

		tabbedPane.addTab("onglet2", onglet2);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_2);
		fenetre.add(tabbedPane);
		fenetre.pack();
		fenetre.setVisible(true);
	}

	public static void exempleAfficheurGrp2() {
		Article a1 = new Article("salut", "jaques");
		Article a2 = new Article("df", "jaquqsdqses");
		Article a3 = new Article("sadfsdflut", "jaqucdcdes");

		ArrayList<Article> mesArticles = new ArrayList<Article>();
		mesArticles.add(a1);
		mesArticles.add(a2);
		mesArticles.add(a3);

		AfficheurGrp<Article> afficheur = new AfficheurGrp<Article>();
		afficheur.MajGrpColis(mesArticles);
	}

	public static void exempleReflexionCalss() {
		try {
			Class<?> c = Class.forName("utilisateur.Utilisateur");
			Constructor[] allMethods = c.getConstructors();
			for (Constructor m : allMethods) {
				out.println("----------");
				out.format("%s%n", m.toGenericString());

				Class<?>[] pType = m.getParameterTypes();
				Type[] gpType = m.getGenericParameterTypes();
				for (int i = 0; i < pType.length; i++) {
					out.format(fmt, "ParameterType", pType[i]);
					// out.format(fmt, "GenericParameterType", gpType[i]);
				}

				Class<?>[] xType = m.getExceptionTypes();
				Type[] gxType = m.getGenericExceptionTypes();
				for (int i = 0; i < xType.length; i++) {
					out.format(fmt, "ExceptionType", xType[i]);
					out.format(fmt, "GenericExceptionType", gxType[i]);
				}
			}

			// production code should handle these exceptions more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}

	public static void exempleReflexionConstructeur() throws Throwable {
		Object[] param = new Object[] { "a", "a", "a", true, true, "kk" };

		Constructor<?>[] c = Utilisateur.class.getConstructors();

		Utilisateur u = (Utilisateur) c[0].newInstance(param);
		
		out.println(c[0].getParameters()[1].getName());
		
		c[0].getParameterCount();
	}
}
