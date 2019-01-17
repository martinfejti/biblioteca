package hu.simplesoft.springtutorial.Biblioteca.controller.request;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class BookCreateRequest {

	@NotNull
	@Size(min = 2, max = 30, message = "The book name should be between 2 and 30 charackters!")
	private String name;
	
	@Valid
	private long authorId;
	
	@Max(4)
	private int publishYear;
	
	@NotNull
	@Size(min = 4, max = 20, message = "The book category should be between 4 and 20 characters!")
	private String category;
	
	@Valid
	private long libraryId;
	
	public BookCreateRequest() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(long libraryId) {
		this.libraryId = libraryId;
	}
	
}
