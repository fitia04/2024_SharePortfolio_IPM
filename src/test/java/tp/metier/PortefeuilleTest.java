
/*
 * Copyright 2024 33761.
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

import tp.metier.ActionSimple;
import tp.metier.Action;
import tp.metier.Portefeuille;
import tp.metier.ActionComposee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

public class PortefeuilleTest { 
   
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

}
