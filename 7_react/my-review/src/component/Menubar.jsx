import {Link} from 'react-router-dom';
import styled from 'styled-components';

//styled(컴포넌트명)`css...`
const MyLink = styled(Link)`
    background-color: #58f;
    color: #eee;
    margin: 10px;
    padding: 10px;
    text-decoration: none;
    border-radius: 2px 10px;

    &:hover {
        color: #58f;
        background-color: #eee;
    }
`

export const Menubar= () => {
    return(
        <nav>
          <MyLink to="/">Home</MyLink>
          <MyLink to="/ct">타이머</MyLink>
          <MyLink to="/tl">글자 수 세기</MyLink>
        </nav>
    )
}