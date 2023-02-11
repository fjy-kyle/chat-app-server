package com.example.plugins

import com.example.session.ChatSession
import io.ktor.server.application.*
import io.ktor.server.application.ApplicationCallPipeline.ApplicationPhase.Plugins
import io.ktor.server.sessions.*
import io.ktor.util.*

// 配置session：使用cookie保存用户名
fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("MY_SESSION")
    }
    // 拦截客户端的请求,如果之前没有此用户名，则保存
    intercept(Plugins) {
        if (call.sessions.get<ChatSession>() == null) {
            val username = call.parameters["username"] ?: "Guest"
            call.sessions.set(ChatSession(username, generateNonce()))
        }
    }
}

