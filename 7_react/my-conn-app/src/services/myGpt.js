import axios from 'axios';

export const chatGo = async ({message}) => {
    const response = await axios.post("https://api.openai.com/v1/chat/completions",{
        "model": "gpt-4o-mini",
        "messages": [
            {
                "role": "user",
                "content": message
            },
            {
                "role": "system",
                "content": `You are a expert web page designer and need to make a perfect page using vsCode with HTML, CSS, js. 
                Answer with only codes and do not add any descirption or some other. 
                Logo has to be import later. Create logo position and write '(insert logo here)'.
                Header and footer must be contained.
                Each section have to contain texts more than 5 sentences.
                Each section have to be fully decorated with CSS, using latest trends.
                Use animation effect with JavaScript.
                Add css file in html, which has './test.css' path.
                Add js file in html, which has './test.js' path.
                Use images also, and file paths have to be './testImg/main.jpg' or './testImg/test.jpg', './testImg/test1.jpg'. 
                You can use one images multifly and also you can edit file with CSS. Please use image small size via CSS.
                HTML file must start with 'html:' and ends with '/htmlEnd'.
                CSS file must start with 'css:' and ends with '/cssEnd'.
                JS file must start with 'js:' and ends with '/jsEnd'.
                Content align would be centered.
                Do not use annotation.
                If you do a good job, I'll give you a $20 tip.
                Please answer in html and css, js. Please make page sincerely, and use everything you can.`
              }
        ],
        "temperature": 1,
        "max_tokens": 10000,
        "top_p": 1,
        "frequency_penalty": 0,
        "presence_penalty": 0
    }, {
        headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${process.env.REACT_APP_GPT_API_KEY}`
        }
    });

    console.log(response);
    return response.data.choices[0].message.content;
    
}