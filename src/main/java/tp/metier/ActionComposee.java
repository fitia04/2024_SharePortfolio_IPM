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

/**
 * Represents a composite action in a financial context.
 * <p>
 * This class extends the abstract class Action to represent a composite action, which is
 * composed of multiple simple actions with corresponding weights.</p>
 * <p>
 * Example of usage: <code>ActionComposee action = new ActionComposee("Libelle");</code></p>
 * 
 * @author Noe, Alexandre, Yasmine, Fitia, Larissa, Tidiane, Nam An
 */
public class ActionComposee extends Action {

    /**
     * Map associating simple actions with their respective weights in the composite action.
     */
    private Map<ActionSimple, Float> mapPanier;

    /**
     * Constructs a composite action with the given label.
     * 
     * @param libelle The label representing this composite action.
     */
    public ActionComposee(String libelle,String annotation) {
        super(libelle,annotation);
        this.mapPanier = new HashMap();
    }

    /**
     * Associates a simple action with its weight in the composite action.
     * 
     * @param as The simple action to be included in the composition.
     * @param pourcentage The weight of the simple action in the composition (as a percentage).
     */
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    /**
     * Computes the value of the composite action for the given day.
     * <p>
     * This method calculates the value of the composite action based on the values of its
     * constituent simple actions and their respective weights.</p>
     * 
     * @param j The day for which to compute the value.
     * @return The value of the composite action for the given day.
     */
    @Override
    public float valeur(Jour j) {
        float valeur = 0;

        for (ActionSimple as : this.mapPanier.keySet()) {
            valeur += as.valeur(j) * this.mapPanier.get(as);
        }

        return valeur;
    }
}
