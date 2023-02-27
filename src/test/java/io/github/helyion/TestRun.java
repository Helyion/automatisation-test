package io.github.helyion;

public class TestRun {
    private static TestConnextionTest test = new TestConnextionTest();

    public static void main(String[] args) {
        test.testLoginErrorFormatMail();
        test.testDeConnexion();
    }
}
