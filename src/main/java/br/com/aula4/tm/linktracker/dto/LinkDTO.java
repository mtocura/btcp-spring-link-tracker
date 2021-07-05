package br.com.aula4.tm.linktracker.dto;

public class LinkDTO {
    private Long linkId;
    private String token;

    public LinkDTO() {
    }

    public LinkDTO(Long linkId, String token) {
        this.linkId = linkId;
        this.token = token;
    }

    public Long getLinkId() {
        return linkId;
    }

    public String getToken() {
        return token;
    }
}
