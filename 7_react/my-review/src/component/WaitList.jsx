import { useEffect, useState } from "react";
import styled from "styled-components";

const Thead = styled.thead`
    background-color: #ccc;
`

const Tbody = styled.tbody`
    text-align: center;
`


const WaitList = () => {
    const [list, setList] = useState([
        {name:'아이유', num:10, phone: '010-1010-1010'},
        {name:'차은우', num:5, phone: '010-3030-3030'},
        {name:'카리나', num:3, phone: '010-7070-7070'}
    ])

    const [name, setName] = useState('');
    const [number, setNumber] = useState('');
    const [phone, setPhone] = useState('');

    const addWaiter = () => {
        if (!name ||!number ||!phone) 
            return alert('모든 항목을 입력하세요.')

        if (number < 1 ) 
            return alert('인원수를 확인하세요.')
        
        const newItem = [...list, { name: name, num: number, phone: phone }];
        setList(newItem);
        setName('');
        setNumber('');
        setPhone('');
    }

    // list 상태가 변경될때마다 실행(디버깅)
    // useEffect(()=>{
    //     console.log("************");
    //     console.log(list);
    //     console.log("************");
    // },[list])

    return(
        <div align="center">
            <h3>엘식당 대기 명단 표</h3>
            <table border={1}>
                <Thead>
                    <tr>
                        <th>이름</th>
                        <th>인원 수</th>
                        <th>연락처</th>
                    </tr>
                </Thead>
                <Tbody>
                    {
                        list.map((data, index)=>{
                            return(
                            <tr key={index}>
                                <td>{data.name}</td>
                                <td style={{color:data.num <= 3?"blue": data.num <= 5?"orange":"red"}}>{data.num}</td>
                                <td>📞{data.phone}</td>
                            </tr>
                            )
                        })
                    }   
                </Tbody>
            </table>
        <hr/>
        <h3>새 대기자 추가</h3>
            <div>
                <input type='text' placeholder='이름 입력' value={name} onChange={(e) => setName(e.target.value)}/>
                <input type='number' placeholder='인원 수 입력' value={number} onChange={(e) => setNumber(e.target.value)}/>
                <input type='phone' placeholder='연락처 입력' value={phone} onChange={(e) => setPhone(e.target.value)}/>
            </div>
            <br/>
            <button onClick={addWaiter}>등록</button> 
            <br/>
        </div> 
            

    )
}

export default WaitList;