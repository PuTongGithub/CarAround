function build_url(url, obj){
	var query_str = '?';
	for(var i in obj){
		query_str += i + '=' + obj[i] + '&';
	}
	return url+query_str.substr(0,query_str.length - 1);
}