package com.phoenix.websocket.controller;

import com.phoenix.websocket.data.SocketMessage;
import com.phoenix.websocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;

/**
 * author: zhn4528
 * create: 2022/4/6 14:18
*/
@Controller
@RequestMapping("/web/socket")
public class WebSocketController {

    /**
     * 页面请求
     * @param cid
     * @return
     */
    @RequestMapping(value = "/{cid}", method = RequestMethod.GET)
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口
     * @param cid
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String pushToWeb(String cid,String message) {
        try {
            SocketMessage newMessage = new SocketMessage(message, new Date());
            WebSocketServer.sendInfo(newMessage,cid);
        } catch (IOException e) {
            e.printStackTrace();
            return cid+"#"+e.getMessage();
        }
        return cid;
    }
}