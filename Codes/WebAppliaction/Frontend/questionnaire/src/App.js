import './App.css';
import React from 'react';
import MainMenu from './Components/MainMenu';
import Quiz from './Components/Quiz';
import EndScreen from './Components/EndScreen';
import { QuizProvider} from './Helpers/Contexts';
import {BrowserRouter, Route, Routes} from 'react-router-dom'

function App() {
  //const [token, setToken] = useState("");
  //const [questions, setQuestions] = useState([]);

  return (
    <div className="App">
      <BrowserRouter>
        <h1>Questionnaire</h1>
      <QuizProvider>
        <Routes>
          <Route path ="/" element = {<MainMenu/>}></Route>
          <Route path ="/quiz" element = {<Quiz/>}></Route>
          <Route path ="/results" element = {<EndScreen/>}></Route>
        </Routes>
      </QuizProvider>
      </BrowserRouter>
    </div>
  );
}

export default App;
