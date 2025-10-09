package Url.Shortener.URL.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 2048)
	private String longUrl;

	@Column(nullable = false, unique = true)
	private String shortUrl;

	private int clickCount = 0;
}
