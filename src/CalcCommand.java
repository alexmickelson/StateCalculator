public class CalcCommand {

    public CalcCommand(){

    }

    public CalcCommand(double num, String op){
        this.num = num;
        this.op = op;
    }
    public CalcCommand(double num){
        this.num = num;
    }
    double num;
    String op;

    @Override
    public String toString(){
        if (num%1 == 0){
            return  (int)num + " " + op + " " ;
        }
        return num + " " + op + " ";
    }
}
