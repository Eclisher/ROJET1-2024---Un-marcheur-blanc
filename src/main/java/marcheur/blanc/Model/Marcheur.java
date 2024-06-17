package marcheur.blanc.Model;

import lombok.Getter;

import java.util.*;

@Getter
public class Marcheur {
    private Lieu positionActuelle;
    private Marche marcheEnCours;

    public Marcheur(Lieu positionActuelle) {
        this.positionActuelle = positionActuelle;
        this.marcheEnCours = new Marche(positionActuelle);
    }

    public void avancerAleatoirement() {
        Set<Rue> ruesPossibles = positionActuelle.getRues();
        List<Rue> ruesListe = new ArrayList<>(ruesPossibles);

        if (!ruesListe.isEmpty()) {
            Random random = new Random();
            Rue rueChoisie = ruesListe.get(random.nextInt(ruesListe.size()));
            Lieu prochainLieu = (rueChoisie.getLieu1().equals(positionActuelle)) ? rueChoisie.getLieu2() : rueChoisie.getLieu1();
            positionActuelle = prochainLieu;
            marcheEnCours.ajouterLieu(prochainLieu);
        }
    }
}
