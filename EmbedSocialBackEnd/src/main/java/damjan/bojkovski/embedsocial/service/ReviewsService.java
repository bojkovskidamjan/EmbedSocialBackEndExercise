package damjan.bojkovski.embedsocial.service;

import damjan.bojkovski.embedsocial.model.Review;

import java.util.List;

public interface ReviewsService {

    List<Review> minimumRating(int num);
    List<Review> sort(List<Review> reviews, int text, int rating, int date);
    }

