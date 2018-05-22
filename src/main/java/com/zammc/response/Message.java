package com.zammc.response;


public class Message {
    //状态
    private MessageStatus status;
    //消息标题
    private MessageTitle title;
    //返回消息
    private String message;

    public Message(MessageStatus status, MessageTitle title, String message) {
        this.status = status;
        this.title = title;
        this.message = message;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public MessageTitle getTitle() {
        return title;
    }

    public void setTitle(MessageTitle title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
