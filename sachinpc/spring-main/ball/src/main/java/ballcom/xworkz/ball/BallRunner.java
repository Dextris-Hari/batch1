package ballcom.xworkz.ball;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BallRunner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("configure.xml");
		Ball ball = context.getBean(Ball.class);
		System.out.println(ball);
	}

}
