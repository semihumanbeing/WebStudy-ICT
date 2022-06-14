package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.LocalVO;
import vo.ProductVo;

public class MySearchUtil {

	public static List<ProductVo> search_shop(String p_name,int start,int display)
	{
		List<ProductVo> list = new ArrayList<ProductVo>();
		String clientId = "zRlEYPxgrHQA3TQ0VIHS";
		String clientSecret = "Gd3pW0K5vw";

		try {
			p_name = URLEncoder.encode(p_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/shop.xml?query=%s&start=%d&display=%d",
					         p_name,start,display
					);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//발급받은 ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId); 
			//발급받은 PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement(); // rss
			List<Element>   element_list = (List<Element>)root.getChild("channel").getChildren("item");

			for(Element item : element_list){
				String title = item.getChildText("title");
				String link  = item.getChildText("link");
				String image = item.getChildText("image");
				
				// 값이 정수가 아닌 값이 들어올 때를 대비하여 try catch 문을 사용하여 값을 불러온다.
				int lprice=0,hprice=0;
				try {
					lprice = Integer.parseInt(item.getChildText("lprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					hprice = Integer.parseInt(item.getChildText("hprice"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				String mallName = item.getChildText("mallName");
				
				//상품목록을 포장
				ProductVo vo = new ProductVo();
				vo.setTitle(title);
				vo.setLink(link);
				vo.setImage(image);
				vo.setLprice(lprice);
				vo.setHprice(hprice);
				vo.setMallName(mallName);
								
				//ArrayList에 넣기
				list.add(vo);
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
	
	
	public static List<LocalVO> search_kakao_local(String search_name, double y, double x, int radius)
	{
		List<LocalVO> list = new ArrayList<LocalVO>();
		String rest_api_key = "KakaoAK 14e6d710a78c7e37ef6ec1ebc1ea07cc";
		

		try {
			search_name = URLEncoder.encode(search_name, "utf-8");
			String urlStr = String.format("https://dapi.kakao.com/v2/local/search/keyword.xml?y=%.8f&x=%.8f&radius=%d&query=%s&sort=distance",
					         y,x,radius,search_name
					);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			//발급받은 ID
			connection.setRequestProperty("Authorization", rest_api_key); 
			// 받을요청타입
			connection.setRequestProperty("Content-Type", "application/xml"); 
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document   doc = builder.build (connection.getInputStream());

			Element  root     = doc.getRootElement(); // result
			List<Element>   element_list = root.getChildren("documents");

			for(Element documents : element_list){
				
				String place_name = documents.getChildText("place_name");
				String road_address_name = documents.getChildText("road_address_name");
				String place_url = documents.getChildText("place_url");
				String phone = documents.getChildText("phone");
				int distance = 0;
				double longitude = 0;
				double latitude= 0;
				try {
					distance = Integer.parseInt(documents.getChildText("distance"));
					longitude = Double.parseDouble(documents.getChildText("longitude")); 
					latitude = Double.parseDouble(documents.getChildText("latitude"));
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				LocalVO vo = new LocalVO(place_name, road_address_name, place_url, phone, distance, longitude, latitude);
				//ArrayList에 넣기
				list.add(vo);
				

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}
	
}
