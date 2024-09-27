import { Component } from 'react';
import Title from '../components/Title';
import CommentList from '../components/classComponent/CommentList';

class MyComponent extends Component {
    render() {
        return (
            <>
                <Title text="My Component"/>
            </>
        )
    }
}

function ClassComp() {
    return (
        <>
            <Title text="Class Component"/>
            <MyComponent/>

            <CommentList />
        </>
    )
}

export default ClassComp;