package ssn;

import java.util.Calendar;

public class SSN2 {
	
	private String SocialSecuritynumber;

	public String getSocialSecuritynumber() {
		return SocialSecuritynumber;
	}

	public void setSocialSecuritynumber(String socialSecuritynumber) {
		SocialSecuritynumber = socialSecuritynumber;
	}
	
	public String getGender() {
		char gender = SocialSecuritynumber.charAt(7);
		String strGender = "";
		if(gender%2 ==1) {
			strGender = "����";
			return strGender;
		} else
			strGender = "����";
			return strGender;
	}
	
	public int getYear() {
		String strYear = SocialSecuritynumber.substring(0,2);
		int year = Integer.parseInt(strYear);
		char gender = SocialSecuritynumber.charAt(7);
		
		if(gender =='1' || gender == '2'|| gender == '5'|| gender =='6') {
			year = year + 1900;
		} else if(gender =='3' || gender == '4'|| gender == '7'|| gender =='8') {
			year = year + 2000;
		} else year = year + 1800;
		
		return year;
		
	}
	public int getAge() {
		Calendar calendar = Calendar.getInstance();
		int currentYear = calendar.get(Calendar.YEAR);
		int age = currentYear - this.getYear() +1;
		return age;
	}
	
	public String getT() {
		
		String[] tArray = {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��",};
		
		int tIndex = this.getYear() % 12;
		return tArray[tIndex];
		

		}

	// 961212-1234560
	// 01234567890123
	public String getLocal() {
		String strLocal = SocialSecuritynumber.substring(8,10);
		int intLocal = Integer.parseInt(strLocal);
		
		if (intLocal >= 0 && intLocal <=8) {
			return "����";
		} else if (intLocal >= 9 && intLocal <=12) {
			return "�λ�";
		} else if (intLocal >= 9 && intLocal <=12) {
			return "�λ�";
		} else if (intLocal >= 13 && intLocal <=15) {
			return "��õ";
		} else if (intLocal >= 16 && intLocal <=25) {
			return "��⵵";
		} else if (intLocal >= 26 && intLocal <=34) {
			return "������";
		} else if (intLocal >= 35 && intLocal <=39) {
			return "��û�ϵ�";
		} else if (intLocal >= 40 && intLocal <=47) {
			return "��û����";
		} else if (intLocal >= 48 && intLocal <=55) {
			return "����ϵ�";
		} else if (intLocal >= 56 && intLocal <=66) {
			return "���󳲵�";
		} else if (intLocal >= 67 && intLocal <=80) {
			return "���ϵ�";
		}
			
		return "��󳲵�";
		
	}
	
	// 12 1 2 / 3 4 5 / 6 7 8 / 9 10 11
	public String getSeason() {
		String strSeason = SocialSecuritynumber.substring(2,4);
		int intSeason = Integer.parseInt(strSeason);
		String season = "";
		switch(intSeason) {
		case 12 :
		case 1 :
		case 2 : season = "�ܿ�";break;
		case 3 :
		case 4 :
		case 5 : season = "��";break;
		case 6 :
		case 7 :
		case 8 : season = "����";break;
		case 9 : 
		case 10 :
		case 11 : season = "����";
			
		}
		return season;
	}
	
	public String getGanji() {
		int ganIndex = this.getYear() % 10;
		int jiIndex = this.getYear() % 12;
		
		String []ganArray = {"��","��","��","��","��","��","��","��","��","��"};
		String []jiArray = {"��","��","��","��","��","��","��","��","��","��","��","��"};
		
		String gan = ganArray[ganIndex];
		String ji = jiArray[jiIndex];
		

		return String.format("%s%s��", gan, ji);
	}
	//            01234567890123
	//            801212-1212121
	//			  234567 892345
	public boolean isValid() {
		int sum = 0;
		sum = sum +(SocialSecuritynumber.charAt(0)-'0')* 2;
		sum = sum +(SocialSecuritynumber.charAt(1)-'0')* 3;
		sum = sum +(SocialSecuritynumber.charAt(2)-'0')* 4;
		sum = sum +(SocialSecuritynumber.charAt(3)-'0')* 5;
		sum = sum +(SocialSecuritynumber.charAt(4)-'0')* 6;
		sum = sum +(SocialSecuritynumber.charAt(5)-'0')* 7;
		// '-' �ǳʶٱ�
		sum = sum +(SocialSecuritynumber.charAt(7)-'0')* 8;
		sum = sum +(SocialSecuritynumber.charAt(8)-'0')* 9;
		sum = sum +(SocialSecuritynumber.charAt(9)-'0')* 2;
		sum = sum +(SocialSecuritynumber.charAt(10)-'0')* 3;
		sum = sum +(SocialSecuritynumber.charAt(11)-'0')* 4;
		sum = sum +(SocialSecuritynumber.charAt(12)-'0')* 5;
		
		
		sum = sum%11;
		sum = 11-sum;
		sum = sum%10;
		
		int lastNo = (SocialSecuritynumber.charAt(13)-'0');
		
		
		
		return (sum==lastNo);
	}
	
	public boolean isValid2() {
		int sum = 0;
		int number = 2;
		for(int i = 0; i<=12; i++) {
			if (i==6) continue;
			
			sum = sum +(SocialSecuritynumber.charAt(i)-'0')* number;
			number++;
			if(number >9) number =2;	
		}
		
		sum = (11-(sum%11))%10;
		
		int lastNo = (SocialSecuritynumber.charAt(13)-'0');
		
		return (sum==lastNo);
	}

}
