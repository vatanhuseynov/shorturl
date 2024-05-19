package urlsh.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urlsh.example.demo.service.UrlService;

@RestController
@RequestMapping("/rest/url")

public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> createUrl(@RequestBody String longUrl){
        String shortUrl = urlService.saveUrl(longUrl);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<String> getLongUrl(@PathVariable String id){
        System.out.println(id);
        String longUr = urlService.findUrlByShorUrl(id);
        return ResponseEntity.status(HttpStatus.FOUND).header(HttpHeaders.LOCATION, longUr).build();
    }
}
