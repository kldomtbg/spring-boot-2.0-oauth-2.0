package com.ywsoftware.oa.authServer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(Suite.class)
@Suite.SuiteClasses({UserServiceTest.class})
public class TestSuiteMain {

}
