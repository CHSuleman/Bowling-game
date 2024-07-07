# Bowling Game Scoring Application

This project is a Java application designed to calculate the score of a tenpins bowling game. The game consists of ten frames, where a player makes one or two attempts per frame to knock down ten pins arranged in a triangle. The scoring rules for strikes, spares, and open frames are implemented, and the scores accumulate through all ten frames.

## Rules of Bowling Scoring

1. **Strike**: 
    - If the bowler knocks down all ten pins on the first attempt of a frame, it's called a "strike."
    - The score for that frame is ten plus the number of pins knocked down on the next two rolls.

2. **Spare**: 
    - If the bowler knocks down all ten pins after two attempts in a frame, it's called a "spare."
    - The score for that frame is ten plus the number of pins knocked down on the next roll.

3. **Open Frame**: 
    - If the bowler fails to knock down all ten pins after two attempts in a frame, it's called an "open frame."
    - The score for that frame is the total number of pins knocked down in those two attempts.

4. **10th Frame Special Case**: 
    - In the 10th frame, if a strike or spare is rolled, the bowler gets additional rolls to complete the frame.
    - For a strike in the 10th frame, two more rolls are allowed.
    - For a spare in the 10th frame, one more roll is allowed.
    - The bonus rolls in the 10th frame count only towards the score of the 10th frame.

## Project Structure

- `BowlingGame.java`: Main class to run the game logic.
- `Frame.java`: Helper class to manage each frame's score and rolls.
- `BowlingGameTest.java`: Test class containing JUnit test cases.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Installation

1. Clone the repository:

   ```sh
   git clone https://github.com/yourusername/bowling-game.git
