package oops.gradedActivity;

public class GradedActivity {

    private double score;

    public GradedActivity(double score) {
        this.score = score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public char getGrade() {
        char letterGrade;

        if (this.score >= 90)
            letterGrade = 'A';
        else if (this.score < 90 && this.score >= 80)
            letterGrade = 'B';
        else if (this.score < 80 && this.score >= 70)
            letterGrade = 'C';
        else if (this.score < 70 && this.score >= 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';
        return letterGrade;
    }

    @Override
    public String toString() {
        return "GradedActivity{" +
                "score=" + score +
                '}';
    }
}
