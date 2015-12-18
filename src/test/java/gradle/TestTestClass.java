package gradle;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import gradle.TestClass;

import org.junit.Test;

/**
 * This is a class to test if {@code TestClass} works as it should.
 *
 * @author Annika Berger
 * @version 0
 */
public class TestTestClass {

	/**
	 * this is the message {@code TestClass} contains by inizialisation.
	 */
	private final String instanziationMessage = "this is a message and this is a test, so it is a test message.";

	/**
	 * This is a simple test method, which tests that the inizialisation works.
	 */
	@Test
	public void testInstanziation() {
		final TestClass testClass = new TestClass();
		final String actualMessage = testClass.getTestMessage();
		assertThat(actualMessage, is(equalTo(this.instanziationMessage)));
	}

	/**
	 * This is a simple test method, which tests if setter works.
	 */
	@Test
	public void testSetter() {
		final TestClass testClass = new TestClass();
		final String testMessage = "This is my testMessage";
		testClass.setTestMessage(testMessage);
		final String actualMessage = testClass.getTestMessage();
		assertThat(actualMessage, is(equalTo(testMessage)));
	}

}
