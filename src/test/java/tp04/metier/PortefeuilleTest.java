
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
package tp04.metier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class PortefeuilleTest { 
   
    @Test
    public void testAcheter() {
    
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("Action1","annot1");
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
        ActionSimple actionSimple = new ActionSimple("Action1","Annot1");
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
    protected void testVendrePartiel() {
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionSimple action = new ActionSimple("Action1","Annot1");
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
        protected void testVendreTotal() {
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionSimple action = new ActionSimple("Action1","Annot1");
        int quantiteInitiale = 100;
        
        portefeuille.acheter(action, quantiteInitiale);
        //Action
        int quantite = 100;
        portefeuille.vendre(action, quantite);
        
        //Assert
        Map<Action, Portefeuille.LignePortefeuille> mapLignes = portefeuille.mapLignes;
        Assertions.assertFalse(mapLignes.containsKey(action));
        
    }
    
    @Test
    protected void testDeleteSuccess() {
        // Arrange
        Portefeuille portefeuille = new Portefeuille();
        String libelle = "Action1";
        String lib = "Action2";
        String annotation = "Annotation1";
        String annot = "Annotation2";
        ActionSimple AS1 = new ActionSimple(libelle,annotation);
        ActionComposee AC1 = new ActionComposee(lib,annot);
        int quantiteInitiale = 100;
        portefeuille.acheter(AC1, quantiteInitiale);
        portefeuille.acheter(AS1, quantiteInitiale);

        // Action
        portefeuille.delete(AC1);

        // Assert
        Assertions.assertFalse(portefeuille.getMapLignes().containsKey(AC1), "Test echec");
        Assertions.assertTrue(portefeuille.getMapLignes().containsKey(AS1), "Test echec");   
    }

    @Test
    protected void testVisualiserActions(){
        
        //Arrange
        Portefeuille portefeuille1 = new Portefeuille();
        
        ActionSimple action1 = new ActionSimple("act1","annot1");
        ActionSimple action2 = new ActionSimple("act2","annot2");
        ActionSimple action3 = new ActionSimple("act3","annot3");
            
        HashMap<ActionSimple, Integer> maMap = new HashMap<>();
        maMap.put(action1, 10);
        maMap.put(action2, 30);
        maMap.put(action3, 40);
            
        ArrayList<ActionSimple> listActionTest = new ArrayList<ActionSimple>();
        listActionTest.add(action2);
        listActionTest.add(action1);
        listActionTest.add(action3);
        
        //Action
        ArrayList<ActionSimple> result = portefeuille1.VisualiserActions(maMap);
        
        //Assert
        Assertions.assertEquals(listActionTest,result);
        }
    
    @Test
    protected void visualiserAnnotationPortefeuille(){
        //Arrange
        ActionSimple action1 = new ActionSimple("act1","annot1");
        ActionSimple action2 = new ActionSimple("act2","annot2");
        
        ArrayList<String> listAnnotations = new ArrayList<String>();
        listAnnotations.add(action2.getAnnotation());
        listAnnotations.add(action1.getAnnotation());

        
        Portefeuille portefeuille1 = new Portefeuille();
        portefeuille1.acheter(action2, 10);
        portefeuille1.acheter(action1, 30);
        
        //Action
        ArrayList<String> result = portefeuille1.visualiserAnnotationPortefeuille(portefeuille1); 

        //Assert
        Assertions.assertEquals(listAnnotations,result);
        }   
    }
