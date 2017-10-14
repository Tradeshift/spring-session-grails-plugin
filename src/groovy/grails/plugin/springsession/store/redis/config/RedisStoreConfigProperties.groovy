package grails.plugin.springsession.store.redis.config

import grails.plugin.springsession.enums.SessionStrategy

/**
 * @author Jitendra Singh.
 */
class RedisStoreConfigProperties {

    List<Map> sentinalNodes
    String sentinalMasterName
    String sentinalPassword

    String hostName
    int port
    String connectionPassword
    int timeout
    boolean usePool
    int dbIndex
    boolean convertPipelineAndTxResults
    List<String> jacksonModules

    public RedisStoreConfigProperties(ConfigObject conf) {
        sentinalNodes = conf.redis.sentinel.nodes as List<Map>
        sentinalMasterName = conf.redis.sentinel.master ?: ""
        usePool = conf.redis.connectionFactory.usePool ?: false
        hostName = conf.redis.connectionFactory.hostName
        connectionPassword = conf.redis.connectionFactory.password ?: ''
        port = conf.redis.connectionFactory.port as Integer
        sentinalPassword = conf.redis.sentinel.password ?: null
        timeout = conf.redis.sentinel.timeout as Integer ?: 5000
        dbIndex = conf.redis.connectionFactory.dbIndex as Integer
        convertPipelineAndTxResults = conf.redis.connectionFactory.convertPipelineAndTxResults
        if(conf.redis.jackson.modules && conf.redis.jackson.modules instanceof List)
            jacksonModules = conf.redis.jackson.modules
    }

}
