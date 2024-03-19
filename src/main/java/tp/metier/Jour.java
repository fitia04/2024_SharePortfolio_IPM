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

/**
 * Represents a day in a financial context.
 * <p>
 * This class represents a specific day in a financial context, defined by its year and day number.</p>
 * <p>
 * Example of usage: <code>Jour jour = new Jour(2024, 3);</code></p>
 * 
 * @author Noe, Alexandre, Yasmine, Fitia, Larissa, Tidiane, Nam An
 */
public class Jour {

    /**
     * The year of this day.
     */
    private int annee;
    /**
     * The day number of this day.
     */
    private int noJour;

    /**
     * Constructs a day with the given year and day number.
     * 
     * @param annee The year of the day.
     * @param noJour The day number of the day.
     */
    public Jour(int annee, int noJour) {
        this.annee = annee;
        this.noJour = noJour;
    }

    /**
     * Gets the year of this day.
     * 
     * @return The year of this day.
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Gets the day number of this day.
     * 
     * @return The day number of this day.
     */
    public int getNoJour() {
        return noJour;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.annee;
        hash = 61 * hash + this.noJour;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jour other = (Jour) obj;
        if (this.annee != other.annee) {
            return false;
        }
        if (this.noJour != other.noJour) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Jour{" + "annee=" + annee + ", noJour=" + noJour + '}';
    }
}
