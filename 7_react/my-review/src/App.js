import './App.css';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import CurrentTime from './component/CurrentTime';
import { Menubar } from './component/Menubar';
import TextLength from './component/TextLength';


function App() {

  return (
    <BrowserRouter>
      <Menubar/>
      <main>
        <Routes>
          <Route path="/" element={''} />
          <Route path="/ct" element={<CurrentTime/>} />
          <Route path="/tl" element={<TextLength/>} />
        </Routes>
      </main>
    </BrowserRouter>
  );
}

export default App;
