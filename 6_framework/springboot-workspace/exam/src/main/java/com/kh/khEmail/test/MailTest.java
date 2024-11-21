package com.kh.khEmail.test;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class MailTest {
	

    public static String sendChatRequest(String message) {
        try {
            // API URL 설정
            URL url = new URL("");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 요청 헤더 설정
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + "");
            connection.setDoOutput(true);

            // JSON 요청 본문 생성
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("model", "gpt-4o-mini");

            JSONArray messages = new JSONArray();
            
            JSONObject userMessage = new JSONObject();
            userMessage.put("role", "user");
            userMessage.put("content", message);

            JSONObject systemMessage = new JSONObject();
            systemMessage.put("role", "system");
            systemMessage.put("content", "You are an expert web page designer and need to make a perfect page using VSCode with HTML, CSS, js in html code. "
                    + "Answer with only codes and do not add any description or other content like '```html' or '```'. "
                    + "Logo has to be import later. Create logo position and write '(insert logo here)'. "
                    + "Header and footer must be contained. "
                    + "Each section has to contain texts more than 5 sentences. "
                    + "Each section has to be fully decorated with CSS, using the latest trends. "
                    + "Use animation effects with JavaScript. "
                    + "Add CSS in HTML file using style tag. "
                    + "Add JS in HTML file using script tag. "
                    + "Use images also, and file paths have to be './testImg/main.jpg' or './testImg/test.jpg', './testImg/test1.jpg'. "
                    + "You can use one image multiple times, and also you can edit file with CSS. Please use image small size via CSS. "
                    + "Content alignment should be centered. "
                    + "Do not use annotations. "
                    + "If you do a good job, I'll give you a $20 tip. "
                    + "Please answer in HTML, CSS, and JS. Please make the page sincerely, and use everything you can.");

            messages.put(userMessage);
            messages.put(systemMessage);

            jsonBody.put("messages", messages);
            jsonBody.put("temperature", 1);
            jsonBody.put("max_tokens", 10000);
            jsonBody.put("top_p", 1);
            jsonBody.put("frequency_penalty", 0);
            jsonBody.put("presence_penalty", 0);

            // 요청 본문 전송
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.toString().getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // 응답 처리
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONArray choices = jsonResponse.getJSONArray("choices");
                return choices.getJSONObject(0).getJSONObject("message").getString("content");

            } else {
                System.out.println("Error in API request: " + responseCode);
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // 테스트 메시지
        String message = "Create a sample web page structure.";
        String response = sendChatRequest(message);
        System.out.println("Response from API:\n" + response);
    }

}
