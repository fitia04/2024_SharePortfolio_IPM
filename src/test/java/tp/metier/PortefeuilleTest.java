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

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

/**
 * Classe de test pour la classe {@link Portefeuille}.
 * <p>
 * Cette classe contient des tests unitaires pour les méthodes de la classe {@link Portefeuille}.</p>
 * 
 * @author Noe, Alexandre, Yasmine, Fitia, Larissa, Tidiane, Nam An
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
    
    /**
     * Test de la quantité après l'achat.
     * <p>
     * Ce test vérifie que la quantité d'une action dans le portefeuille est correcte
     * après l'achat de quantités supplémentaires.</p>
     */
    @Test
    void testQuantiteAchete() {
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("Action1","annotation1");
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
     * Test de la méthode {@link Portefeuille#vendrePartiel(Action, int)}.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#vendre(Action, int)} soustrait correctement des quantités d'une action du portefeuille non vide.</p>
     */
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
        
        //Asserts
        Map<Action,Portefeuille.LignePortefeuille> mapLignes = portefeuille.mapLignes;
        Assertions.assertTrue(mapLignes.containsKey(action));
        Portefeuille.LignePortefeuille lignePortefeuille = mapLignes.get(action);
        Assertions.assertEquals(quantiteInitiale - quantite, lignePortefeuille.getQte());
        
    }
    
         /**
     * Test de la méthode {@link Portefeuille#vendrePartiel(Action, int)}.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#vendre(Action, int)} soustrait correctement des quantités d'une action du portefeuille vide.</p>
     */
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
        Map<Action,Portefeuille.LignePortefeuille> mapLignes = portefeuille.mapLignes;
        Assertions.assertFalse(mapLignes.containsKey(action));
        
    }

    
    /**
     * Test de la suppression réussie d'une action du portefeuille.
     * <p>
     * Ce test vérifie qu'une action est supprimée avec succès du portefeuille.</p>
     */
    @Test
    void testDeleteSuccess() {
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
    
    
    /**
     * Test de la méthode {@link Portefeuille#visualiserActions(HashMap<ActionSimple,Integer> ActionDispo)}.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#visualiserActions(HashMap<ActionSimple,Integer> ActionDispo)} permette une visualisation correcte des actions dun portefeuille</p>
     */
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
        ArrayList<ActionSimple> result = portefeuille1.visualiserActions(maMap);
        
        //Assert
        Assertions.assertEquals(listActionTest,result);
        }
    
     /**
     * Test de la méthode {@link Portefeuille#visualiserAnnotationPortefeuille(Portefeuille portefeuille)}.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#visualiserAnnotationPortefeuille(Portefeuille portefeuille)} permette une visualisation des annotations de toutes les actions du portefeuille</p>
     */
    @Test
    protected void testVisualiserAnnotationPortefeuille(){
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
    
    /**
     * Test de recherche d'action.
     * <p>
     * Ce test vérifie que la méthode {@link Portefeuille#rechercherActionParNom(String)} recherche correctement une action dans le portefeuille.</p>
     */
    @Test
    void testResearch(){
        //Arrange 
        Portefeuille portefeuille = new Portefeuille();
        String libelle = "Action1";
        String lib = "Action2";
        String annotation = "annotation1";
        String annot = "annotation2";
        ActionSimple AS1 = new ActionSimple(libelle,annotation);
        ActionComposee AC1 = new ActionComposee(lib,annot);
        int quantiteInitiale = 100;
        portefeuille.acheter(AC1, quantiteInitiale);
        portefeuille.acheter(AS1, quantiteInitiale);

        //Action 
        portefeuille.rechercherActionParNom("Action1"); 
        //Assert 
       // Assertions.assert(portefeuille.rechercherActionParNom("Action1"), "Test echec");

      
}
    
    /**
     * Ce test vérifie que la méthode connectToWallet marche bien et si la connection a abouti ou pas. 
     */
    @Test 
    void testConnectWalletIdMdpSuccess(){
        //Arrange
        Portefeuille p2 = new Portefeuille(); 
        
        p2.identification.put("Nam An", "1234"); 
        p2.identification.put("Dem", "mdp"); 
        String id = "Nam An"; 
        String mdp = "1234";
       
        //Action
       p2.connectToWallet(id, mdp);
        
        //Assert
       Assertions.assertTrue(p2.connectToWallet(id, mdp), "La connexion n'a pas abouti");   
    }
    
    /**
     * Ce test vérifie que la méthode connectToWallet marche bien et si si le MDP est incrorrect. 
     */
    @Test 
    void testConnectWalletIdMdpFailMdp(){
        //Arrange
        Portefeuille p2 = new Portefeuille(); 
        
        p2.identification.put("Nam An", "1234"); 
        p2.identification.put("Dem", "mdp"); 
        String id = "Nam An"; 
        String mdp = "AXY";
       
        //Action
       p2.connectToWallet(id, mdp);
        
        //Assert
       Assertions.assertFalse(p2.connectToWallet(id, mdp), "Le mdp est correcte");   
    }
    
    /**
     * Ce test vérifie que la méthode connectToWallet marche bien et si l'ID est incrorrect  
     */
    @Test 
    void testConnectWalletIdMdpFailId(){
        //Arrange
        Portefeuille p2 = new Portefeuille(); 
        
        p2.identification.put("Nam An", "1234"); 
        p2.identification.put("Dem", "mdp"); 
        String id = "Nam"; 
        String mdp = "1234";
       
        //Action
       p2.connectToWallet(id, mdp);
        
        //Assert
       Assertions.assertFalse(p2.connectToWallet(id, mdp), "L'ID est correct");   
    }
    
    /**
     * Ce test vérifie que la méthode createUser marche bien et refuse d'ajouter un nouveau utilisateur
     * @author Nam An
     * @param id, mdp
     * @return boolean
     */
    @Test 
    void testCreateUserFail(){
        //Arrange
        Portefeuille p2 = new Portefeuille(); 
        
        p2.identification.put("Nam An", "1234"); 
        p2.identification.put("Dem", "mdp"); 
        String id = "Nam An"; 
        String mdp = "HELLO";
       
        //Action
        boolean result = p2.createUser(id, mdp);

        
        //Assert
       Assertions.assertFalse(result, "Compte créé");   
    }
    
    /**
     * Ce test vérifie que la méthode createUser marche bien et accepte d'ajouter un nouveau utilisateur
     * @author Nam An
     * @param id, mdp
     * @return boolean
     */
    @Test 
    void testCreateUserSuccess(){
        //Arrange
        Portefeuille p2 = new Portefeuille(); 

        p2.identification.put("Nam An", "1234"); 
        p2.identification.put("Dem", "mdp"); 
        String id = "Larissa"; 
        String mdp = "HELLO";

        //Action
        boolean result = p2.createUser(id, mdp);

        //Assert
        Assertions.assertTrue(result, "Compte pas créé");   
    }
    
   
}
