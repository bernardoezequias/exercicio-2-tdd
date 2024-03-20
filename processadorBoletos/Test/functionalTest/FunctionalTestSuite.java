package functionalTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import processadorBoletos.ProcessorFunctionalTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ProcessorFunctionalTest.class
})
public class FunctionalTestSuite {
}
