public class test00 {
public static void main(String[] args){

   double[] scores={33,27,30,40,50,60,65,70,55,40,75};

   int sum = 0;
   for(int i=0; i<11; i++){
    sum += scores[i];
   }

   System.out.println("점수 총합:" + sum);
   double avg = (double)sum/10;
   System.out.println("점수 평균:" + avg);



 
int max = 75;
if(max<=90) {
 System.out.println("최고 점수: 75점");
}


}
}