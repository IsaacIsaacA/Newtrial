function get(url, element) {
	let divvy = document.getElementById(element);

	let xhr = new XMLHttpRequest(); // Ready State 0

	/*
	 * An XMLHttpRequest has a property called "onreadystatechange". This
	 * property takes a callback function. A callback function is a function
	 * that is passed to another function and/or called from within another
	 * function.
	 * 
	 * Each time the ready state changes, this "onreadystatechange" property's
	 * callback function is executed.
	 */

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			/*
			 * At this point, we will grab the JSON that was fetched from the
			 * API and do some DOM manipulation using the information that was
			 * returned.
			 */
			
			let movies = JSON.parse(xhr.responseText);
			console.log(movies);

			switch (element) {

			case 'apiDiv':

				for (let m in movies["Search"]) {
					let img = document.createElement("img");
					img.src = movies["Search"][m]["Poster"];
					img.style.borderRadius = "5px";
					divvy.append(img);
				}
				break;

			case 'dbDiv':
				
				for(let m in movies){
					let div = document.createElement('div');
					let title = document.createElement("h5");
					title.innerHTML = movies[m]["name"];
					let img = document.createElement("img");
					img.src = movies[m]["url"];
					img.style.borderRadius = "5px";
					div.append(img);
					div.append(title);
					divvy.append(div);
				}
				break;
			}
		}
	}

	xhr.open("GET", url); // Ready State 1
	/*
	 * In order to get any resources from this API we're using, we have to set
	 * some request headers in order to be authenticated.
	 */
	xhr.setRequestHeader("X-RapidAPI-Host",
			"movie-database-imdb-alternative.p.rapidapi.com");
	xhr.setRequestHeader("X-RapidAPI-Key",
			"2f530a3db3msh028512351081690p171600jsnf425ee1b906c");
	xhr.send(); // Ready State 2
}

function post(url){
	
	let obj = {id:1, name:"property 2", rating:8, url:"url", genreId:0};
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			console.log("Post Request Successful");
		}
	}
	
	xhr.open("POST", url);
	xhr.send(JSON.stringify(obj));
}

function propagateAPIMovies(searchTerm) {
	let url = "https://movie-database-imdb-alternative.p.rapidapi.com/?s="
			+ searchTerm;
	this.get(url, "apiDiv");
}

window.onload = function() {
	this.propagateAPIMovies('Star Trek');
	this.post("/ServletDemo/getflix2api/movie/create");
}
