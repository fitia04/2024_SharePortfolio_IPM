/*
 * Copyright 2024 yasmine et Fitia.
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
import org.junit.jupiter.api.Test;
import tp.metier.ActionComposee;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author yasmi
 */
 class ActionComposeeTest {
     
    @Test
    public void testValeur() {
    //Arrange
    ActionComposee actionComposee = new ActionComposee("ActionC");
    ActionSimple actionSimple1 = new ActionSimple("ActionS1");
    ActionSimple actionSimple2 = new ActionSimple("ActionS2");
    Jour jour = new Jour(2024, 3);
    
     //Action
    actionSimple1.enrgCours(jour, 10);
    actionSimple2.enrgCours(jour, 20);
    actionComposee.enrgComposition(actionSimple1,50);
    actionComposee.enrgComposition(actionSimple2, 50);
     
    // Calcul de la valeur attendue
    float valeurAttendue = (50 * 10) + (50 * 20); 
    // Calcul de la valeur réelle
    float valeurObtenue = actionComposee.valeur(jour); 

    // Assert
    assertEquals(valeurAttendue, valeurObtenue);
        
    }    
}
