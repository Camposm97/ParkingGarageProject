package util_Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.UsernameUtil;

class UsernameUtilTest {
	@Test
	void testEmitUsername() {
		String username = UsernameUtil.emitUsername("Chris", "Demonte");
		assertEquals(username, "Democ");
	}

}
