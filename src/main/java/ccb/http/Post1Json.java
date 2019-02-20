package ccb.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class Post1Json {
	public static void main(String[] args) {
		new TestPost1Json().start();
	}
}
	class TestPost1Json extends Thread {
		@Override
		public void run() {
			String paranms="";
			String url="http://www.baidu.com/s";
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			post.setHeader("Accept","application/json");
			post.setHeader("Content-Type","application/json");
			
			StringEntity stringEntity = new StringEntity(paranms, "UTF-8");
			post.setEntity(stringEntity);
			
			try {
				
				
				HttpResponse response = client.execute(post);
//				if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					String result = EntityUtils.toString(entity,"UTF-8");
					System.out.println(result);
//				}
				
				
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}
