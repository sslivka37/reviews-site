package org.wecancodeit.reviews;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;

public class ReviewRepositoryTest {
	
	ReviewRepository underTest;
	
	private long firstReviewId = 1L;
	private Review firstReview = new Review(firstReviewId, "review title",  "review category", "content", "url");
	
	private long secondReviewId = 2L;
	private Review secondReview = new Review(secondReviewId, "review title",  "review category", "content", "url");
	
	@Test
	public void should_Find_A_Review() {
		underTest = new ReviewRepository(firstReview);
		Review result = underTest.findOne(firstReviewId);
		assertThat(result, is(firstReview));
	}
	
	@Test
	public void should_Be_Able_To_Find_A_Second_Review() {
		underTest = new ReviewRepository(secondReview);
		Review result = underTest.findOne(secondReviewId);
		assertThat(result, is(secondReview));
	}
	
	@Test
	public void should_Find_All_Reviews() {
		underTest = new ReviewRepository(firstReview, secondReview);
		Collection<Review>result = underTest.findAll();
		assertEquals(2, result.size());
	}

}
