package com.uniubi.cloud.athena.sdk.message.receive.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.uniubi.cloud.athena.sdk.message.receive.example.benas.MsgContentDTO;
import com.uniubi.cloud.athena.sdk.message.receive.example.benas.MsgResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * receive UStar Cloud service pushed message
 *
 * @author jingmu
 * @since 2022/02/24
 */
@Slf4j
@RestController
@RequestMapping
public class AthenaMessageSubscribeController {

    @PostMapping("/athena/sdk/msg/receive/test")
    public MsgResult test(@RequestBody MsgContentDTO msgContentBO) {
        log.info("Receive UStar cloud message ==> {}", JSON.toJSONString(msgContentBO));
        Byte type = msgContentBO.getType();
        switch (type) {
        case 1:
            JSONObject jsonObject = JSON.parseObject(msgContentBO.getContent());
            Long showTime = jsonObject.getLong("showTime");
            Date date = new Date(showTime);
            log.info("Recognition time: [{}], receive message time: [{}]", date, new Date());
            break;
        case 2:
            // Type 2 is under development
            log.info("A callback message is received. The message callback type is 2.");
            break;
        case 3:
            // Type 3 is under development
            log.info("A callback message is received. The message callback type is 3.");
            break;
        default:
            log.info("A callback message is received. The message callback type is {}.", type);
        }
        return new MsgResult(true);
    }

}
