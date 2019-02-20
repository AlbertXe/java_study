package java_study.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	private static Logger logger = LoggerFactory.getLogger(LogTest.class);
	private static final String log01 = "hello! {},{}";

	public static void main(String[] args) {
		logger.info(log01, "xie", "洪");
	}
}
