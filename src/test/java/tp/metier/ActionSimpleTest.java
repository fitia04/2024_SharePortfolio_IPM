/*
 * Copyright 2024 yasmi.
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
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author yasmi
 */
 class ActionSimpleTest {
     
    /**
     * Test de la méthode valeur() de la classe ActionSimple.
     * Vérifie si la méthode valeur() retourne correctement le cours de l'action pour un jour donné.
     */
    @Test
    void testValeur() {
    // Arrange
        ActionSimple actionSimple = new ActionSimple("ActionS","AnnotationS");
        Jour jour = new Jour(2024, 3);
        
        // Action : Enregistrement du cours de l'action pour la journée donnée
        // Définir le cours de l'action à 10
        actionSimple.enrgCours(jour, 10); 
        
        // Calcul de la valeur attendue
        // La valeur attendue est de 10 car nous avons défini le cours à 10
        float valeurAttendue = 10; 
        
        // Calcul de la valeur réelle
        float valeurObtenue = actionSimple.valeur(jour);
        
        // Assert
        assertEquals(valeurAttendue, valeurObtenue);  
    }    
    
    @Test
     void TestValeurReturnNull(){
         ActionSimple action1 = new ActionSimple("action1", "annotation1");
         Jour j = new Jour(2024, 1);
         
         Assertions.assertEquals(0.0f, action1.valeur(j));
     } 
}
