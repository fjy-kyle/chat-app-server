package com.example.plugins


import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*

// 设置返回客户端内容解析成json格式
fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
