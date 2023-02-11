package com.example.di

import com.example.data.MessageDataSource
import com.example.data.MessageDataSourceImpl
import com.example.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

// 依赖注入，创建mongo本地连接，获取协程版本，获取数据相应库名的库，没有则新建
val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db_yt")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }
    single {
        RoomController(get())
    }
}
