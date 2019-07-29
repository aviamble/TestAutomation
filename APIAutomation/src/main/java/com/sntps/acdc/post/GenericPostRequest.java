package com.sntps.acdc.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author generic Post Request JSON for services
 */
//@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)

public class GenericPostRequest extends ServiceRequest
{

    @JsonProperty(value = "files")
    private List<FileMetadata> files;

    /**
     * @return List of Files
     */
    public List<FileMetadata> getFiles() 
    {
        return files;
    }

    /**o
     * @param files
     *            List of files
     */
    public void setFiles(final List<FileMetadata> files) 
    {
        this.files = files;
    }

}
