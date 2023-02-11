package com.example.data

import com.example.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    private val db: CoroutineDatabase
) : MessageDataSource{

    // 在库里查找返回指定类的数据表
    private val messages = db.getCollection<Message>()

    override suspend fun getAllMessage(): List<Message> {
        return messages.find()
            .descendingSort(Message::timestamp)
            .toList()
    }

    // 在第一次插入数据时会自动建表
    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}