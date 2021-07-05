package br.com.aula4.tm.linktracker.dto;

public class LinkDTO {
    private Long linkId;

    public LinkDTO() {
    }

    public LinkDTO(Long linkId) {
        this.linkId = linkId;
    }

    public Long getLinkId() {
        return linkId;
    }
}
