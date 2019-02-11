package org.wecancodeit.reviews;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Collection;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;


@RunWith (SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMVCTest {
	
	@Resource
	private MockMvc mvc;
	
	
	@Mock
	private Review firstReview;
	
	@Mock
	private Review secondReview;
	
	@MockBean
	private ReviewRepository repository;
	
	@Test
	public void should_Be_Ok_For_All_Reviews() throws Exception{
		mvc.perform(get("/show-reviews")).andExpect(status().isOk());
	}
	
	@Test
	public void should_Route_To_All_Reviews() throws Exception {
		mvc.perform(get("/show-reviews")).andExpect(view().name(is ("reviews")));
	}
	
	@Test
	public void should_Put_All_Reviews_Into_Model() throws Exception {
		Collection<Review> allReviews = asList(firstReview, secondReview);
		when(repository.findAll()).thenReturn(allReviews);
		mvc.perform(get("/show-reviews")).andExpect(model().attribute("reviews", is(allReviews)));
	}
	
	
	@Test
	public void should_Be_Ok_For_Single_Review() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(status().isOk());
	}
	
	
	@Test
	public void should_Route_To_Single_Review() throws Exception {
		mvc.perform(get("/review?id=1")).andExpect(view().name(is("review")));
	}
	
	@Test
	public void should_Put_Single_Review_Into_Model() throws Exception{
		when(repository.findOne(1L)).thenReturn(firstReview);
		mvc.perform(get("/review?id=1")).andExpect(model().attribute("reviews", is(firstReview)));
	}
	
	
	
	
	
	
	
	
	

}
