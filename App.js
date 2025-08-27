import React, { useState } from 'react';
import './App.css';

function App() {
    const [username, setUsername] = useState('');
    const [input, setInput] = useState('');
    const [chat, setChat] = useState([]);
    const [started, setStarted] = useState(false);

    const handleSend = async () => {
        if (!input.trim()) return;

        setChat(prev => [...prev, { sender: username, message: input }]);

        if (input.toLowerCase() === 'bye') {
            setChat(prev => [...prev, { sender: 'ChatBot', message: `Goodbye, ${username}!` }]);
            return;
        }

        try {
            const res = await fetch('http://localhost:8080/api', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ question: input })
            });
            const data = await res.text();
            setChat(prev => [...prev, { sender: 'ChatBot', message: data }]);
        } catch (err) {
            setChat(prev => [...prev, { sender: 'ChatBot', message: 'Error connecting to server.' }]);
        }

        setInput('');
    };

    const startChat = () => {
        if (username.trim()) setStarted(true);
    };

    return (
        <div className="App">
            {!started ? (
                <div className="username-box">
                    <h1 className="welcome-title">Welcome to ChatBot</h1>
                    <p className="welcome-subtext">
                        Your personal assistant for tech questions, fun facts, and thoughtful conversation.
                    </p>
                    <h2>Enter your name to begin</h2>
                    <input value={username} onChange={e => setUsername(e.target.value)} placeholder="Your name..." />
                    <button onClick={startChat}>Start Chat</button>
                </div>
            ) : (
                <div className="chat-box">
                    <h2>Hello {username}! Type 'Bye' to exit.</h2>
                    <div className="chat-window">
                        {chat.map((msg, idx) => (
                            <div key={idx} className={msg.sender === username ? 'user-msg' : 'bot-msg'}>
                                <strong>{msg.sender}:</strong> {msg.message}
                            </div>
                        ))}
                    </div>
                    <div className="input-area">
                        <input value={input} onChange={e => setInput(e.target.value)} onKeyDown={e => e.key === 'Enter' && handleSend()} />
                        <button onClick={handleSend}>Send</button>
                    </div>


                </div>
            )}
        </div>
    );
}

export default App;
