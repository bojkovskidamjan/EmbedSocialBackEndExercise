package damjan.bojkovski.embedsocial.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Review {
    private int id;
    private Object reviewId;
    private String reviewFullText;
    private String reviewText;
    private int numLikes;
    private int numComments;
    private int numShares;
    private int rating;
    private String reviewCreatedOn;
    private Date reviewCreatedOnDate;
    private Date reviewCreatedOnTime;
    private Object reviewerId;
    private Object reviewerUrl;
    private String reviewerName;
    private Object reviewerEmail;
    private String sourceType;
    private String isVerified;
    private String source;
    private String sourceName;
    private String sourceId;
    private List<Object> tags;
    private Object href;
    private Object logoHref;
    private List<Object> photos;

}