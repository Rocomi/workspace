import './App.css';
import {BrowserRouter, Routes, Route, Link} from 'react-router-dom';
import styled from 'styled-components';
import Practice1 from './components/Practice1';
import Practice2 from './components/Practice2';
import MyChatbot from './components/chatbot/MyChatbot';

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

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <header>
          <nav>
            <MyLink to="/">Home</MyLink>
            <MyLink to="/pt1">연습1</MyLink>
            <MyLink to="/pt2">연습2</MyLink>
            <MyLink to="/chatbot">챗봇</MyLink>
          </nav>
        </header>
        <div>
          <Routes>
              <Route path="/" element={<p>안녕 리액트?!</p>}/>
              <Route path="/pt1" element={<Practice1 />} />
              <Route path="/pt2" element={<Practice2 />} />
              <Route path="/chatbot" element={<MyChatbot />} />
            </Routes>
        </div>
      </div>
    </BrowserRouter>
  );
}

export default App;
