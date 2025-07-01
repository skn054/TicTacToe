
# SOLID Design Tic-Tac-Toe in Java

This project is a command-line implementation of the classic Tic-Tac-Toe game, built in Java. The primary goal of this project was not just to create a functional game, but to serve as a practical exercise in applying **SOLID design principles** and common **software design patterns**.

## Features

-   Classic 3x3 Tic-Tac-Toe gameplay.
-   Play against a computer (AI) opponent.
-   The bot's intelligence is managed by a pluggable **Strategy Pattern**.
    -   **EasyPlayingStrategy**: The bot makes random valid moves.
-   The application automatically detects win, lose, and draw conditions.
-   Clean and interactive command-line interface.

## Design & Architecture

The architecture is the main highlight of this project, focusing on creating a system that is maintainable, scalable, and easy to understand.

### SOLID Principles

The project was built with the five SOLID principles in mind:

-   **[S] Single Responsibility Principle (SRP):** Each class has a single, well-defined purpose.
    -   `Board`: Manages the state of the game grid, including checking for valid moves and win conditions.
    -   `Player` (and its implementations `User` & `Bot`): Responsible for deciding on a move.
    -   `Game`: Orchestrates the game flow, manages turns, and interacts with the other components.
    -   `PlayingStrategy`: Encapsulates a single algorithm for a bot's move.

-   **[O] Open/Closed Principle (OCP):** The system is open for extension but closed for modification.
    -   This is best demonstrated by the **Strategy Pattern**. To add a new difficulty level (e.g., `HardPlayingStrategy`), we only need to create a new class that implements the `PlayingStrategy` interface. The `Bot` and `Game` classes do not need to be changed.

-   **[L] Liskov Substitution Principle (LSP):** Objects of a superclass are replaceable with objects of a subclass.
    -   The `Game` class works with a `List<Player>`. It can seamlessly handle a `User` object or a `Bot` object without changing its logic, as both are valid subtypes of `Player`.

-   **[I] Interface Segregation Principle (ISP):** Clients should not be forced to depend on interfaces they do not use.
    -   The `Player` and `PlayingStrategy` interfaces are lean and specific. `Player` only has `makeMove()`, which is all the `Game` needs to know.

-   **[D] Dependency Inversion Principle (DIP):** High-level modules depend on abstractions, not on concrete implementations.
    -   The `Game` class depends on the `Player` interface, not the concrete `User` or `Bot` classes.
    -   The `Bot` class depends on the `PlayingStrategy` interface, allowing the specific strategy (e.g., `EasyPlayingStrategy`) to be "injected" at runtime.

### Design Patterns Used

-   **Strategy Pattern:** This is the core pattern used for the bot's AI. It defines a family of algorithms (playing strategies), encapsulates each one, and makes them interchangeable. This allows the bot's behavior to be selected and changed independently from the bot itself.
-   **Model-View-Controller (MVC) - (Loose Adaptation):** The project structure loosely follows the MVC pattern.
    -   **Model:** The `models` package (`Board`, `Cell`, `Player`, `Symbol`) represents the application's data and business logic.
    -   **View:** The console output (`System.out.println`) serves as the view, responsible for presenting the game state to the user.
    -   **Controller:** The `Game` class, along with the input-handling logic in the `User` class, acts as the controller, taking user input and updating the model.

## Technology Stack

-   **Language:** Java 17
-   **Build Tool:** Apache Maven
-   **Dependencies:**
    -   [Lombok](https://projectlombok.org/): Used to reduce boilerplate code for getters, setters, and constructors in model classes.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

-   Java Development Kit (JDK) 17 or later.
-   Apache Maven.

### How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/your-repository-name.git
    cd your-repository-name
    ```

2.  **Build the project using Maven:**
    This command will compile the source code and download the necessary dependencies.
    ```bash
    mvn clean install
    ```

3.  **Run the application:**
    Use the Maven Exec Plugin to run the main class.
    ```bash
    mvn exec:java -Dexec.mainClass="com.example.Main"
    ```

You should now see the game running in your console. The user plays as 'X' and the bot plays as 'O'. Enter your move by typing the row and column numbers (e.g., `1 1` for the center cell).

## Project Structure

```
demo
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── example
                    ├── Main.java 	 // Application entry point
		    ├── Game.java            
                    ├── models                 // Core game models
                    │   ├── Board.java
                    │   ├── Bot.java
                    │   ├── Cell.java
                    │   ├── Player.java        // Player interface
                    │   ├── Symbol.java
                    │   └── User.java
                    └── strategy               // Bot's move logic strategies
                        ├── EasyPlayingStrategy.java
                        ├── MediumPlayingStrategy.java
                        └── PlayingStrategy.java // Strategy interface
```

## Future Improvements

-   **Implement `MediumPlayingStrategy`:** Add logic for the bot to check for an immediate winning move or to block an opponent's winning move.
-   **Implement `HardPlayingStrategy`:** Implement the Minimax algorithm for an unbeatable AI.
-   **Configurable Board Size:** Allow the user to choose a board size other than 3x3.
-   **Player vs. Player Mode:** Add an option for two human players to play against each other.
-   **Unit Tests:** Add a comprehensive suite of JUnit tests to ensure code quality and prevent regressions.