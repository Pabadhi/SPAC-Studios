import React, {useContext} from "react";
import { QuizContext } from "../Helpers/Contexts";
import { useLocation, useNavigate } from 'react-router-dom'
import axios from 'axios'
import '../App.css';

export default function MainMenu() {
    const { setToken, setQuestions} = useContext(QuizContext);

    const location = useLocation()
    const queryString = new URLSearchParams(location.search)
    const jwtToken = queryString.get('jwtToken')
    const navigate = useNavigate();

    setToken(jwtToken)
    console.log(jwtToken)

    const url = 'http://localhost:8080/quiz/get'

    const sendRequest = () => {
        axios.get(url, {
            headers: {
                Authorization: `Bearer ${jwtToken}`
            }
        }).then(response => {
            console.log(response.data)
            setQuestions(response.data)
            navigate("/quiz")
        }).catch(error => {
            console.error(error)
        })
    }
    
    return (
        <div className="Menu">
            <button onClick={() => {
                sendRequest()
                }}>
                Start Quiz
            </button>
        </div>
    )
}