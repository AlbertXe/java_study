package ccb.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
/**
 * 
 * @ClassName:  Post   
 * @Description:有道API post  
 * @author: 谢洪伟 
 * @date:   2018年8月3日 上午10:31:58   
 *     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 *
 */
public class Post {

	public static void main(String[] args) {
		new TestPost().start();
	}
	
	
}

class  TestPost extends Thread{
	
	@Override
	public void run() {
		try {
			
			
			HttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost();
			post.setURI(new URI("http://openapi.youdao.com/api"));
			
			List<NameValuePair> list =new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("q", "good"));
			list.add(new BasicNameValuePair("from", "EN"));
			list.add(new BasicNameValuePair("to", "zh_CN"));
			list.add(new BasicNameValuePair("appKey", "7e283076f988638d"));
			list.add(new BasicNameValuePair("salt", "2"));
			list.add(new BasicNameValuePair("sign", "B97FD32828A9D943A476A40E4D50C17D"));
			
			post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
			
			HttpResponse response = client.execute(post);
			String string = EntityUtils.toString(response.getEntity(), "UTF-8");
			System.out.println(string);
			
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
