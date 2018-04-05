String.prototype.format = function(args) {
	var result = this;
	if (arguments.length > 0) {
		if (arguments.length == 1 && typeof (args) == "object") {
			for ( var key in args) {
				if (args[key] != undefined) {
					var reg = new RegExp("({" + key + "})", "g");
					result = result.replace(reg, args[key]);
				}
			}
		} else {
			for (var i = 0; i < arguments.length; i++) {
				if (arguments[i] != undefined) {
					// var reg = new RegExp("({[" + i + "]})",
					// "g");//这个在索引大于9时会有问题
					var reg = new RegExp("({)" + i + "(})", "g");
					result = result.replace(reg, arguments[i]);
				}
			}
		}
	}
	return result;
}

String.prototype.word_len = function() { // 计算String的字节数
	return this.replace(/[^\x00-\xff]/g, "rr").length;
}

String.prototype.word_sub = function(n) { // 从0截取n长的字节数
	var r = /[^\x00-\xff]/g;
	if (this.replace(r, "mm").length <= n)
		return this;
	// n = n - 3;
	var m = Math.floor(n / 2);
	for (var i = m; i < this.length; i++) {
		if (this.substr(0, i).replace(r, "mm").length >= n) {
			return this.substr(0, i);
		}
	}
	return this;
};

function cut_word(str, max_word_length) {
	if(str==''||str==null) return '';
	if(str.word_len() > max_word_length){
		return str.word_sub(max_word_length-3)+'...';
	}
	else{
		return str;
	}
}