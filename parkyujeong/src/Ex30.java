public class Ex30 {public static void main(String[] args){

    int[][] mathScores = new int[2][3];
    for(int i=0; i<mathScores.length; i++){
        for(int k=0; k<mathScores[i].length; k++) {
            System.out.println("mathScores["+i+"]["+k+"]="+mathScores[i][k]);

        }

    }
    System.out.println();

    int[][] englisgScores = new int[2][];
    englisgScores[0] = new int[2];
    englisgScores[1] = new int[3];
    for(int i=0; i<englisgScores.length; i++) {
        for(int k=0; k<englisgScores[i].length; k++) {
            System.out.println("englisgScores["+i+"]["+k+"]=" +  englisgScores[i][k]);
        }

    }
    System.out.println();

    int[][] javaScores = {{95,80},{92,96,80}};
    for(int i=0; i<javaScores.length; i++){
        for(int k=0; k<javaScores[i].length; k++) {
            System.out.println("javaScores["+i+"]["+k+"]="+javaScores[i][k]);
        }
    }
}

    }
    