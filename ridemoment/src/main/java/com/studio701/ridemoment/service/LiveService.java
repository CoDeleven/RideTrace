/**
 *
 */
package com.studio701.ridemoment.service;

import com.studio701.ridemoment.pili.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ResourceBundle;


/**
 * @author CoDeleven
 */
@Service
public class LiveService {
    private static final ResourceBundle bundle = ResourceBundle.getBundle("live");
    private String accessKey = bundle.getString("accessKey");
    private String secretKey = bundle.getString("secretKey");
    private String streamKeyPrefix = bundle.getString("streamKeyPrefix");
    private String hubName = bundle.getString("hubName");
    private String apiHost = bundle.getString("apiHost");
    private String keyA;

    private Client cli;

    private static String printArrary(Object[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object a : arr) {
            sb.append(a.toString() + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    public String getReceiveURL() {
        initAndGetStream();

        String url = cli.RTMPPublishURL("live.soyask.top", hubName, keyA, 3600);
        System.out.printf("keyA=%s RTMP推流地址=%s\n", keyA, url);
        return url;
    }

    public String getDeliverURL() {
        initAndGetStream();

        //RTMP直播地址
        String url = cli.RTMPPlayURL("rtmp.soyask.top", hubName, keyA);
        System.out.printf("keyA=%s RTMP直播地址=%s\n", keyA, url);
        return url;
    }

    private Stream initAndGetStream() {
        if(cli == null){
            cli = new Client(accessKey, secretKey);
        }
        Config.APIHost = apiHost;

        //初始化Hub
        Hub hub = cli.newHub(hubName);

//        //获得不存在的流
        keyA = streamKeyPrefix;

        Stream streamA = null;
        try {
            streamA = hub.get(keyA);
        } catch (PiliException e) {
            e.printStackTrace();
        }
        System.out.printf("keyA=%s 查询: %s\n", keyA, streamA.toJson());
        return streamA;
    }
}
