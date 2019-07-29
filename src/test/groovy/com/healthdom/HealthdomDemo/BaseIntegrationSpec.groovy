package com.healthdom.HealthdomDemo

import groovy.transform.TypeChecked
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@TypeChecked
@SpringBootTest(classes = [HealthdomDemoApplication], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BaseIntegrationSpec extends Specification {
}
