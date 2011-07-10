jQuery.fn.ratings = function(stars, initialRating) {

  //Save  the jQuery object for later use.
  var elements = this;
  
  //Go through each object in the selector and create a ratings control.
  return this.each(function() {
  
    //Make sure intialRating is set.
    if(!initialRating)
      initialRating = 0;
      
    //Save the current element for later use.
    var containerElement = this;
    
    //grab the jQuery object for the current container div
    var container = jQuery(this);
    
    //Create an array of stars so they can be referenced again.
    var starsCollection = Array();
    
    //Save the initial rating.
    containerElement.rating = initialRating;
    
    //Set the container div's overflow to auto.  This ensure it will grow to
    //hold all of its children.
    container.css('overflow', 'auto');
    
    //create each star
    for(var starIdx = 0; starIdx < 10; starIdx++) {
      
      //Create a div to hold the star.
      var starElement = document.createElement('div');
      
      //Get a jQuery object for this star.
      var star = jQuery(starElement);
      
      //Store the rating that represents this star.
      starElement.rating = starIdx + 1;
      
      //Add the style.
      star.addClass('jquery-ratings-star');
      
      //Add the full css class if the star is beneath the initial rating.
      if(starIdx < initialRating) {
        star.addClass('jquery-ratings-full');
      }
//      if(starIdx < 3) {
//        star.addClass('jquery-ratings-red');
//      }
//      else if(starIdx < 7) {
//        star.addClass('jquery-ratings-orange');
//      }
//      else {
//          star.addClass('jquery-ratings-green');
//        }
      
      
      //add the star to the container
      container.append(star);
      starsCollection.push(star);
      
      //hook up the click event
      star.click(function() {
        //When clicked, fire the 'ratingchanged' event handler.  Pass the rating through as the data argument.
        elements.triggerHandler("ratingchanged", {rating: this.rating});
        containerElement.rating = this.rating;
      });
      
      
      
      star.mouseenter(function() {
    	  var color;
    	  //Highlight selected stars.
    	  if (this.rating < 3) 
    	  { color="red";}
    	  else if (this.rating < 7) 
    	  { color="orange";}
    	  else 
    	  { color="green";}
    	  
    	  
        for(var index = 0; index < this.rating; index++) {           
        	addColor(index,color);	
        }
        //Unhighlight unselected stars.
        for(var index = this.rating; index < stars; index++) {
        	removeColor(index,color);
        }
      });
      
      
      container.mouseleave(function() {
    	  var color;
    	  if (containerElement.rating < 3) 
    	  { color="red";}
    	  else if (containerElement.rating < 7) 
    	  { color="orange";}
    	  else 
    	  { color="green";}
    	  
    	//Highlight selected stars.
        for(var index = 0; index < containerElement.rating; index++) {
        	addColor(index,color);
        }
        //Unhighlight unselected stars.
        for(var index = containerElement.rating; index < stars ; index++) {
        	removeColor(index,color);
        }
      });
      
      var addColor = function(index,color){
    	  if(color=="red") 
      	  {starsCollection[index].addClass('jquery-ratings-red');}
          else if(color=="orange") 
          {starsCollection[index].addClass('jquery-ratings-orange');}
          else 
          {starsCollection[index].addClass('jquery-ratings-green');}
      }
      var removeColor = function(index,color){
    	  if(color=="red") 
      	  {starsCollection[index].removeClass('jquery-ratings-red');}
          else if(color=="orange") 
          {starsCollection[index].removeClass('jquery-ratings-orange');}
          else 
          {starsCollection[index].removeClass('jquery-ratings-green');}
      }
      
      
    }
  });
};
