package ca.jent.webflux.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories

@Configuration
@EnableReactiveCassandraRepositories
open class CassandraConfig: AbstractReactiveCassandraConfiguration() {


    // @see https://stackoverflow.com/questions/53101753/spring-boot-data-cassandra-reactive-jmxreporter-problem
    override fun cluster(): CassandraClusterFactoryBean {
        val factoryBean = super.cluster()
        factoryBean.setJmxReportingEnabled(false)
        return factoryBean
    }

    override fun getKeyspaceName() = "hr"

    override fun getContactPoints() = "localhost"

    override fun getEntityBasePackages() = arrayOf("ca.jent.ca.jent.webflux.domain")


}