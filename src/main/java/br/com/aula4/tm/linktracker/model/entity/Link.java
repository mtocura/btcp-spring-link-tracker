package br.com.aula4.tm.linktracker.model.entity;

public class Link {
    private Long linkID;
    private Long redirects;
    private String url;
    private String token;

    public Link() {
    }

    public Link(Long linkID, Long redirects, String url, String token) {
        this.linkID = linkID;
        this.redirects = redirects;
        this.url = url;
        this.token = token;
    }

    public Long getLinkID() {
        return linkID;
    }

    public Long getRedirects() {
        return redirects;
    }

    public void setRedirects(Long redirects) {
        this.redirects = redirects;
    }

    public String getUrl() {
        return url;
    }

    public String getToken() {
        return token;
    }
}
