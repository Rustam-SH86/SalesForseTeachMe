package tests;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.printf("======================================== STARTING TEST %s ========================================%n",
                iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.printf("======================================== FINISHED TEST %s Duration: %ss ========================================%n",
                iTestResult.getName(), getExecutionTime(iTestResult));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.printf("======================================== SKIPPING TEST %s ========================================%n", iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("Test suite started");
    }
    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
}
