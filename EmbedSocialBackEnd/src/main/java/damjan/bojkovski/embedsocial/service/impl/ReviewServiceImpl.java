package damjan.bojkovski.embedsocial.service.impl;


import damjan.bojkovski.embedsocial.model.Review;
import damjan.bojkovski.embedsocial.repository.ReviewRepository;
import damjan.bojkovski.embedsocial.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewsService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public List<Review> minimumRating(int num) {
        return reviewRepository.findAllReviews().stream().filter(x-> x.getRating() >= num).collect(Collectors.toList());
    }

    @Override
    public List<Review> sort(List<Review> reviews, int text, int rating, int date) {
        if(text == 1 && rating == 1 && date == 1) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating).reversed())
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 1 && rating == 1 && date == 0) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating).reversed())
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        if(text == 1 && rating == 0 && date == 1) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating))
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 1 && rating == 0 && date == 0) {
            Comparator<Review> compare = Comparator.comparing((Review review) -> review.getReviewFullText().isEmpty())
                    .thenComparing(Comparator.comparing(Review::getRating))
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        if(text == 0 && rating == 0 && date == 1) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating)
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 0 && rating == 0 && date == 0) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating)
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        if(text == 0 && rating == 1 && date == 1) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating).reversed()
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate));
            reviews.sort(compare);
        }
        if(text == 0 && rating == 1 && date == 0) {
            Comparator<Review> compare = Comparator.comparing(Review::getRating).reversed()
                    .thenComparing(Comparator.comparing(Review::getReviewCreatedOnDate).reversed());
            reviews.sort(compare);
        }
        return reviews;
    }
}

