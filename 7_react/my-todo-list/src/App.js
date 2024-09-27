import { useState } from 'react';

import './App.css';
import InsertItem from './components/InsertItem';
import MyContainer from './components/MyContainer';
import TodoList from './components/TodoList';


function App() {
  // "샘플", "데이터"
  const [list, setList] = useState([{text:'샘플', complete: 'false'}, {text:'데이터', complete: 'false'}]);

  const addItem = (item) => {   // InsertItem 컴포넌트에서 추가될 데이터를 매개변수로 받아
                                // list 상태에 추가
    if (item !== '') {
      list.push({text:item, complete:'false'});
      setList([...list]);
    }

  }

  return (
    <div className="App">
      <MyContainer title="My TodoList">

        <InsertItem addItem={addItem}></InsertItem>
        <TodoList list={list} setList={setList}/>

      </MyContainer>
    </div>
  );
}

export default App;
