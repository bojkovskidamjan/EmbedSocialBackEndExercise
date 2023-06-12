package damjan.bojkovski.embedsocial.repository;

import damjan.bojkovski.embedsocial.dataHolder.DataHolder;
import damjan.bojkovski.embedsocial.model.Review;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepository {
    public List<Review> findAllReviews(){ return DataHolder.getReviews(); }
}