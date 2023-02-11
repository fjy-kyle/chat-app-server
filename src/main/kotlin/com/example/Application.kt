package com.example

import com.example.di.mainModule
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import com.example.plugins.*
import org.koin.core.context.startKoin

@Suppress("unused")
fun main() {
    embeddedServer(Tomcat, port = 8088, host = "0.0.0.0") {
        // 开始依赖注入
        startKoin {
            modules(mainModule)
        }
        configureSecurity()  // 配置session保存用户名
        configureMonitoring()  // 配置事件打印日志
        configureSockets() // 配置WebSocket
        configureSerialization() // 配置内容返回为json格式
        configureRouting() // 配置路径
    }.start(wait = true)
}