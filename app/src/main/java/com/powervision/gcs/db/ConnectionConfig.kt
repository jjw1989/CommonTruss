package com.powervision.gcs.db

import android.content.Context

class ConnectionConfig {

    var context: Context? = null
        private set
    var ip: String? = null
        private set
    var port: Int = 0
        private set
    var readBufferSize: Int = 0
        private set
    var connectionTimeout: Long = 0
        private set

    class Builder(private val context: Context) {
        private var ip = "192.168.0.1"
        private var port = 5678
        private var readBufferSize = 1024
        private var connectionTimeout: Long = 10000

        fun setIp(ip: String): Builder {
            this.ip = ip
            return this
        }

        fun setPort(port: Int): Builder {
            this.port = port
            return this
        }

        fun setReadBufferSize(readBufferSize: Int): Builder {
            this.readBufferSize = readBufferSize
            return this
        }

        fun setConnectionTimeout(connectionTimeout: Long): Builder {
            this.connectionTimeout = connectionTimeout
            return this
        }

        private fun applyConfig(config: ConnectionConfig) {

            config.context = this.context
            config.ip = this.ip
            config.port = this.port
            config.readBufferSize = this.readBufferSize
            config.connectionTimeout = this.connectionTimeout
        }

        fun builder(): ConnectionConfig {
            val config = ConnectionConfig()
            applyConfig(config)
            return config
        }
    }
}
