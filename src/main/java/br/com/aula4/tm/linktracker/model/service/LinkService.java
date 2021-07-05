package br.com.aula4.tm.linktracker.model.service;

import br.com.aula4.tm.linktracker.dto.LinkDTO;
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

    public long linkMetrics(long id) {
        Link link = linkRepository.getLinkById(id);

        return link.getRedirects();
    }

    public LinkDTO createLink(LinkForm linkForm) {
        Link link = LinkConverter.linkFormToEntity(linkForm);

        long redirects = link.getRedirects();
        link.setRedirects(redirects++);

        linkRepository.addLink(link);

        return LinkConverter.linkEntityToDTO(link);
    }

    public LinkDTO invalidateLink(long id) {
        return LinkConverter.linkEntityToDTO(linkRepository.deleteLink(id));
    }
}
