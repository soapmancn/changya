package com.soapmans.changya.entry;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Mp3Entry {
    private String singerNickName;
    private String songName;
    private String songSrc;
}
