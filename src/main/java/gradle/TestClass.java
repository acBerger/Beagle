package gradle;

/**
 * This is a class to test if gradle works.
 *
 * @author Annika Berger
 * @version 0
 */
public class TestClass {

	/**
	 * testMessage is a test message which the class {@code TestClass} contains.
	 */
	private String testMessage;

	/**
	 * This is a public constructor of {@code TestClass}.
	 */
	public TestClass() {
		this.testMessage = "this is a message and this is a test, so it is a test message.";
	}

	/**
	 * testMessage is a test message which the class {@code TestClass} contains.
	 *
	 * @return the testMessage
	 */
	public String getTestMessage() {
		return this.testMessage;
	}

	/**
	 * testMessage is a test message which the class {@code TestClass} contains.
	 *
	 * @param testMessage
	 *            the testMessage to set (final)
	 */
	public void setTestMessage(final String testMessage) {
		this.testMessage = testMessage;
	}

}
