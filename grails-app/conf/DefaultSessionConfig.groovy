import grails.plugin.springsession.enums.Serializer
import grails.plugin.springsession.enums.SessionStore
import grails.plugin.springsession.enums.SessionStrategy

import java.sql.Connection

springsession {
    maxInactiveIntervalInSeconds = 1800
    sessionStore = SessionStore.REDIS
    defaultSerializer = Serializer.JDK
    strategy {
        defaultStrategy = SessionStrategy.COOKIE
        cookie.name = "SESSION"
        httpHeader.headerName = "x-auth-token"
    }
    allow.persist.mutable = false

    websocket {
        stompEndpoints = []
        appDestinationPrefix = []
        simpleBrokers = []
    }

    redis {
        connectionFactory {
            hostName = "localhost"
            port = 6379
            timeout = 2000
            usePool = true
            dbIndex = 0
            convertPipelineAndTxResults = true
        }
        poolConfig {
            maxTotal = 8
            maxIdle = 8
            minIdle = 0
        }
        sentinel {
            master = null
            nodes = []
            password = ''
            timeout = 2000
        }
        jackson.modules = []
    }
}
