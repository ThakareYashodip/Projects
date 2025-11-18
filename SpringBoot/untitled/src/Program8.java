public class Program8 {

    public int fact(int num){
        if(num==0){
            return 1;
        }
        return num * fact(num-1);
    }

    public static void main(String[] args) {
        int num = 5;
        Program8 fact = new Program8();
        fact.fact(num);
    }
}
