package br.com.aula4.tm.linktracker.model.service;

import br.com.aula4.tm.linktracker.dto.LinkDTO;
import br.com.aula4.tm.linktracker.exception.InvalidLinkException;
import br.com.aula4.tm.linktracker.form.LinkForm;
import br.com.aula4.tm.linktracker.model.converter.LinkConverter;
import br.com.aula4.tm.linktracker.model.entity.Link;
import br.com.aula4.tm.linktracker.model.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService {

    private LinkRepository linkRepository;

    public LinkService() {
    }

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public String redirectTo(long id, String token) {
        Link link = linkRepository.getLinkById(id);

        if(link == null || token == null || token == "" || !link.getToken().equals(token)) {
            throw new InvalidLinkException("Link inválido!");
        }

        long redirects = 1l;
        redirects += link.getRedirects();
        link.setRedirects(redirects);

        return link.getUrl();
    }

    public long linkMetrics(long id) {
        Link link = linkRepository.getLinkById(id);

        if(link == null) {
            throw new InvalidLinkException("Link inválido!");
        }

        return link.getRedirects();
    }

    public LinkDTO createLink(LinkForm linkForm) {
        Link link = LinkConverter.linkFormToEntity(linkForm);

        linkRepository.addLink(link);

        return LinkConverter.linkEntityToDTO(link);
    }

    public LinkDTO invalidateLink(long id) {
        Link link = linkRepository.deleteLink(id);

        if(link == null) {
            throw new InvalidLinkException("Link inválido!");
        }

        return LinkConverter.linkEntityToDTO(link);
    }
}
