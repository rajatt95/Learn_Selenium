package utilities;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class TestMail {
	public static void main(String[] args) {

		MonitoringMail mail = new MonitoringMail();
		try {
			mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject,
					TestConfig.messageBody);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
