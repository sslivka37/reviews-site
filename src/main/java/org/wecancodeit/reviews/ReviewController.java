package org.wecancodeit.reviews;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Controller
public class ReviewController {
	
	@Resource
	ReviewRepository reviewRepo;
	
	@RequestMapping("/show-reviews")
	public String findAllReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
		
	}
	
	
	@RequestMapping("/review")
	public String findOneReview(@RequestParam(value="id") Long id, Model model) {
		model.addAttribute("reviews", reviewRepo.findOne(id));
		return "review";
	}
	
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/"); 
    }

}
