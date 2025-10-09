package Url.Shortener.URL.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import Url.Shortener.URL.entity.UrlMapping;
import Url.Shortener.URL.service.UrlMappingService;

@RestController
@RequestMapping("/api/url")
public class UrlMappingController {

	private final UrlMappingService service;

	public UrlMappingController(UrlMappingService service) {
		this.service = service;
	}

	@PostMapping("/shorten")
	public ResponseEntity<UrlMapping> shortenUrl(@RequestParam String longUrl) {
		return ResponseEntity.ok(service.shortenUrl(longUrl));
	}

	@GetMapping("/{shortUrl}")
	public RedirectView redirectToOriginal(@PathVariable String shortUrl) {
		return service.getOriginalUrl(shortUrl).map(mapping -> new RedirectView(mapping.getLongUrl()))
				.orElse(new RedirectView("/not-found"));
	}
}
