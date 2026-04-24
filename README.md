Life Hack or Urban Myth? — Android Quiz Application
📌 Project Overview
This project is a native Android application developed for a Varsity College assignment. The app serves as an interactive educational tool where users test their knowledge on various "Life Hacks" and "Urban Myths." By engaging with a series of flashcards, users learn which viral internet tips are actually useful and which ones are simply misinformation.
<img width="1914" height="1139" alt="image" src="https://github.com/user-attachments/assets/e5f03576-67d1-4cd6-ba5f-0af7ade91c22" />

The application follows the Native Android development standards, using Kotlin for logic and XML for user interface design.

🛠 Features & Functionality
1. User Experience (UX)
Intuitive Navigation: The app uses a single-activity architecture that swaps between three distinct logical screens (Welcome, Quiz, and Score) by managing view visibility.

Instant Feedback: Unlike traditional quizzes where you see results at the end, this app provides immediate explanations after every question, turning the quiz into a learning experience.

Personalized Results: The final score screen calculates your performance and provides a specialized message based on your total points.
<img width="1919" height="1100" alt="image" src="https://github.com/user-attachments/assets/5df3b7db-c6e2-452c-98b1-b206e30a3212" />

2. Application Logic
Dynamic Question Loading: The app utilizes arrays to store question strings, boolean answers, and technical explanations. A centralized loadQuestion() function updates the UI dynamically as the user progresses.

Score Management: A background counter tracks correct answers and compares the user's input against a pre-defined boolean array.

State Control: The logic prevents "double-voting" on questions by using an answered flag, ensuring the integrity of the final score.
<img width="1919" height="1140" alt="image" src="https://github.com/user-attachments/assets/2eeb01f3-7a37-4901-9c30-7a5bbbe13a1b" />

📂 Project Structure
MainActivity.kt: Contains the core logic, including view binding (findViewById), event listeners for buttons, and the quiz state management (indexing and scoring).

activity_main.xml: A comprehensive layout file that utilizes nested LinearLayout containers. It acts as the blueprint for all three screens of the app.

res/values/: Contains the strings, colors, and themes that define the visual brand of the application.

🚀 Technical Requirements & Installation
To run this project locally, you will need:

Android Studio Jellyfish (or newer).

JDK 17 or higher.

An Android Emulator or physical device running API 24 (Android 7.0) or above.

Installation Steps:
Clone the Repo: ```bash
git clone https://github.com/theboyaphile/IMAD_QUIZ.git

Open Project: Launch Android Studio and select "Open," then navigate to the cloned folder.

Sync Gradle: Allow the IDE to download the necessary dependencies.

Run: Press Shift + F10 to build and launch the app.

📚 Educational Credits
Developer: Aphile Nsuntsha

Module: IMAD (Introduction to Mobile Application Development)

Institution: Varsity College
