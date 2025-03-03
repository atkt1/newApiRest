package com.api.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportsManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test =  new ThreadLocal<ExtentTest>();

    public static ExtentReports getReportsInstance(){
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("results/" + generateFileName());
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setDocumentTitle("Test RESULTS");
            sparkReporter.config().setReportName("API Tests");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("User", "KT");
            extent.setSystemInfo("Environment", "UAT1");
        }
        return extent;
    }

    private static String generateFileName(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-mm-dd_HH-mm-ss");
        return "TestExecutionResults-" + format.format(LocalDateTime.now()) + ".html";
    }

    public static void logRequest(FilterableRequestSpecification request){
        StringBuilder requestDetails = new StringBuilder();
        requestDetails.append("<pre>");
        requestDetails.append("Request Method : " + request.getMethod() + "\n");
        requestDetails.append("Request URL : " + request.getURI() + "\n");
        requestDetails.append("Request Headers : " + "\n");

        request.getHeaders().forEach(e -> {
            requestDetails.append(e.getName() + " : " + e.getValue() + "\n");
        });

        if(request.getBody()!=null){
            requestDetails.append("Request Body : " + request.getBody() + "\n");
        }

        requestDetails.append("</pre>");


        test.get().log(Status.INFO, "Request Detail : " + requestDetails.toString());

    }

    public static void logRsponse(Response response){
        StringBuilder requestDetails = new StringBuilder();
        requestDetails.append("<pre>");
        requestDetails.append("Status COde : " + response.getStatusCode() + "\n");
        requestDetails.append("Request Headers : " + "\n");

        response.getHeaders().forEach(e -> {
            requestDetails.append(e.getName() + " : " + e.getValue() + "\n");
        });

        if(response.getBody()!=null){
            requestDetails.append("Request Body : " + response.getBody().prettyPrint() + "\n");
        }

        requestDetails.append("</pre>");


        test.get().log(Status.INFO, "Request Detail : " + requestDetails.toString());

    }

    public static void startTest(String testName){
        ExtentTest extentTest = getReportsInstance().createTest(testName);
        test.set(extentTest);
    }

    public static void endTest(){
        if(test.get() != null){
            extent.flush();
        }
    }

    public static ExtentTest getTest(){
        return test.get();
    }
}
