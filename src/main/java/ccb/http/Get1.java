package ccb.http;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

public class Get1 {

	public static void main(String[] args) {
		new TestGet1().start();
	}

}
	class TestGet1 extends Thread{
		@Override
		public void run() {
			try {
				
				
				String url="http://www.baidu.com";
				HttpClient httpClient = HttpClients.createDefault();
				HttpGet get=new HttpGet(url);
				//get.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencode;charset=utf-8"));
				//get.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));
				
				HttpResponse response = httpClient.execute(get);
				String result = EntityUtils.toString(response.getEntity(),"utf-8");
				System.out.println(result);
				
				
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			super.run();
		}
	}