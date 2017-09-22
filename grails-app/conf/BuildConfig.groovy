grails.project.work.dir = 'target'

grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {
    inherits 'global'
    log 'warn'

    repositories {
        mavenLocal()
        grailsCentral()
        mavenCentral()
    }

    dependencies {
        compile('org.springframework.session:spring-session:1.3.1.RELEASE')
        compile('org.springframework.data:spring-data-redis:1.6.6.RELEASE')
        compile('com.fasterxml.jackson.core:jackson-databind:2.8.8')
        compile('redis.clients:jedis:2.5.2')

        provided('org.springframework:spring-core:4.1.1.RELEASE')
        provided('org.springframework:spring-websocket:4.1.1.RELEASE')
        provided('org.springframework:spring-messaging:4.1.1.RELEASE')
    }

    plugins {
        build(":release:3.1.1", ":rest-client-builder:2.1.1") {
            export = false
        }
        compile ':webxml:1.4.1'
    }
}
