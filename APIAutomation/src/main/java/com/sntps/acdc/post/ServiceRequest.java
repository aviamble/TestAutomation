package com.sntps.acdc.post;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO representation of JSON request for file uploading.
 */
public abstract class ServiceRequest 
{

    /**
     * Request id.
     */
    @JsonProperty(value = "id")
    private String id;

    /**
     * @return package id.
     */
    public String getId() 
    {
        return id;
    }

    /**
     * Set the ID.
     * 
     * @param id
     *            Request ID.
     */
    public void setId(final String id) 
    {
        this.id = id;
    }
}
