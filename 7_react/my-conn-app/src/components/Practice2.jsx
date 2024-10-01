import { useState } from "react";
import { test5 } from "../services/testApi";
import styled from "styled-components";

const TableDeco = styled.div`
    display: inline-block;
    flex-direction: column;
    justify-content: center;
    padding: 10px;
`

const Practice2 = () => {
    
    const [list, setList] = useState([]);

    const testClick = async() => {
        const user = await test5();
        setList(user.data.msg);
    }

    return (
        <TableDeco>
            <br></br>
            <button onClick={testClick}>테스트</button>
            <table>
                <thead>
                    <tr>
                        <th>이름</th>
                        <th>나이</th>
                        <th>직업</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        list.map((data, index)=>{
                            return(
                            <tr key={index}>
                                <td>{data.name}</td>
                                <td>{data.age}</td>
                                <td>{data.job}</td>
                            </tr>
                            )
                        })
                    }
                </tbody>
            </table>
        </TableDeco>
    )
}
export default Practice2;