package ccb.http;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.ndktools.javamd5.Mademd5;
/**
 * @ClassName:  Get   
 * @Description:有道API接口 get  
 * @author: 谢洪伟 
 * @date:   2018年8月3日 上午10:31:19   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 *
 */
public class Get {
	public static void main(String[] args) {
//		String pass="7e283076f988638dgood2Kp2ch3FIafWjEQQlzp46K37dDWeKOSg5";
//		Mademd5 md5=new Mademd5();
//		System.out.println(md5.toMd5(pass));
		new TestGet().start();
	}
}
	class TestGet extends Thread{
		
		@Override
		public void run() {
			try {
				//appkey (应用id)+q+salt+密匙(应用密匙)
				String uri="http://openapi.youdao.com/api?q=good&from=EN&to=zh_CHS&appKey=7e283076f988638d&salt=2&sign=B97FD32828A9D943A476A40E4D50C17D";
				
				HttpClient client=HttpClients.createDefault();
				HttpGet get=new HttpGet(uri);
				HttpResponse result = client.execute(get);
				String string = EntityUtils.toString(result.getEntity());
				System.out.println(string);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
