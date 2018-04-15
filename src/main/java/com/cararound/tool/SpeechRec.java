package com.cararound.tool;

import org.json.JSONObject;

import com.baidu.aip.speech.AipSpeech;

public class SpeechRec {
	public static final String APP_ID = "10591621";
    public static final String API_KEY = "nkqIUPOY16jRKIpFxWkBsxzK";
    public static final String SECRET_KEY = "9826ea1474a594813789462e2fec6965";
    private static AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

    public static String getStr(byte[] speech) {
        // 调用接口
        JSONObject res = client.asr(speech, "wav", 16000, null);
        return res.toString(2);
    }
}
