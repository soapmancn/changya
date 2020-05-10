package com.soapmans.changya.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soapmans.changya.entry.Mp3Entry;
import com.soapmans.changya.service.ChangYaService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class ChangYaServiceImpl implements ChangYaService {

    @Override
    public Mp3Entry getMp3Url(String shareUrl) {
        try {
            Document doc = Jsoup.connect(shareUrl).get();
            Element element = doc.getElementById("__NEXT_DATA__");
            Node node = element.childNode(0);
            JSONObject jsonObject = JSONObject.parseObject(node.toString()).getJSONObject("props").getJSONObject("pageProps");
            String nickName = jsonObject.getJSONObject("singerUserInfo").getString("nickname");
            String songName = jsonObject.getJSONObject("clip").getString("songName");
            String songSrc = jsonObject.getJSONObject("clip").getString("audioSrc");
            return Mp3Entry.builder()
                    .singerNickName(nickName)
                    .songName(songName)
                    .songSrc(songSrc).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
