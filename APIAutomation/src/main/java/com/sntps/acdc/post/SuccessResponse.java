package com.sntps.acdc.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO representation of successful JSON response containing list of URI's.
 */
public class SuccessResponse extends ServiceResponse 
{

    @JsonProperty(value = "_links")
    private List<URIMetadata> links;

    /**
     * @return list of URI's for the files.
     */
    public List<URIMetadata> getLinks() 
    {
        if (links == null) 
        {
            links = new ArrayList<>();
        }
        return links;
    }

    /**
     * Set the list of URI's for the files.
     * 
     * @param links
     *            List of URI metadata for the files.
     */
    public void setLinks(final List<URIMetadata> links) 
    {
        this.links.addAll(links);
    }

}
