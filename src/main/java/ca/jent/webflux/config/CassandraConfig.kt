package ca.jent.webflux.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@Configuration
@EnableReactiveCassandraRepositories
open class CassandraConfig: AbstractCassandraConfiguration() {

    override fun getKeyspaceName() = "hr"

    override fun getContactPoints() = "localhost"

    override fun getEntityBasePackages() = arrayOf("ca.jent.webflux.domain")


}