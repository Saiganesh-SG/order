/*package com.example.order.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BookAuthor {

	  @Id
	  @Column(name = "id")
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Integer id;
	  
	  @ManyToOne
	    @JoinColumn(name = "BookID")
	    private Book book;

	    @ManyToOne
	    @JoinColumn(name = "AuthorID")
	    private Author author;
      
	  
}*/
