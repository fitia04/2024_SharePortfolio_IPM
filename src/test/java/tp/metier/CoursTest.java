/*
 * Copyright 2024 Fitia.
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

/**
 *
 * @author Fitia
 */
 class CoursTest {
     
    @Test
    void testGetJour() {
        // Arrange
        final Jour jourAttendu = new Jour(2024, 79); // Création d'un objet Jour attendu
        final Cours cours = new Cours(jourAttendu, 50.0f);

        // Action
        final Jour jourObtenu = cours.getJour();

        // Assert
        Assertions.assertEquals(jourAttendu, jourObtenu, "Vérification de la méthode getJour()");
    }

    @Test
    void testToString() {
        // Arrange
        final Jour jour = new Jour(2024, 79); // Création d'un objet Jour
        final float valeur = 50.0f;
        final Cours cours = new Cours(jour, valeur);

        // Action
        final String expectedToString = "Cours{" + "jour=" + jour + ", valeur=" + valeur + '}';
        final String currentToString = cours.toString();

        // Assert
        Assertions.assertEquals(expectedToString, currentToString, "Vérification de la méthode toString()");
    }
}
