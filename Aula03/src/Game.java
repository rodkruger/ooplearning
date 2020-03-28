public class Game {

    private int pins[] = new int[21];

    private int currentRoll = 0;

    public void roll(int pins) {
        this.pins[this.currentRoll] = pins;
        this.currentRoll++;
    }

    public int score() {
        int score = 0;
        int firstInFrame = 0;

        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(pins[firstInFrame])) {
                score += nextTwoBallForStrike(firstInFrame);
                firstInFrame++;
            } else if (isSpare(firstInFrame)) {
                score += nextBallForSpare(firstInFrame, 10, 2);
                firstInFrame += 2;
            } else {
                score += scoreInFrame(firstInFrame);
                firstInFrame += 2;
            }
        }

        return score;
    }

    private int scoreInFrame(int firstInFrame) {
        return pins[firstInFrame] + pins[firstInFrame + 1];
    }

    private int nextBallForSpare(int pin, int i, int i2) {
        return i + pins[pin + i2];
    }

    private int nextTwoBallForStrike(int firstInFrame) {
        return 10 + pins[firstInFrame + 1] + pins[firstInFrame + 2];
    }

    private boolean isStrike(int pin) {
        return pin == 10;
    }

    private boolean isSpare(int firstInFrame) {
        return pins[firstInFrame] + pins[firstInFrame + 1] == 10;
    }
}
