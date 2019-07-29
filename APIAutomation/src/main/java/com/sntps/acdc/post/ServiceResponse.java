package com.sntps.acdc.post;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Abstract parent for PackageSevice responses.
 */
public abstract class ServiceResponse 
{

    @JsonProperty(value = "id")
    private String id;

    /**
     * @param id
     *            Request ID from Package Service
     */
    public ServiceResponse(final String id) 
    {
        this.id = id;
    }

    /**
     * Default Constructor .
     */
    public ServiceResponse() 
    {}

    /**
     * @return the id.
     */
    public String getId() 
    {
        return id;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(final String id) 
    {
        this.id = id;
    }

}
