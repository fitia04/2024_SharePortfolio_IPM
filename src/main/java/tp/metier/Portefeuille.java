/*
 * Copyright 2024 Yasmine et Fiita;.
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
    // Dictionary with key: Action, value: action, quantity
    Map<Action, LignePortefeuille> mapLignes;

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
}
