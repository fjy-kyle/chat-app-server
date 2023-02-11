package com.example.plugins

import com.example.room.RoomController
import com.example.routes.chatSocket
import com.example.routes.getAllMessage
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Application.configureRouting() {
    val roomController : RoomController by inject(RoomController::class.java)
    install(Routing) {
        chatSocket(roomController)
        getAllMessage(roomController)

    }
}
