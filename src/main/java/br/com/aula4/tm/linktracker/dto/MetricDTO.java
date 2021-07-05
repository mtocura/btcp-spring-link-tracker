package br.com.aula4.tm.linktracker.dto;

public class MetricDTO {
    private Long redirects;

    public MetricDTO() {
    }

    public MetricDTO(Long redirects) {
        this.redirects = redirects;
    }

    public Long getRedirects() {
        return redirects;
    }
}
