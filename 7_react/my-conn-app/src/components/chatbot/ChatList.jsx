import styled from "styled-components";

const Container = styled.div`
    display: flex;
    flex-direction: column;
`

const MessageDiv = styled.div`
    float: right;
    text-align: right;
    border: 1px solid skyblue;
    box-shadow: 0px 0px 5px skyblue;
`
const ResponseDiv = styled.div`
    float: left;
    text-align: left;
    border: 1px solid red;
    box-shadow: 0px 0px 5px red;
`

const commonStyle = {
    borderRadius: '10px',
    padding: '8px',
    margin: '2px'
}
const ChatList = ({chatList, loading}) => {
    return(
        <Container>
            {
                chatList.map((chat, index)=>{
                    return(
                    <div key={index}>
                        <MessageDiv style={commonStyle}>{chat.message}</MessageDiv>
                        <br clear="both"/>
                        <ResponseDiv style={commonStyle}>{chat.response}</ResponseDiv>
                    </div>
                    )
                })
            }
            {
                loading &&
                <div>
                    챗봇이 답장을 고민하고 있습니다..
                </div>
            }
        </Container>
    )
}
export default ChatList;