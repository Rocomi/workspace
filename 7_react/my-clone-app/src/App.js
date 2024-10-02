import './App.css';
import './css/fonts.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import {Header, Logo, MainContainer, FooterText, Main} from './components/StyledComponents'
import MenuBar from './components/MenuBar';
import MainPage from './page/MainPage';


function App() {
  return (
    <BrowserRouter>
      <MainContainer>

        <Header>
          {/* 로고/ 메뉴/ 마이페이지 */}
          <Logo>RocoPlay</Logo>
          <MenuBar />
          MyPage
        </Header>
        <Main>
          {/* 메인 컨텐트 영역 */}
            <Routes>
              <Route path="/" element={<MainPage />} />
            </Routes>
        </Main>
        <footer>
          {/* 회사 정보 / 연락처 ... */}
          <FooterText><h2>RocoPlay 대한민국</h2></FooterText>
          <FooterText>RocoPlay Korea</FooterText>
          <FooterText>대표자 : Rocomi</FooterText>
          <FooterText>이메일 주소 : kauli1014@naver.com</FooterText>
          <FooterText>주소 : 서울 강남구 테헤란로 22길</FooterText>
        </footer>

      </MainContainer>
    </BrowserRouter>
  );
}

export default App;