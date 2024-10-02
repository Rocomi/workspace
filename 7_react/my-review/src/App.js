import './App.css';
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import CurrentTime from './component/CurrentTime';
import TextLength from './component/TextLength';
import Home from './component/Home';
import styled from 'styled-components';
import { createContext, useState } from 'react';
import StopWatch from './component/StopWatch';
import WaitList from './component/WaitList';

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

export const UserContext = createContext();
let defaultUser = {
  id: '',
  pwd:''
}
function App() {
  const[user, setUser] = useState(defaultUser);
  const defaultContext = {
    data: user,
    setData: setUser
  }

  return (
      <BrowserRouter>
        <div>
          <nav>
            <MyLink to="/">Home</MyLink>
            <MyLink to="/ct">타이머</MyLink>
            <MyLink to="/tl">글자 수 세기</MyLink>
            <MyLink to="/sw">스탑워치</MyLink>
            <MyLink to="/wl">대기명단</MyLink>
          </nav>
        </div>

        <UserContext.Provider value={defaultContext}>
          <main>
            <Routes>
              <Route path="/" element={<Home/>}/>
              <Route path="/ct" element={<CurrentTime/>} />
              <Route path="/tl" element={<TextLength/>} />
              <Route path="/sw" element={<StopWatch/>} />
              <Route path="/wl" element={<WaitList/>} />
            </Routes>
          </main>
        </UserContext.Provider>
      </BrowserRouter>
  );
}

export default App;
