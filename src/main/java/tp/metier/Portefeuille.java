/*
 * Copyright 2024 Yasmine et Fitia;.
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
package tp.metier;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;


/**
 * Represents a financial portfolio.
 * <p>
 * This class represents a financial portfolio, which consists of a collection of actions
 * and their respective quantities.</p>
 * <p>
 * Example of usage: <code>Portefeuille portefeuille = new Portefeuille();</code></p>
 * 
 * @author Noe, Alexandre, Yasmine, Fitia, Larissa, Tidiane, Nam An
 */
public class Portefeuille {
    /**
     * Dictionary with key: Action, value: action, quantity
     */
    Map<Action, LignePortefeuille> mapLignes;
    
    /**
     *  Dictionnaire  for the identification of a user 
     */
    Map<String, String> identification = new HashMap<>();
    
    private String user; 
    private String mdp;
        
    /**
     * Represents a line in the portfolio.
     * <p>
     * This inner class represents a line in the portfolio, associating an action with its quantity.</p>
     */
    public class LignePortefeuille {
        private Action action;
        private int qte;

        /**
         * Gets the quantity of the action in this line.
         * 
         * @return The quantity of the action.
         */
        public int getQte() {
            return qte;
        }

        /**
         * Sets the quantity of the action in this line.
         * 
         * @param qte The new quantity of the action.
         */
        public void setQte(int qte) {
            this.qte = qte;
        }

        /**
         * Gets the action associated with this line.
         * 
         * @return The action associated with this line.
         */
        public Action getAction() {
            return this.action;
        }

        /**
         * Constructs a portfolio line with the given action and quantity.
         * 
         * @param action The action associated with this line.
         * @param qte The quantity of the action in this line.
         */
        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        @Override
        public String toString() {
            return Integer.toString(qte);
        }
    }

    /**
     * Constructs an empty portfolio.
     */
    public Portefeuille() {
        this.mapLignes = new HashMap();
    }
    
    
   
    /**
     * Gets the map of portfolio lines.
     * 
     * @return The map of portfolio lines.
     */
    public Map<Action, LignePortefeuille> getMapLignes() {
        return mapLignes;
    }

    /**
     * Buys a quantity of the given action and adds it to the portfolio.
     * 
     * @param a The action to buy.
     * @param q The quantity to buy.
     */
    public void acheter(Action a, int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    /**
     * Sells a quantity of the given action from the portfolio.
     * 
     * @param a The action to sell.
     * @param q The quantity to sell.
     */
    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a)) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }
    }
    
    /**
     * Deletes the line corresponding to the given action from the portfolio.
     * 
     * @param a The action to delete.
     */
    public void delete(Action a) {
        if (this.mapLignes.containsKey(a)) {
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
        Set<Action> cle = portefeuille.getMapLignes().keySet();
        for(Action c : cle){
            annotations.add(c.getAnnotation());
        } 
        return annotations;
    }


    @Override
    public String toString() {
        return this.mapLignes.toString();
    }

    /**
     * Computes the total value of the portfolio for the given day.
     * 
     * @param j The day for which to compute the value.
     * @return The total value of the portfolio for the given day.
     */
    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total += lp.getQte() * lp.getAction().valeur(j);
        }
        return total;
    }
    
    /**
     * Searches for an action in the portfolio by its name.
     * 
     * @param nomAction The name of the action to search for.
     * @return The action found, or null if not found.
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
    
    /**
     * The fonction to help ther user to connect to his wallet 
     * @param id
     * @param mdp 
     */
    public boolean connectToWallet (String id, String mdp) {
        // Vérifie si le nom d'utilisateur existe dans le dictionnaire
        if (identification.containsKey(id)) {
            // Vérifie si le mot de passe correspond au nom d'utilisateur
            if (identification.get(id).equals(mdp)){
               
                System.out.println("La connection s'est bien passée");
                return true; 
            }
            else {
                System.out.println("Le mot de passe est incorrecte");
                return false;
            }
                
        }
        else{
            System.out.println("Cet identifiant n'existe pas");
            return false; 
        }
    }
    
    /**
     * This function allows user to create their own id and password for their wallet
     * @param id
     * @param mdp
     * @return true if user created, false if not
     */
    public boolean createUser(String id, String mdp) {
      if (!identification.containsKey(id)) {
          identification.put(id, mdp);
          this.user = id;
          this.mdp = mdp;
          System.out.println("Le compte a été créé");
          return true;
      } else {
          System.out.println("Cet UserName est déjà utilisé.");
          return false;
      }
    }

            
 
}
