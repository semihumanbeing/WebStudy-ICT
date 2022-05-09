/**
 * 
 */

class mymath {
	// function을 사용하지 않는다. 
	static max(a, b) {
		return (a > b) ? a : b;
	}
	static min(a, b) {
		return (a < b) ? a : b;
	}
	
	static hap(n){
		var temp = 0;
		for(var a=n;a>0;a--){
			temp = temp+a;
		}
		return temp;
	}

}