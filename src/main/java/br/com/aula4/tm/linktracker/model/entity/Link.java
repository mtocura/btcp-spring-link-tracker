package br.com.aula4.tm.linktracker.model.entity;

public class Link {
    private Long linkID;
    private Long redirects;
    private String url;
    private String maskedUrl;

    public Link() {
    }

    public Link(Long linkID, Long redirects, String url, String maskedUrl) {
        this.linkID = linkID;
        this.redirects = redirects;
        this.url = url;
        this.maskedUrl = maskedUrl;
    }

    public Long getLinkID() {
        return linkID;
    }

    public Long getRedirects() {
        return redirects;
    }

    public String getUrl() {
        return url;
    }

    public String getMaskedUrl() {
        return maskedUrl;
    }
}
