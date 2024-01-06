import org.junit.jupiter.api.*;
import utils.Driver;

public class Hooks {

	@BeforeAll
	public static void setUpTestEnvironment() {
		Driver.getDriver();
	}

	@AfterAll
	public static void tearDownTestEnvironment() {
		Driver.closeDriver();
	}

}
