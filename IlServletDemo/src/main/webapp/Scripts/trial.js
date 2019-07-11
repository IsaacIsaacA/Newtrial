

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


window.onload = function() {
	
	this.post("tritontest");
}
