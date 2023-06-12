package damjan.bojkovski.embedsocial.dataHolder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import damjan.bojkovski.embedsocial.model.Review;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataHolder {
    private static List<Review> reviews;

    static {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("reviews.json");
            InputStream inputStream = resource.getInputStream();
            reviews = objectMapper.readValue(inputStream, new TypeReference<List<Review>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read reviews.json file.", e);
        }
    }

    public static List<Review> getReviews() {
        return reviews;
    }
}
