package ccb.http;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Test1 {
	public static void main(String[] args) throws Exception {
		String url="http://128.0.214.11/Citrix/XDWeb/auth/login.aspx?user=79652375.zh&password=root123";
		
		HttpClient client = HttpClients.createDefault();
		HttpGet get=new HttpGet(url);
		client.execute(get);
		
	}
}
