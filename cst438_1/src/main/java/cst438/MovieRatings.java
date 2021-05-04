package cst438;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieRatings {
	
	@Autowired
	MovieRatingRepository movieRatingRepository; 
	
	//This is a test
	@GetMapping("/movies")
	public String getAllMovieRatings(Model model) {
		Iterable<MovieRating> movieRating = 
				movieRatingRepository.findAllMovieRatingOrderByMovieTitleCreationDateTimeDesc();
		model.addAttribute("movieRating", movieRating);
		return "movie_ratings_list";
	}	
	
	//This is a test
	@PostMapping("/movies/new")
	public String processMovieRatingForm(@Valid MovieRating movieRating,
			BindingResult result,
			Model model) {
		if(result.hasErrors()) {
			return "movie_rating_form";
		}
		movieRating.setCreationDateTime(new java.util.Date().toString());
		movieRatingRepository.save(movieRating);
		return "redirect:/movies";
	}
	
	//This is a test
	@GetMapping("movies/new")
	public String createMovieRating(Model model) {
		MovieRating movieRating = new MovieRating();
		model.addAttribute("movieRating", movieRating);
		return "movie_rating_form";
	}

}
