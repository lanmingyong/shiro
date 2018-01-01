package utils.test;

import org.junit.Test;

import com.guoxin.common.util.MD5;
import com.guoxin.common.util.Utilities;

public class UtilsTest {
@Test
public void test() {
	String loginame="test-4";
	String password="test-4";
	String s=MD5.encode(Utilities.encryptPassword(loginame, password)).toLowerCase();
	System.out.println(s);
}
}
