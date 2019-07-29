package com.sntps.acdc.post;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO representation of error JSON response for PackageService.
 */
public class PackageServiceErrorResponse extends ServiceResponse 
{

    /**
     * @param id
     *            Request ID from Package Service
     */
    public PackageServiceErrorResponse(final String id) 
    {
        super(id);
    }

    /**
     * @param id
     *            Request ID from Package Service
     * @param error
     *            error mesaage
     */
    public PackageServiceErrorResponse(final String id, final String error) 
    {
        super(id);
        this.error = error;
    }

    /**
     * Default Constructor .
     */
    public PackageServiceErrorResponse() 
    {
        super();
    }

    @JsonProperty(value = "error")
    private String error;

    /**
     * @return the error.
     */
    public String getError() 
    {
        return error;
    }

    /**
     * @param error
     *            The error to set.
     */
    public void setError(final String error) 
    {
        this.error = error;
    }
}
