import styled from 'styled-components'

export const MainContainer = styled.div`
  display: flex;
  flex-direction: column;
  background-color: #111;
  min-height: 100vh;
  color: #fff;
  padding: 1.2em;
`
/* 헤더영역 */
export const Header = styled.header`
  display: flex;
  justify-content: space-between;
`
export const Logo = styled.span`
  font-family: 'HSGooltokki';
  font-size: 25px;
  color:red;

  &:hover {
    color: #fff;
    cursor: pointer
  }
`

/* 푸터영역 */
export const FooterText = styled.p`
  font-size: 12px;
  color:#999;
`

/* 메인 영역 */
export const Main = styled.main`
  flex:1;
`