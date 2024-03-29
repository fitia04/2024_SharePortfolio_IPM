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

import java.util.Objects;

/**
 * Represents an abstract action .
 * <p>
 * This abstract class defines a basic structure for financial actions. Concrete subclasses
 * should implement the specific behavior related to a particular type of action.</p>
 * <p>
 * Example of usage: <code>Action action = new ConcreteAction("Libelle");</code></p>
 * 
 * @author Noe, Alexandre, Yasmine, Fitia, Larissa, Tidiane, Nam An
 */
public abstract class Action {

    /**
     * The label representing this action.
     */
    protected String libelle;
    
    /**
     * The annotation give information about this action
     */
    protected String annotation;

    /**
     * Constructs an Action with the given label.
     * 
     * @param libelle The label representing this action.
     * @param annotation the description of the action
     */
    public Action(String libelle,String annotation) {
        this.libelle = libelle;
        this.annotation = annotation;
    }

    /**
     * Gets the label representing this action.
     * 
     * @return The label of this action.
     */
    public String getLibelle() {
        return libelle;
    }
    
    /**
     * @return the annotation of this action
     */
    public String getAnnotation(){
        return annotation;
    }

    /**
     * Computes the value of this action for the given day.
     * <p>
     * This method should be implemented by concrete subclasses to define the specific
     * behavior related to computing the value of the action for a particular day.</p>
     * 
     * @param j The day for which to compute the value.
     * @return The value of this action for the given day.
     */
    public abstract float valeur(Jour j);

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.libelle);
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
        final Action other = (Action) obj;
        if (!Objects.equals(this.libelle, other.libelle)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getLibelle();
    }
}
