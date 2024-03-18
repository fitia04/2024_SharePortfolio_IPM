/*
 * Copyright 2024 David Navarre &lt;David.Navarre at irit.fr&gt;.
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

/**
 * Classe de test pour la classe {@link Portefeuille}.
 * <p>
 * Cette classe contient des tests unitaires pour les méthodes de la classe {@link Portefeuille}.</p>
 * 
 * @author David Navarre
 */
public class PortefeuilleTest { 
   
    /**
     * Test de la méthode {@link Portefeuille#acheter(Action, int)}.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#acheter(Action, int)} ajoute correctement une action au portefeuille.</p>
     */
    @Test
    public void testAcheter() {
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("Action1");
        int quantiteInitiale = 10;
        int quantiteAchat = 50;
        
        //Action
        portefeuille.acheter(actionSimple, quantiteInitiale);
        portefeuille.acheter(actionSimple, quantiteAchat);
        
        //Assert
       Map<Action, Portefeuille.LignePortefeuille> mapLignes = portefeuille.mapLignes;
       Assertions.assertTrue(mapLignes.containsKey(actionSimple));
    }
    
    /**
     * Test de la quantité après l'achat.
     * <p>
     * Ce test vérifie que la quantité d'une action dans le portefeuille est correcte
     * après l'achat de quantités supplémentaires.</p>
     */
    @Test
    public void testQuantiteAchete() {
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("Action1");
        int quantiteInitiale = 10;
        int quantiteAchat = 50;
        
        //Action
        portefeuille.acheter(actionSimple, quantiteInitiale);
        portefeuille.acheter(actionSimple, quantiteAchat);
        
        //Assert
        Map<Action, Portefeuille.LignePortefeuille> mapLignes = portefeuille.mapLignes;
        Portefeuille.LignePortefeuille lignePortefeuille = mapLignes.get(actionSimple);
        Assertions.assertEquals(quantiteInitiale + quantiteAchat, lignePortefeuille.getQte());
    }
  
    /**
     * Test de la méthode {@link Portefeuille#vendre(Action, int)}.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#vendre(Action, int)} soustrait correctement des quantités d'une action du portefeuille.</p>
     */
    @Test
    protected void testVendre() {
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionSimple action = new ActionSimple("Action1");
        int quantiteInitiale = 100;
        
        portefeuille.acheter(action, quantiteInitiale);
        //Action
        int quantite = 50;
        portefeuille.vendre(action, quantite);
        
        //Assert
        Map<Action, Portefeuille.LignePortefeuille> mapLignes = portefeuille.mapLignes;
        Assertions.assertTrue(mapLignes.containsKey(action));
        Portefeuille.LignePortefeuille lignePortefeuille = mapLignes.get(action);
        Assertions.assertEquals(quantiteInitiale - quantite, lignePortefeuille.getQte());
        
    }
    
    /**
     * Test de la suppression réussie d'une action du portefeuille.
     * <p>
     * Ce test vérifie qu'une action est supprimée avec succès du portefeuille.</p>
     */
    @Test
    protected void testDeleteSuccess() {
        // Arrange
        Portefeuille portefeuille = new Portefeuille();
        String libelle = "Action1";
        String lib = "Action2";
        ActionSimple AS1 = new ActionSimple(libelle);
        ActionComposee AC1 = new ActionComposee(lib);
        int quantiteInitiale = 100;
        portefeuille.acheter(AC1, quantiteInitiale);
        portefeuille.acheter(AS1, quantiteInitiale);

        // Action
        portefeuille.delete(AC1);

        // Assert
        Assertions.assertFalse(portefeuille.getMapLignes().containsKey(AC1), "Test echec");
        Assertions.assertTrue(portefeuille.getMapLignes().containsKey(AS1), "Test echec");   
       
    }
    
    /**
     * Test de recherche d'action.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#rechercherActionParNom(String)} recherche correctement une action dans le portefeuille.</p>
     */
    @Test
    protected void testResearch(){
        //Arrange 
        Portefeuille portefeuille = new Portefeuille();
        String libelle = "Action1";
        String lib = "Action2";
        ActionSimple AS1 = new ActionSimple(libelle);
        ActionComposee AC1 = new ActionComposee(lib);
        int quantiteInitiale = 100;
        portefeuille.acheter(AC1, quantiteInitiale);
        portefeuille.acheter(AS1, quantiteInitiale);

        //Action 
        portefeuille.rechercherActionParNom("Action1"); 
        //Assert 
       // Assertions.assert(portefeuille.rechercherActionParNom("Action1"), "Test echec");

}

}
