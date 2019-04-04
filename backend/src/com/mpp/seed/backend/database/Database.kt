package com.mpp.seed.backend.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun initializeDb() {
    val driver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://localhost/DATABASE_NAME?useSSL=false"
    val pool = 4
    val commit = false
    val isolation = "TRANSACTION_REPEATABLE_READ"
    val user = "DATABASE_USER"
    val pass = "DATABASE_PASSWORD"

    val datasource = datasource(
            driver = driver,
            url = url,
            user = user,
            autoCommit = commit,
            isolation = isolation,
            pass = pass,
            pool = pool
    )

    val db = Database.connect(datasource)

    transaction {
        // TODO CREATE TABLES SchemaUtils.create(...)
    }
}

private fun datasource(
        driver: String,
        url: String,
        pool: Int,
        autoCommit: Boolean,
        isolation: String,
        user: String,
        pass: String
): HikariDataSource {
    val config = HikariConfig()
    config.driverClassName = driver
    config.jdbcUrl = url
    config.maximumPoolSize = pool
    config.isAutoCommit = autoCommit
    config.transactionIsolation = isolation
    config.username = user
    config.password = pass

    config.validate()
    return HikariDataSource(config)
}