package cst438;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class MovieRating {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@Size(min=3, max=50)
	private String movieTitle;
	
	@NotNull
	@Min(1)
	@Max(5)
	private int movieRating;
	
	@NotNull
	@Size(min=3, max=25)
	private String ratersName;
	
	private String creationDateTime;
	
	public MovieRating() {
		
	}

	public MovieRating(long id, String movieTitle, int movieRating,
			String ratersName, String creationDateTime) {
		super();
		this.id = id;
		this.movieTitle = movieTitle;
		this.movieRating = movieRating;
		this.ratersName = ratersName;
		this.creationDateTime = creationDateTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(int movieRating) {
		this.movieRating = movieRating;
	}

	public String getRatersName() {
		return ratersName;
	}

	public void setRatersName(String ratersName) {
		this.ratersName = ratersName;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}
	
}
