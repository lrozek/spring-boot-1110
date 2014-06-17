package pl.lrozek.boot;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@SpringApplicationConfiguration(classes = TestPropertiesByProfileITest.class)
@IntegrationTest({ "spring.datasource.driverClassName=net.sf.log4jdbc.sql.jdbcapi.DriverSpy", "spring.datasource.url=jdbc:log4jdbc:h2:mem:boot-test" })
public class TestPropertiesByProfileITest {

    @Test
    public void itShouldGetPropertiesFromActiveProfile() throws Exception {
        // given

        // when

        // then
        assertThat( environment.getProperty( "spring.datasource.driverClassName" ), is( "net.sf.log4jdbc.sql.jdbcapi.DriverSpy" ) );// this value is defined by @@IntegrationTest
        assertThat( environment.getProperty( "spring.datasource.url" ), is( "jdbc:log4jdbc:h2:mem:boot-test" ) ); //this value is overidden by @IntegrationTest
    }

    @Autowired
    private Environment environment;

}
