package com.example.service;

import com.example.exception.QuestionNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
    private final String[] questions = {
            "What is encapsulation in Java?",
            "How does inheritance work in Java?",
            "What is the difference between == and .equals()?",
            "How do I reverse a string in Java?",
            "What is polymorphism in object-oriented programming?",
            "What is the purpose of the main() method in Java?",
            "How do I handle exceptions in Java?",
            "What is a constructor and how is it used?",
            "What are access modifiers in Java?",
            "What is the difference between ArrayList and LinkedList?",
            "What is JSX in React?",
            "How do I use useState in React?",
            "What is the virtual DOM?",
            "How do I make an API call in React?",
            "How do I create a responsive navbar in React?",
            "What is REST API in Spring Boot?",
            "How do I set up a Spring Boot project?",
            "What is @RequestMapping used for?",
            "How do I handle errors in a REST API?",
            "How do I connect React frontend to a Spring Boot backend?",
            "What is the difference between GET and POST methods?",
            "What is npm and why is it used?",
            "What is the role of package.json?",
            "What is the difference between SQL and NoSQL?",
            "How do I deploy a full-stack web application?",
            "What is the capital of France?",
            "Tell me a fun fact about space.",
            "Who invented the internet?",
            "What is the tallest mountain in the world?",
            "Tell me a joke.",
            "What is the meaning of life?",
            "Give me a motivational quote.",
            "What is consciousness?",
            "Why do humans dream?",
            "What makes a person truly happy?"
    };

    private final String[] answers = {
            "Encapsulation wraps data and methods into a single unit and restricts access.",
            "Inheritance allows a class to inherit properties and methods from another class.",
            "== compares references; .equals() compares values.",
            "Use new StringBuilder(str).reverse().toString() to reverse a string.",
            "Polymorphism lets methods behave differently based on the object calling them.",
            "main() is the entry point of a Java application.",
            "Use try-catch blocks or custom exceptions to handle errors.",
            "A constructor initializes objects and has no return type.",
            "Access modifiers control visibility: public, private, protected, default.",
            "ArrayList uses dynamic arrays; LinkedList uses nodes.",
            "JSX lets you write HTML-like syntax in JavaScript.",
            "useState adds state to functional components.",
            "Virtual DOM is a lightweight copy of the real DOM used for efficient updates.",
            "Use fetch or axios to make API calls in React.",
            "Use Flexbox or Bootstrap for responsive navbars.",
            "REST API allows client-server communication via HTTP methods.",
            "Use Spring Initializr or add dependencies manually.",
            "@RequestMapping maps HTTP requests to controller methods.",
            "Use @ControllerAdvice and @ExceptionHandler for error handling.",
            "Enable CORS and use fetch/axios to connect frontend and backend.",
            "GET retrieves data; POST sends data to the server.",
            "npm manages JavaScript packages and dependencies.",
            "package.json defines project metadata and dependencies.",
            "SQL uses structured tables; NoSQL uses flexible formats like documents.",
            "Deploy using Heroku, Vercel, or AWS depending on your stack.",
            "Paris is the capital of France.",
            "Space is silent because sound needs a medium to travel.",
            "Tim Berners-Lee invented the World Wide Web.",
            "Mount Everest is the tallest mountain at 8,848 meters.",
            "Why did the computer go to therapy? It had too many unresolved issues!",
            "Life’s meaning varies—growth, purpose, and connection are common themes.",
            "\"Success is not final, failure is not fatal: It is the courage to continue that counts.\"",
            "Consciousness is awareness of self and surroundings.",
            "Dreams may help process emotions and consolidate memories.",
            "True happiness often comes from relationships, purpose, and growth."
    };
    public String getResponse(String question) throws QuestionNotFoundException {
        String normalizedInput = question.toLowerCase().trim();

        for (int i = 0; i < questions.length; i++) {
            String normalizedQuestion = questions[i].toLowerCase().trim();

            if (normalizedQuestion.equals(normalizedInput) ||
                    normalizedQuestion.contains(normalizedInput) ||
                    normalizedInput.contains(normalizedQuestion)) {
                return answers[i];
            }
        }

        throw new QuestionNotFoundException("Sorry! I couldn't find an answer. Try asking something else.");
    }



}
