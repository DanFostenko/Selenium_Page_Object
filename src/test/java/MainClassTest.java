import org.junit.*;

public class MainClassTest {

/*    @BeforeClass //run once beforeClassMethod marked by BeforeClass annotation before execution of all methods
    public void beforeClassMethod() { }

    @Before //run setUp marked by Before annotation before execution of each test method
    public void setUpMethod() { }

    @Test //Test annotation points to test method
    public void method1() {
        Assert.assertTrue(1 + 1 == 2); //returns boolean from condition
        Assert.assertFalse(1 + 1 == 10); //returns boolean from condition
    }

    @Test //Test annotation points to test method
    @Ignore //Marked test won't be executed
    public void method2() {
        Assert.assertNull();
        Assert.assertNotNull();
    }

    @Test //Test annotation points to test method
    public void method3() {
        Assert.assertEquals(10,5 + 5); //validates whether values are equal
        Assert.assertNotEquals(10,2 + 2); //validates whether values are not equal
    }

    @After //run tearDownMethod marked by After annotation after execution of each test method
    public void tearDownMethod() { }

    @AfterClass //run once afterClassMethod marked by AfterClass annotation after execution of all test methods
    public void afterClassMethod() { }
    *//* the order of method execution:
    1) beforeClassMethod
    2) setUpMethod
    3) method1
    4) tearDownMethod
    5) setUpMethod
    6) method3
    7) tearDownMethod
    8) afterClassMethod *//*
    */

    @Test //Test annotation points to test method
    public void method1() {
        Assert.assertTrue("Values are not equal",1 + 1 == 2);
    }
    @Test //Test annotation points to test method
    public void method2() {
        Assert.assertEquals(20,5 + 5);
    }
    @Test //Test annotation points to test method
    public void method3() {
        Assert.assertFalse("Values are equal",1 + 1 == 2);
    }
    @Test //Test annotation points to test method
    public void method4() {
        Assert.assertNotEquals(20,5 + 5);
    }
}
