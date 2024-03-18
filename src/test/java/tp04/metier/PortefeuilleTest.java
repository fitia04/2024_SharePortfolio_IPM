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

import org.junit.jupiter.api.Assertions;

/**
 *
 * @author 33761
 */
public class PortefeuilleTest {
    protected void testVendre() {
        //Arrange
        Portefeuille portefeuille = new Portefeuille();
        ActionComposee action = new ActionComposee("Action1");
        int quantiteInitiale = 100;
        
        portefeuille.acheter(action, quantiteInitiale);
        //Action
        
        int quantite = 50;
        portefeuille.vendre(action, quantite);
        
        //Assert
    }
}
