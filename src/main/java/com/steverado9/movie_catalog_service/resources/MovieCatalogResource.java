package com.steverado9.movie_catalog_service.resources;

import com.steverado9.movie_catalog_service.models.CatalogItem;
import com.steverado9.movie_catalog_service.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        RestTemplate restTemplate = new RestTemplate();

        //get all rated movie IDs
        //Hard coding rated movie IDs
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

        return ratings.stream().map(rating -> new CatalogItem("Transformers", "Test", 4))
                .toList();
        //For each movie ID, call movie info service and get details

        //Put them all together
    }
}
