package com.example.myservicetest.entities;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by 赵小缺 on 2016/9/10.
 */
@Table(name = "t_chatmessage")
public class ChatMessage {
    @Id
    private Long localId;
    @Column
    private Long id;
    @Column
    private String content;

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
