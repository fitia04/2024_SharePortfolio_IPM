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
 * Represents a simple action in a financial context.
 * <p>
 * This class extends the abstract class Action to represent
 * a simple action, which is associated with daily values.</p>
 * <p>
 * Example of usage: <code> ActionSimple action = new ActionSimple("Libelle");</code></p>
 * @author Noe, Alexandre, Yasmine, Fitia, Larissa, Tidiane, Nam An
 */
public class ActionSimple extends Action {

    /**
     * Map associating days with their respective course values for this simple action.
     */
    private Map<Jour, Cours> mapCours;

    /**
     * Constructs a simple action with the given label.
     * 
     * @param libelle The label representing this simple action.
     */
    public ActionSimple(String libelle) {
        super(libelle);
        this.mapCours = new HashMap();
    }
    
    /**
     * Associates a course value with the given day for this simple action.
     * 
     * @param j The day for which to associate the course value.
     * @param v The course value for the given day.
     */
    public void enrgCours(Jour j, float v) {
        if (!this.mapCours.containsKey(j)) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    /**
     * Computes the value of the simple action for the given day.
     * <p>
     * This method retrieves the course value for the given day, if available, and returns
     * it. If there is no course value available for the day, it returns 0.</p>
     * 
     * @param j The day for which to compute the value.
     * @return The value of the simple action for the given day.
     */
    @Override
    public float valeur(Jour j) {
        if (this.mapCours.containsKey(j)) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0; // Alternatively, could throw an exception or return a constant value.
        }
    }
}
