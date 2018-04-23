package com.cararound.tool;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cararound.dao.RecognitionMapper;
import com.cararound.entity.Recognition;

@Component
public class SpeechMatch {

	@Autowired
	public RecognitionMapper recognitionMapper;

	public List<Recognition> recognitions;

	public String[] match(String speechStr) {
		if (recognitions == null) {
			recognitions = recognitionMapper.selectRecognition();
		}

		for (Recognition recognition : recognitions) {
			String pattern = recognition.getRegexPattern();

			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(speechStr);

			if (m.find()) {
				String[] result = new String[m.groupCount() + 1];
				result[0] = recognition.getCode();
				for (int i = 1; i <= m.groupCount(); i++) {
					result[i] = m.group(i);
				}
				return result;
			}
		}

		return null;
	}
}
