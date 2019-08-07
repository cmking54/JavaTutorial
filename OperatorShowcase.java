import java.util.Random;
public class OperatorShowcase {
    public void run_all_tests() {
        Operator[] operators = {new ArithmeticOperator(),
                                new AssignmentOperator(),
                                new ComparsionOperator(),
                                new LogicalOperator(),
                                new BitwiseOperator() };
        for (Operator operator: operators) {
            operator.run_tests();
        }
    }
    public static void main(String[] args) {}

    public abstract class Operator {
        protected int random_operand() {
            return new Random().nextInt(100); //can be anything really, I am choosing integers for simplicity
        }
        abstract void run_tests();
    }
    class ArithmeticOperator extends Operator {
        String[] symbols;
        public ArithmeticOperator() {
            symbols = new String[]{"+", "-", "*", "/", "%", "++", "--"};
        }
        private int addition_operator(int a, int b){ // basic example
            return a + b; // simply known as plus
        }
        private void addition_test() {
            System.out.println("\n======= ADDITION TEST ======");
            int operand_1 = random_operand();
            int operand_2 = random_operand();
            System.out.println(operand_1);
            System.out.println(operand_2);
            int sum_1 = 320 + 60;
            System.out.println(sum_1);
            int sum_2 = operand_1 + 201;
            System.out.println(sum_2);
            int sum_3 = operand_1 + operand_2;
            System.out.println(sum_3);
            System.out.println("===============================");
        }
        private int modulus_operator(int a, int b){
            return a % b; // "wraps around"
        }
        private void modulus_test() {
            System.out.println("\n====== MOD TEST ======");
            int operand_1 = random_operand();
            int operand_2 = random_operand();
            System.out.println(operand_1);
            System.out.println(operand_2);

            int result_1 = operand_1 % operand_2;
            System.out.println(result_1);
            int result_2 = 0 % 10;
            System.out.println(result_2);
            int result_3 = 10 % 1;
            System.out.println(result_3);
            System.out.println("===============================");
        }
        private int increment_operator(int a){
            return a++; // adds one, then replaces
        }
        private void increment_test() {
            System.out.println("\n====== INC TEST ======");
            int operand_1 = random_operand();
            System.out.println(operand_1);
            operand_1++;
            System.out.println(operand_1);
            int result_1 = operand_1++;
            System.out.println(operand_1);
            System.out.println(result_1);
            System.out.println("===============================");
        }
        public void run_tests() {
            addition_test();
            modulus_test();
            increment_test();
        }
    }
    class AssignmentOperator extends Operator {
        String[] symbols;
        public AssignmentOperator() {
            symbols = new String[]{"=", "+=", "-=", "*=", "/=", "%=", "&=", "|=", "^=", ">>=", "<<="};
        }
        private int assignment_operator(int a, int b){
            b = a;
            return b; // should replaces b entirely
        }
        private void assignment_test() {
            System.out.println("\n====== ASSIGN TEST ======");
            int operand_1 = random_operand();
            System.out.println(operand_1);

            int result_1 = 65;
            System.out.println(result_1);
            result_1 = operand_1;
            System.out.println(result_1);
            System.out.println("===============================");
        }
        public void run_tests() {
            assignment_test();
        }
    }
    class ComparsionOperator extends Operator {
        String[] symbols;
        public ComparsionOperator() {
            symbols = new String[]{"==", "!=", ">", "<", ">=", "<="};
        }
        private boolean equality_operator(int a, int b){
            return a == b; // tests if they are the same
        }
        private void equality_test() {
            System.out.println("\n====== COMP TEST ======");
            int operand_1 = random_operand();
            int operand_2 = random_operand();
            System.out.println(operand_1);
            System.out.println(operand_2);

            boolean result_1 = operand_1 == operand_2;
            System.out.println(result_1);
            boolean result_2 = 10 == 10;
            System.out.println(result_2);
            System.out.println("===============================");
        }
        public void run_tests() {
            equality_test();
        }
    }
    class LogicalOperator extends Operator {
        String[] symbols;
        public LogicalOperator() {
            symbols = new String[]{"&&", "||", "!"};
        }
        private boolean or_operator(boolean a, boolean b){
            return a || b; // if one is true, they eval to true
        }
        private void or_test() {
            System.out.println("\n====== OR TEST ======");
            int operand_1 = random_operand();
            int operand_2 = random_operand();
            System.out.println(operand_1);
            System.out.println(operand_2);

            boolean result_1 = (operand_1 == operand_2) || (10 != 11);
            System.out.println(result_1);
            System.out.println("===============================");
        }
        public void run_tests() {
            or_test();
        }
    }
    class BitwiseOperator extends Operator {
        String[] symbols;
        public BitwiseOperator() {
            symbols = new String[]{"&", "|", "<<", ">>"};
        } 
        private int bitwise_or_operator(int a, int b){
            return a | b; // if either bit is on/ is 1, it gets passed on
        }
        private void bitwise_test() {
            System.out.println("\n====== BITWISE ======");
            int operand_1 = 172; //10101100
            int operand_2 = 63; // 00111111

            int result_1 = operand_1 & operand_2; //44, 00101100
            System.out.println(result_1);
            int result_2 = operand_1 | operand_2; //191, 10111111
            System.out.println(result_2);
            int result_3 = operand_2 << 1; // 126, 01111110
            System.out.println(result_3);
            System.out.println("===============================");
        }
        public void run_tests() {
            bitwise_test();
        }
    }
}
