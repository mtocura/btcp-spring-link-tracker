package br.com.aula4.tm.linktracker.model.repository;

import br.com.aula4.tm.linktracker.model.entity.Link;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LinkRepository {
    private static List<Link> links = new ArrayList<>();

    public List<Link> getAll() {
        return links;
    }

    public Link getLinkById(long id) {
        Optional<Link> linkOptional = links.stream().filter(link -> link.getLinkID() == id).findAny();

        if(linkOptional.isPresent()) {
            return linkOptional.get();
        }

        return null;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void deleteLink(long id) {
        Optional<Link> linkOptional = links.stream().filter(link -> link.getLinkID() == id).findAny();

        if(linkOptional.isPresent()) {
            links.remove(linkOptional.get());
        }
    }
}
