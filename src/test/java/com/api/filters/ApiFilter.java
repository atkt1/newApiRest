package com.api.filters;

import com.api.reports.ExtentReportsManager;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiFilter implements Filter {
    Logger logger = LogManager.getLogger(ApiFilter.class);
    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response rs = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        logResponse(rs);
        return rs;
    }

    public void logRequest(FilterableRequestSpecification filterableRequestSpecification){
        logger.info("BASE_URL: " + filterableRequestSpecification.getBasePath());
        logger.info("Request Headers" + filterableRequestSpecification.getHeaders());
        ExtentReportsManager.logRequest(filterableRequestSpecification);
    }


    public void logResponse(Response rs){
        logger.info("BASE_URL: " + rs.getStatusCode());
        logger.info("Response Headers" + rs.getHeaders());
        ExtentReportsManager.logRsponse(rs);
    }
}
