package com.sntps.acdc.post;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO representation of JSON containing file metadata.
 */
public class FileMetadata 
{

    @JsonProperty(value = "file_name")
    private String fileName;

    @JsonProperty(value = "file_type")
    private String fileType;

    /**
     * @return file name.
     */
    public String getFileName() 
    {
        return fileName;
    }

    /**
     * Set name of the file.
     * 
     * @param fileName
     *            Name of the file.
     */
    public void setFileName(final String fileName) 
    {
        this.fileName = fileName;
    }

    @Override
    public String toString() 
    {
        return "FileMetadata [fileName=" + fileName + ", fileType=" + fileType + "]";
    }

    /**
     * @return file type.
     */
    public String getFileType() 
    {
        return fileType;
    }

    /**
     * Set file type.
     * 
     * @param fileType
     *            Type of the file.
     */
    /*public void setFileType(final String fileType)*/
    public String setFileType(final String fileType)
    {
        return this.fileType = fileType;
    }
}
