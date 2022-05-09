/**
 * 
 */

class Jumin {

	constructor(jumin_no) {
		this._jumin_no = jumin_no;
	}

	get jumin_no() {
		return this._jumin_no;
	}

	// setter 
	set jumin_no(jumin_no) {
		this._jumin_no = jumin_no;
	}
	// 성별 구하기
	getGender() {
		var genderNumber = this._jumin_no.charAt(7);
		if (genderNumber == 1 || genderNumber == 3 || genderNumber == 5 || genderNumber == 7) {
			return "남자";
		} else {
			return "여자";

		}
	}
	// 출생년도 구하기
	getYear() {
		var strYear = String(this._jumin_no);
		var genderNumber = this._jumin_no.charAt(7);
		var bornyear = strYear.substring(0, 2);
		var year = parseInt(bornyear) + 1900;

		return year;
	}

	//나이구하기
	getAge() {
		var date = new Date();
		var year = date.getFullYear();
		return year - (this.getYear()) + 1;
	}
}