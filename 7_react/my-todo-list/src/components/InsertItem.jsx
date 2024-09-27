import { useState } from 'react';
import styled from "styled-components";
import { IoAddCircleOutline } from "react-icons/io5";

const InsertInput = styled.input`
    border: none;
    border-radius: 50px 0px 0px 50px;
    background-color: lightblue;
    height: 40px;
    min-width: 250px;
    padding-left: 15px;
    box-sizing: border-box;
    outline: none;
    color:#000;
`

const InsertBtn = styled.button`
    width: 50px;
    height: 40px;
    border: none;
    cursor: pointer;
    border-radius: 0px 50px 50px 0px;
    background-color: black;
    color: white;
    font-size: 25px;  
    display: flex;
    justify-content: center;
    align-items: center;      
`
const InsertContainer = styled.div`
    width: 100%;
    display: inline-flex;
    justify-content: center;
    padding-bottom: 15px;
`
const Container = styled.div`
    width: 100%;
    display: inline-flex;
    justify-content: space-between;
    padding-bottom: 15px;
`

// function InsertItem() {}
const InsertItem = (props) => {
    const [todoItem, setTodoItem] = useState('');

    const addTodo = () => {
        props.addItem(todoItem);        // App 컴포넌트에서 setList todoItem
        setTodoItem('');
    }

    return (
        <Container>
            <InsertContainer>
                
                <InsertInput value={todoItem} placeholder='할일 입력' onChange={(e)=>{ setTodoItem(e.target.value); }} />
                <InsertBtn onClick={addTodo}>
                    <IoAddCircleOutline />
                </InsertBtn>

            </InsertContainer>
        </Container>
    )
}

export default InsertItem;