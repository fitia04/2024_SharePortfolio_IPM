/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author somebody
 */
public class Portefeuille {
    // dico avec clé : Action, valeur : action,qté
    Map<Action, LignePortefeuille> mapLignes;
   

    public class LignePortefeuille {

        private Action action;

        private int qte;

        public int getQte() {
            return qte;
        }

        public void setQte(int qte) {
            this.qte = qte;
        }

        public Action getAction() {
            return this.action;
        }
        
        // Constructeur
        public LignePortefeuille(Action action, int qte) {  // Quantité d'une action
            this.action = action;
            this.qte = qte;
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }

    //constructeur
    public Portefeuille() {
        this.mapLignes = new HashMap();
    }

    public Map<Action, LignePortefeuille> getMapLignes() {
        return mapLignes;
    }
  
    
    
    

    public void acheter(Action a, int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a) == true) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }
    }
    
    public void delete(Action a) {
        if (this.mapLignes.containsKey(a) == true) {
            this.mapLignes.remove(a);
        }
    }

    public String toString() {
        return this.mapLignes.toString();
    }

    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
    

    /**
     * methode qui recherche une action dans le portefeuille 
     * @param action
     * @return ArrayList<Action>
     */
    public Action rechercherActionParNom(String nomAction) {
        for (Map.Entry<Action, LignePortefeuille> entry : mapLignes.entrySet()) {
            Action action = entry.getKey();
            if (action.getLibelle().equals(nomAction)) {   
                return action;
            }
        }
        return null;
    }
}
   