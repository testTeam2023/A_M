package khademStore.utils;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CustomerReport implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Customize the report generation logic
        StringBuilder htmlReport = new StringBuilder("<html><body><h1>TestNG Results</h1>");

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> results = suite.getResults();
            for (ISuiteResult suiteResult : results.values()) {
                ITestContext context = suiteResult.getTestContext();
                htmlReport.append("<h2>").append(context.getName()).append("</h2>");
                htmlReport.append("<p>Passed tests: ").append(context.getPassedTests().getAllResults().size()).append("</p>");
                htmlReport.append("<p>Failed tests: ").append(context.getFailedTests().getAllResults().size()).append("</p>");
            }
        }

        htmlReport.append("</body></html>");

        // Write HTML report to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputDirectory + "test-report.html"))) {

            writer.write(htmlReport.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
