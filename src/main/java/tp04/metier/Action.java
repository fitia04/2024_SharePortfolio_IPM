/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.Objects;

/**
 *
 * @author somebody
 */
public abstract class Action {
    protected String libelle;
    protected String annotation;

    /**
     * Get the value of libelle
     *
     * @return the value of libelle
     */
    public String getAnnotation(){
        return annotation;
    }
    
    public void setAnnotation(String annotation){
        this.annotation = annotation;
    }
    
    public String getLibelle() {
        return libelle;
    }

    public Action(String libelle, String annotation) {
        this.libelle = libelle;
        this.annotation = annotation;
    }

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

    public String toString() {
        return this.getLibelle();
    }
}
