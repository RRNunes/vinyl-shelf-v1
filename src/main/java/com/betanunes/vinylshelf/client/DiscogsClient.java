package com.betanunes.vinylshelf.client;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "discogs", url = "https://api.discogs.com/database/")
public interface DiscogsClient {

    @RequestMapping(method = RequestMethod.GET, value = "/search",
        headers = "Authorization=Discogs key=${discogs.key}, secret=${discogs.secret}"
    )
    ObjectNode search(
        @RequestParam("q") String query,
        @RequestParam("type") String type,
        @RequestParam("page") int page,
        @RequestParam("per_page") int perPage
    );
}
