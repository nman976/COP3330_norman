import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {


        // This is a class called result. It calls for all the tests in FooTest too be run.
        // Nothing special, just goes through all tests in Test class
        Result result = JUnitCore.runClasses(FooTest2.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}