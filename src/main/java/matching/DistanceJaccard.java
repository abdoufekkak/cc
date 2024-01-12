package matching;

import java.util.HashSet;
import java.util.Set;

public class DistanceJaccard implements SimilariteChaine{

	@Override
    public double distance(String chaine1, String chaine2) {
        if (chaine1 == null || chaine2 == null) {
            throw new IllegalArgumentException("Les chaînes ne doivent pas être nulles.");
        }

        Set<Character> ensemble1 = chaineToEnsemble(chaine1);
        Set<Character> ensemble2 = chaineToEnsemble(chaine2);

        Set<Character> intersection = new HashSet<>(ensemble1);
        intersection.retainAll(ensemble2);

        Set<Character> union = new HashSet<>(ensemble1);
        union.addAll(ensemble2);

        return intersection.size() / (double) union.size();
    }

    private Set<Character> chaineToEnsemble(String chaine) {
        Set<Character> ensemble = new HashSet<>();
        for (char c : chaine.toCharArray()) {
            ensemble.add(c);
        }
        return ensemble;
    }

}
