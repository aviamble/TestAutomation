package com.sntps.acdc.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.restassured.http.ContentType;



/**
 * URI link and other file metadata.
 */

//@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class URIMetadata 
{

    /**
     * @param rel
     *            rel
     * @param href
     *            href
     * @param method
     *            http method
     * @param accept
     *            accept header
     */
    public URIMetadata
    (
      final String rel,
      final String href,
      final String method,
      final String accept
    ) 
    
    {
        super();
        this.rel = rel;
        this.href = href;
        this.method = method;
        this.accept = accept;
    }

    /**
     * @param rel
     *            rel
     * @param href
     *            href
     * @param method
     *            http method
     */
    public URIMetadata(final String rel, final String href, final String method) 
    {
        super();
        this.rel = rel;
        this.href = href;
        this.method = method;
    }

    /**
     * default cons.
     */
    public URIMetadata() 
    {
        super();
    }

    @JsonProperty(value = "rel")
    private String rel;

    @JsonProperty(value = "href")
    private String href;

    @JsonProperty(value = "method")

    private String method;

    @JsonProperty(value = "accept")
    private String accept;

    /**
     * @return rel.
     */
    public String getRel() 
    {
        return rel;
    }

    /**
     * Set the rel.
     * 
     * @param rel
     *            The rel.
     */
    public void setRel(final String rel) 
    {
        this.rel = rel;
    }

    /**
     * @return URI href.
     */
    public String getHref() 
    {
        return href;
    }

    /**
     * Set the URI href.
     * 
     * @param href
     *            The URI href to set.
     */
    public void setHref(final String href) 
    {
        this.href = href;
    }

    /**
     * @return method name.
     */
    public String getMethod() 
    {
        return method;
    }

    /**
     * Set the HTTP method name.
     * 
     * @param method
     *            Method name.
     */
    public void setMethod(final String method) 
    {
        this.method = method;
    }

    /**
     * @return accept schema name.
     */
    public String getAccept() 
    {
        return accept;
    }

    /**
     * Set the accept schema name.
     * 
     * @param accept
     *            The accept schema name.
     */
    public void setAccept(final String accept) 
    {
        this.accept = accept;
    }

}
