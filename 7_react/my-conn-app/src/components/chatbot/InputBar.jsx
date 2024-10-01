import styled from "styled-components";

const Container = styled.div`
    width: 95%;
    border: 1px dotted skyblue;
    padding: 15px;
    border-radius: 10px;
    height: 50px;
    margin: 0 auto;
    position: relative;
    box-shadow: 0px 0px 5px skyblue;
`

const MyInput = styled.input`
    border: none;
    outline: none;
    width: 100%;
    height: 100%;
`

const InputBar = ({message, changeMessage, sendMessage}) => {

    const handlerKeydown = (e) =>{
        if(e.keyCode === 13){
            sendMessage();
        }
    }
    return(
        <Container>
            <MyInput type="text" placeholder="대화ㅆ가능" value={message} 
            onChange={changeMessage}
            onKeyDown={handlerKeydown}/>
        </Container>
    )
}

export default InputBar;