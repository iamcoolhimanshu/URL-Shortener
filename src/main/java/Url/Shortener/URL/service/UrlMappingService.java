package Url.Shortener.URL.service;

import org.springframework.stereotype.Service;

import Url.Shortener.URL.entity.UrlMapping;
import Url.Shortener.URL.repository.UrlMappingRepository;

import java.util.Optional;

@Service
public class UrlMappingService {

	private final UrlMappingRepository repository;
	private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public UrlMappingService(UrlMappingRepository repository) {
		this.repository = repository;
	}

	public UrlMapping shortenUrl(String longUrl) {
		UrlMapping mapping = UrlMapping.builder().longUrl(longUrl).shortUrl(generateShortUrl(longUrl.hashCode()))
				.clickCount(0).build();
		return repository.save(mapping);
	}

	public Optional<UrlMapping> getOriginalUrl(String shortUrl) {
		Optional<UrlMapping> mappingOpt = repository.findByShortUrl(shortUrl);
		mappingOpt.ifPresent(mapping -> {
			mapping.setClickCount(mapping.getClickCount() + 1);
			repository.save(mapping);
		});
		return mappingOpt;
	}

	private String generateShortUrl(int id) {
		StringBuilder sb = new StringBuilder();
		int num = Math.abs(id);
		while (num > 0) {
			sb.append(BASE62.charAt(num % 62));
			num /= 62;
		}
		return sb.reverse().toString();
	}
}
