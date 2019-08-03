package com.healthdom.HealthdomDemo.employee

import com.tngtech.archunit.core.domain.JavaClasses
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.ArchRule
import spock.lang.Specification

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

class PackageArchitectureSpec extends Specification {
    def "Domain must not depend on its infrastructure"() {
        given:
            JavaClasses classesToCheck = new ClassFileImporter().withImportOption(new ImportOption.DoNotIncludeTests())
                    .importPackages("com.healthdom")
            ArchRule rule = noClasses().that()
                    .resideInAPackage("..employee.domain..")
                    .should()
                    .dependOnClassesThat().resideInAPackage("..employee.infrastructure..")
        expect:
            rule.check(classesToCheck)
    }
}
