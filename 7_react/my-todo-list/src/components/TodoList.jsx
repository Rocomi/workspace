import { useState } from 'react';
import styled from 'styled-components';

const ListContainer = styled.ul`
    width: 100%;
    margin: 12px 0px;
    padding: 0px 30px;
`

const TodoItem = styled.li`
    height: 30px;
    background-color: lightblue;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-bottom: 2px;
    cursor:pointer;
`

const TodoData = styled.div`
    width:100%;
    color: #000;

    &.complete {
        text-decoration: line-through;
    }
`

const DeleteBtn = styled.button`
    width: 45px;
    height: 30px;
    border: none;
    cursor: pointer;
    border-radius: 50px;
    background-color: #f26;
    color: white;
    font-size: 18px;       
`
const CompleteBtn = styled.button`
    width: 45px;
    height: 30px;
    border: none;
    cursor: pointer;
    border-radius: 50px;
    background-color: #26f;
    color: white;
    font-size: 18px;  
    margin: 0px 10px; 
`

export default function TodoList({list, setList}) {

    function deleteData(index) {
        list.splice(index,1);
        setList([...list]);
    }

    function completeData(index) {
        if(list[index].complete === 'false'){
            list.splice(index,1,{text:list[index].text, complete:'true'});
            setList([...list]);
        } else {
            list.splice(index,1,{text:list[index].text, complete:'false'});
            setList([...list]);
        }       
    }

    return (
        <ListContainer>
            {
                list.map((todo, index)=>
                    <TodoItem key={'todo'+index}>
                        <TodoData className={todo.complete == 'true' ? 'complete':''}>{todo.text}</TodoData> 
                        <DeleteBtn onClick={() => deleteData(index)}>삭제</DeleteBtn> 
                        <CompleteBtn onClick={() => completeData(index)}>완료</CompleteBtn>
                    </TodoItem>
                )
            }
        </ListContainer>
    );
}