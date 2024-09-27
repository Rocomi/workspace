import styled from 'styled-components';

const AppContainer = styled.div`
    min-height: 100vh;
    display: flex;
    flex-direction: column;
    align-items: center;
`

const Container = styled.div`
    width: calc(100% - 25px);
    padding: 25px;
    display: inline-flex;
    flex-direction: column;
    justify-content: center;
`

const Title = styled.h1`
    color: blue;
    text-align: center;
    margin: 0;
    font-size: 50px;
    text-shadow: 0px 4px 6px black;
`

function MyContainer({children, title}) {
    return (
        <AppContainer>
            <Title>{title}</Title>
            <Container>
                {children}
            </Container>
        </AppContainer>
    )
}

export default MyContainer;