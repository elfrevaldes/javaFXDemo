/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Test.Application;

import javafxdemo.Application.Product;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Elfre
 */
public class ProductTest {
    
    public ProductTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void productNameTest() {
         Product one = new Product();
         one.setName("Completo");
         
         // if I try to get the name it better be the same I name it
         //               thing to test    espected value
         Assert.assertEquals(one.getName(), "Completo", 
                 "Message: Name was not the same as in the class");
         
         one.setName("Barros luco");
         
         Assert.assertEquals(one.getName(), "Barros luco", 
                 "Failed while changing the name");
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
