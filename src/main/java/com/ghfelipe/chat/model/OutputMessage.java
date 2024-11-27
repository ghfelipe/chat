package com.ghfelipe.chat.model;

import lombok.Value;

@Value
public class OutputMessage {
    String from;
    String text;
    String time;
}
