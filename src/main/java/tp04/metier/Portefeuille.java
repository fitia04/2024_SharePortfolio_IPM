/*
 * Copyright 2024 Noé, Alxandre, Fitia, Yasmine;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        public int getQte() {return qte;}
        public void setQte(int qte) {this.qte = qte;}
        public Action getAction() {return this.action;}
        
        // Constructeur
        public LignePortefeuille(Action action, int qte) {  // Quantité d'une action
            this.action = action;
            this.qte = qte;
        }
        public String toString() {return Integer.toString(qte);}
    }

        
    public Map<Action,LignePortefeuille> getLignePortefeuille(){
            return mapLignes;
        }
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
    
    
    /**
 * Méthode permettant de visualiser les actions disponibles dans un portefeuille,
 * c'est-à-dire les actions dont la quantité disponible est supérieure à zéro.
 *
 * @param ActionDispo Une HashMap contenant des objets ActionSimple en tant que clés
 *                    et des entiers représentant les quantités disponibles en tant que valeurs.
 * @return Une ArrayList d'objets ActionSimple représentant les actions disponibles.
 */
    public ArrayList<ActionSimple> visualiserActions(HashMap<ActionSimple,Integer> ActionDispo)
    {
        ArrayList<ActionSimple> listAction = new ArrayList<ActionSimple>();
        for(Map.Entry<ActionSimple,Integer> entry : ActionDispo.entrySet()){
            if(entry.getValue() > 0){
                listAction.add(entry.getKey());
            }
        }
        return listAction;
    }        

       /**
 * Méthode permettant de visualiser les annotations des actions présentes dans le portefeuille
 *
 * @param On passe en paramètre un portefeuille
 * @return Une ArrayList contenant les annotations des différentes actions du portefeuille
 */
    public ArrayList<String> visualiserAnnotationPortefeuille(Portefeuille portefeuille)
    {
        ArrayList<String> annotations = new ArrayList<String>();
        Set<Action> cle = portefeuille.getLignePortefeuille().keySet();
        for(Action c : cle){
            annotations.add(c.getAnnotation());
        } 
        return annotations;
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
}