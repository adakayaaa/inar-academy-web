import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import utils.Driver;

public class Hooks {

	@BeforeAll
	public static void setUpTestEnvironment() {
		Driver.getDriver();
	}

	@AfterAll
	public static void tearDownTestEnvironment() {
		if (Driver.getDriver() != null) {
			Driver.getDriver().quit();
		}
	}

}
