package com.betanunes.vinylshelf.controller;

import com.betanunes.vinylshelf.client.DiscogsClient;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VinylController {
    private final DiscogsClient discogsClient;
    public VinylController(DiscogsClient discogsClient) {
        this.discogsClient = discogsClient;
    }

    @GetMapping("/search")
    public ObjectNode search(@RequestParam("q") String query)  {
        return discogsClient.search(query, "master");
    }
}
