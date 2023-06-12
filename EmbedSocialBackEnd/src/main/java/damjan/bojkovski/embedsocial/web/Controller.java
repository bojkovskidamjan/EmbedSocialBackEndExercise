package damjan.bojkovski.embedsocial.web;


import damjan.bojkovski.embedsocial.model.Review;
import damjan.bojkovski.embedsocial.repository.ReviewRepository;
import damjan.bojkovski.embedsocial.service.impl.ReviewServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
    private final ReviewServiceImpl reviewService;
    private final ReviewRepository repository;

    public Controller(ReviewServiceImpl reviewService, ReviewRepository repository) {
        this.reviewService = reviewService;
        this.repository = repository;
    }

    @GetMapping("/reviews")
    public String getReviews(HttpServletRequest request, Model model) {
        List<Review> reviewsList = (List<Review>) request.getSession().getAttribute("reviews");

        if (reviewsList == null) {
            reviewsList = repository.findAllReviews();
            request.getSession().setAttribute("reviews", reviewsList);
        }

        model.addAttribute("reviews", reviewsList);
        return "home";
    }

    @PostMapping("/filter")
    public String filterReviews(@RequestParam int ratingValue,
                                @RequestParam int minimumRating,
                                @RequestParam int dateValue,
                                @RequestParam int textValue,
                                HttpServletRequest request) {
        List<Review> filteredReviews = (List<Review>) request.getSession().getAttribute("reviews");

        if (filteredReviews == null) {
            filteredReviews = repository.findAllReviews();
            request.getSession().setAttribute("reviews", filteredReviews);
        }

        filteredReviews = reviewService.minimumRating(minimumRating);
        filteredReviews = reviewService.sort(filteredReviews, textValue, ratingValue, dateValue);

        request.getSession().setAttribute("reviews", filteredReviews);
        return "redirect:/reviews";
    }
}