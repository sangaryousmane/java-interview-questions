package oops.gradedActivity;

public class FinalExam extends GradedActivity{

    private int numQuestion;
    private int pointEach;
    private int missed;
    public FinalExam(int numQuestion, int pointEach, int missed){
        super(90);
        System.out.println("Hey there");
        this.numQuestion=numQuestion;
        this.pointEach=pointEach;
        this.missed=missed;
    }


    public int getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

    public int getPointEach() {
        return pointEach;
    }

    public void setPointEach(int pointEach) {
        this.pointEach = pointEach;
    }

    public boolean equals(GradedActivity g){
        return  this.getScore() == g.getScore();
    }
}
