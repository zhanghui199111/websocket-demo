package com.phoenix.websocket.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * author: zhn4528
 * create: 2022/4/6 14:18
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocketMessage {
    
    private String message;
    
    private Date sendDate;
    
}
