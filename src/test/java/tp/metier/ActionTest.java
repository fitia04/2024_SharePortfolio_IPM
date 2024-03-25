/*
 * Copyright 2024 Noé .
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
import org.junit.jupiter.api.Assertions;
/**
 *
 * @author 33761
 */
public class ActionTest {
    @Test
    public void testActionEquals(){
        //Arrange
        ActionSimple action1 = new ActionSimple("action1");
        ActionSimple action1bis = new ActionSimple("action1");
        ActionSimple action2 = new ActionSimple("action2");
        ActionComposee actionComposee1 = new ActionComposee("action3");
        
        //Assert
        Assertions.assertFalse(action1.equals(action2));
        Assertions.assertFalse(action1.equals(null));
        Assertions.assertFalse(action1.equals(actionComposee1));
        Assertions.assertTrue(action1.equals(action1bis));
        
    }
    
    @Test
    public void testActionToString(){
        ActionSimple action1 = new ActionSimple("action1");
        String actionLibelle = "action1";
        
        Assertions.assertEquals(action1.toString(), actionLibelle);
    }
}
