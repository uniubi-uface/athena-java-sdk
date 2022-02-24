package com.uniubi.cloud.athena.sdk.example.benas;

/**
 * @author 井木
 * @since 2021/06/04 17:57
 */
public class MsgContentDTO {

    /**
     * 消息id
     */
    private String msgId;

    /**
     * 消息类型
     * <ul>
     * <li>1 识别记录推送</li>
     * <li>2 员工添加记录推送</li>
     * <li>3 员工更新记录推送</li>
     * <li>4 员工删除记录推送</li>
     * <li>5 部门添加记录推送</li>
     * <li>6 部门更新记录推送</li>
     * <li>7 部门删除记录推送</li>
     * </ul>
     * 暂时只支持<code>1</code>
     */
    private Byte type;

    /**
     * 消息内容（不同消息内容格式也是不同的）
     */
    private String content;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MsgContentDTO{" + "msgId='" + msgId + '\'' + ", type=" + type + ", content='" + content + '\'' + '}';
    }

}
