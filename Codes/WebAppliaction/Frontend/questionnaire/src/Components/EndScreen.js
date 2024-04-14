import React, { useContext } from "react";
import { QuizContext } from "../Helpers/Contexts";
import '../App.css';

function EndScreen() {
    const { score, feedbackList, questions } = useContext(QuizContext);

    const renderFeedback = (questionId, generalFeedback, specificFeedback) => {
        const question = questions.find(question => question.questionId === questionId);
        const selectedAnswer = question ? question.answerWrappers.find(answer => answer.answerId === questionId) : null;

        return (
            <div key={questionId} className="feedback-item">
                <h3>Question {questionId}</h3>
                <p>{question.question}</p>
                <p>A. {question.answerWrappers[0].answerTitle}</p>
                <p>B. {question.answerWrappers[1].answerTitle}</p>
                <p>C. {question.answerWrappers[2].answerTitle}</p>
                <p>D. {question.answerWrappers[3].answerTitle}</p>
                <p>General Feedback: {generalFeedback}</p>
                <p>Specific Feedback: {specificFeedback}</p>
            </div>
        );
    };

    return (
        <div className="EndScreen">
            <h1>Quiz Finished</h1>
            <h2>Your Score: {score}</h2>
            <div className="feedback-list">
                {feedbackList.map(feedback => renderFeedback(feedback.questionId, feedback.generalFeedback, feedback.specificFeedback))}
            </div>
            <button>Play Game</button>
        </div>
    );
}

export default EndScreen;

