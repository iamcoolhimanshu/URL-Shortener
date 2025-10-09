package Url.Shortener.URL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Url.Shortener.URL.entity.UrlMapping;
import java.util.Optional;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
	Optional<UrlMapping> findByShortUrl(String shortUrl);
}
