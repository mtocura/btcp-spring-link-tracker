package br.com.aula4.tm.linktracker.model.converter;

import br.com.aula4.tm.linktracker.dto.LinkDTO;
import br.com.aula4.tm.linktracker.form.LinkForm;
import br.com.aula4.tm.linktracker.model.entity.Link;
import br.com.aula4.tm.linktracker.utils.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LinkConverter {
    public static Link linkFormToEntity(LinkForm linkForm) {
        return new Link(
                Id.generateId(),
                0l,
                linkForm.getUrl(),
                maskURL(linkForm.getUrl())
        );
    }

    public static List<Link> linkFormToEntity(List<LinkForm> linkForms) {
        List<Link> links = new ArrayList<>();

        for (LinkForm linkForm : linkForms) {
            links.add(linkFormToEntity(linkForm));
        }

        return links;
    }

    public static LinkDTO linkEntityToDTO(Link link) {
        return new LinkDTO(
                link.getLinkID(),
                token()
        );
    }

    public static List<LinkDTO> linkEntityToDTO(List<Link> links) {
        List<LinkDTO> linkDTOS = new ArrayList<>();

        for (Link link : links) {
            linkDTOS.add(linkEntityToDTO(link));
        }

        return linkDTOS;
    }

    private static String maskURL(String url) {
        String encode = "abcdefghijklmnopqrstuvwxyz";
        int k = 6;

        char[] urlChar = url.toCharArray();

        StringBuilder maskedUrl = new StringBuilder();

        for(int i = 0; i < urlChar.length; i++) {
            int posChar = (encode.indexOf(urlChar[i]) + 1 + k) % 26;
            maskedUrl.append(encode.charAt(posChar - 1));
        }

        return maskedUrl.toString();
    }

    private static String token() {
        String encode = "abcdefghijklmnopqrstuvwxyz";
        String passDecoded = "senhasenhasenha";

        int min = 1;
        int max = 25;
        int range = max - min + 1;

        int k = (int) (Math.random() * range) + min;

        StringBuilder passEncoded = new StringBuilder();

        for(int i = 0; i < passDecoded.length(); i++) {
            int posChar = (encode.indexOf(passDecoded.charAt(i)) + 1 + k) % 26;
            passEncoded.append(encode.charAt(posChar - 1));
        }

        return passEncoded.toString();
    }
}
