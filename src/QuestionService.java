import java.util.Scanner;
public class QuestionService {

    Question[] questions = new Question[5];
    String selection[] = new String[5];


    public QuestionService()
    {
        questions[0] = new Question(1, "size of int", "2", "6", "4", "8", "4");
        questions[1] = new Question(2, "size of double", "2", "6", "4", "8", "8");
        questions[2] = new Question(3, "size of char", "2", "6", "4", "8", "2");
        questions[3] = new Question(4, "size of long", "2", "6", "4", "8", "8");
        questions[4] = new Question(5, "size of boolean", "1", "2", "4", "8", "1");

    }
    /* Parameterised Constructor for creating object of type QuestionService class*/
    public QuestionService(int topic){

        if(topic==1){
            questions[0] = new Question(1, "What is the meaning of Telusko: ", "Get to know ", "Learn", "Knowledge", "Both 1 and 2", "4");
            questions[1] = new Question(2, "When was Telusko founded", "2010", "2014", "2020", "2019", "2");
            questions[2] = new Question(3, "How many children Navin Reddy has", "Two", "one", "Three", "None", "1");
            questions[3] = new Question(4, "What is Navin Reddy's fav word", "Aliens", "friends", "Apple", "youtube", "1");
            questions[4] = new Question(5, "What is Navin Reddy's Wife's name", "Kajol", "Kiran", "Reema", "Deepika", "2");
        }
        if(topic==2){
            questions[0] = new Question(1, "What is the extension of java code files?", ".js", ".txt", ".class", ".java", "4");
            questions[1] = new Question(2, "Which one of the following is not an access modifier?", "protected", "private", "void", "public", "3");
            questions[2] = new Question(3, "What is the return type of Constructors", "int", "float", "void", "none of the above", "4");
            questions[3] = new Question(4, "Which keyword is used by the method to refer to the object that invoked it?", "import", "catch", "abstract", "this", "4");
            questions[4] = new Question(5, "Which of the following statements are incorrect?", "String is a class", "Strings in java are mutable", "Every String is an object of class String", "None of the above", "2");
        }

    }
    /* Displays question for the player and reads the input and calculates the score */

    public void playQuiz(Player player)
    {
        int i=0;
        int score=0;
        //30 seconds timer for each question.
        long endTime=System.currentTimeMillis()+30000;

        String answer;
        for(Question q : questions){

            System.out.println("Question " + (i+1) + " : ");
            System.out.println(q.getId()+"."+q.getQuestion());
            System.out.println("1. "+q.getOpt1());
            System.out.println("2. "+q.getOpt2());
            System.out.println("3. "+q.getOpt3());
            System.out.println("4. "+q.getOpt4());
            System.out.println(" ");
            System.out.println("Do you want to skip this question?Please enter Y/N:  ");
            Scanner input = new Scanner(System.in);
                String skipScan= input.next();
            if(skipScan.equalsIgnoreCase("Y")){
                i++;
                continue;
            }
            System.out.println("Enter the right option:");
            selection[i] = input.next();

            answer=q.getAnswer();
            if(answer.equals( selection[i])){
                System.out.println("Correct Answer");
                score++;
            }
            else{
                System.out.println("Wrong answer!!!!");
                score--;
            }

            System.out.println("Your current score is : " + score+"/"+selection.length);
            i++;
            if(timeOut(endTime)==1){
                return;
            }

        }
        if(score==selection.length){
            System.out.println();
            System.out.println("Congratulations!!!!! "+player.getName());
            System.out.println("Your Final score is : " + score+"/"+selection.length);
        }
        else {
            System.out.println();
            System.out.println(player.getName() + " Your Final score is : " + score+"/"+selection.length);
        }
    }
    /*Checks for 30s time out for each question */
    public int timeOut(long endTime){
        int result=0;
        if(System.currentTimeMillis()>endTime){
            System.out.println("Timeout");
            result=1;
        }
        return result;
    }

}
