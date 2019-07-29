package com.sntps.acdc.post;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * POJO representation of JSON request for file uploading.
 */
public class PackageServiceUnzipRequest extends GenericPostRequest 
{

    /**
     * Journal ID.
     */
    @JsonProperty(value = "journal_id")
    private long journalId;

    /**
     * Manuscript ID.
     */
    @JsonProperty(value = "manuscript_id")
    private String manuscriptId;

    /**
     * Revision number.
     */
    @JsonProperty(value = "revision")
    private int revision;

    /**
     * @return journal ID.
     */
    public long getJournalId() {
        return journalId;
    }

    /**
     * @return manuscript ID.
     */
    public String getManuscriptId() 
    {
        return manuscriptId;
    }

    /**
     * @return revision number.
     */
    public int getRevision() 
    {
        return revision;
    }

    @Override
    public String toString() 
    {
    			return "PackageServiceRequestJson [id="
                + getId()
                + ", journalId="
                + getJournalId()
                + ", manuscriptId="
                + getManuscriptId()
                + ", revision="
                + getRevision()
                + ", files="
                + getFiles()
                + "]";
    }

	public void setJournalId(long journalId) 
	{
		this.journalId = journalId;
	}

	public void setManuscriptId(String manuscriptId) 
	{
		this.manuscriptId = manuscriptId;
	}

	public void setRevision(int revision) 
	{
		this.revision = revision;
	}
	
}