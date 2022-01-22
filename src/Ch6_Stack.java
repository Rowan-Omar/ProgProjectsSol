
public class Ch6_Stack {

    // Q.2
    /*public Object itemAt(int n) {
        E x;
        if (n < 0 || n > size()) throw new NoSuchElementException();

        /*LinkedStack<E> temp = new LinkedStack<E>();
        for (int i = 0; i < n; i++) {
            temp.push((E) pop());
        }
        x = (E) peek();
        while (!temp.isEmpty()) {
            this.push((E) temp.pop());
        }
        return x;//

        //OR
        if (n == 0 && !isEmpty()) {
            x = top.getData();
            return x;
        }
        Node<E> temp = top.getLink();
        int i = 1;
        while (temp != null && i < n) {
            temp = temp.getLink();
            i++;
        }

        if (temp != null)
            x = temp.getData();
        return x;
    }*/


    // Q.5 // done  but without the enhancement part
    /*class BooleanExpEval {
        static String expression; //the exp entered from the user
        public static final Pattern UNSIGNED_INT = Pattern.compile("\\d+.*?");
        public static final Pattern CHARACTER = Pattern.compile("\\S.*?");

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            //(((10>5)||(10>15))&&(15>=20))
            do {
                System.out.print("Enter your expression: ");
                expression = input.nextLine();
                evaluate(expression);
                try {
                } catch (Exception e) {
                    System.out.println("The stack is empty");
                }
            } while (Objects.equals(expression, "Exit")); //it is not looping
        }

        public static boolean evaluate(String exp) {
        Stack<Integer> num = new Stack<>();
        Stack<Boolean> bool = new Stack<>();
        Stack<Character> op = new Stack<>();
        exp = exp.replace(">=", "G");
        exp = exp.replace("<=", "L");
        exp = exp.replace("==", "E");
        exp = exp.replace("!=", "N");
        exp = exp.replace("||", "O");
        exp = exp.replace("&&", "A");
        Scanner ex = new Scanner(exp);
        String next;
        char c;
        while (ex.hasNext()) {
            if (ex.hasNext(UNSIGNED_INT)) {
                next = ex.findInLine(UNSIGNED_INT);
                System.out.println("the number pushed " + next);
                num.push(new Integer(next));
            } else {
                c = ex.findInLine(CHARACTER).charAt(0);
                System.out.println("The character: " + c);
                switch (c) {
                    case ')':
                        evalBoolStackTops(num, op, bool);
                        break;
                    case '(':
                        break;
                    case '<':
                    case 'L':
                    case '>':
                    case 'G':
                    case 'E':
                    case 'N':
                    case '!':
                    case 'A':
                    case 'O':
                        op.push(c);
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal operation");
                }
            }
        }
        if (bool.size() != 1) {
            throw new IllegalArgumentException("Illegal input expression");
        }
        System.out.println("the final result is: " + bool.peek());
        return bool.pop();
    }

        private static boolean evalBool(int n1, int n2, char op) {
            System.out.println("the numbers are: " + n1 + " , " + n2);
            switch (op) {
                case '<':
                    return (n1 < n2);
                case 'L':
                    return (n1 <= n2);
                case '>':
                    return (n1 > n2);
                case 'G':
                    return (n1 >= n2);
                case 'E':
                    return (n1 == n2);
                case 'N':
                    return (n1 != n2);
                default:
                    throw new IllegalArgumentException("Invalid comparison operation");
            }
        }

        private static void evalBoolStackTops(Stack<Integer> n, Stack<Character> op, Stack<Boolean> b) {
        if (op.size() < 1) throw new IllegalArgumentException();
        char oper = op.pop();
        System.out.println("the operation is: " + oper);
        switch (oper) {
            case '<':
            case 'L':
            case '>':
            case 'G':
            case 'E':
            case 'N': {
                if (n.size() < 2) throw new IllegalArgumentException("Illegal expression (num stack underflow)");
                int operand2 = n.pop();
                int operand1 = n.pop();
                b.push(evalBool(operand1, operand2, oper));
                break;
            }
            case '!': {
                if (b.size() < 1)
                    throw new IllegalArgumentException("Illegal expression (Booleans Stack Underflow)");
                b.push(!(b.pop()));
                break;
            }
            case 'A':
            case 'O': {
                if (b.size() < 2)
                    throw new IllegalArgumentException("Illegal expression (Booleans Stack Underflow)");
                boolean b2 = b.pop();
                boolean b1 = b.pop();
                if (oper == 'A')
                    b.push((b1 && b2));
                else
                    b.push((b1 || b2));
                break;
            }
            default:
                throw new IllegalArgumentException("Illegal operation (Unknown Character)");
        }
    }
*/


    // Q. 6 // done
    /*public static double evaluatePostfix(String exp) {
        Stack<Double> num = new Stack<>();
        Scanner inp = new Scanner(exp);
        String next;
        while (inp.hasNext()) {
            if (inp.hasNext(UNSIGNED_DOUBLE)) {
                next = inp.findInLine(UNSIGNED_DOUBLE);
                num.push(new Double(next));
            } else { //an operator is encountered
                char c = inp.findInLine(CHARACTER).charAt(0);
                if (num.size() < 2) throw new IllegalArgumentException("Illegal expression");
                double operand2 = num.pop();
                double operand1 = num.pop();
                num.push(evalArith(operand1, operand2, c));
            }
        }
        if (num.size() != 1) {
            throw new IllegalArgumentException("Invalid Expression");
        }
        return num.pop();
    }

    private static double evalArith(double num1, double num2, char op) {
        switch (op) {
            case '+':
                return (num1 + num2);
            case '-':
                return (num1 - num2);
            case '*':
                return (num1 * num2);
            case '/':
                return (num1 / num2);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }*/


    //Q.7  //  done
    /*public static String convInToPostGen(String exp) { //this is for the case when the parenthesis need not to be fully
        Stack<Character> op = new Stack<>();
        String result = "";
        Scanner inp = new Scanner(exp);

        while (inp.hasNext()) {
            if (inp.hasNext(UNSIGNED_DOUBLE)) {
                result += inp.findInLine(UNSIGNED_DOUBLE);
            } else {
                char c = inp.findInLine(CHARACTER).charAt(0);
                if (c == '(')
                    op.push(c);
                else if (Character.isLetter(c))
                    result += c;
                else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    while (!op.isEmpty() && op.peek() != '(' && prec(c) <= prec(op.peek()))
                        result += op.pop();

                    op.push(c);
                } else { // right parenthesis
                    while (!op.isEmpty() && op.peek() != '(')
                        result += op.pop();

                    if (op.isEmpty())
                        throw new IllegalArgumentException("Expression is unbalanced");
                    op.pop();
                }
            }
        }

        while (!op.isEmpty()) {
            if (op.peek() == '(')
                throw new IllegalArgumentException("Exp. did not have balanced paren");

            result += op.pop();
        }
        return result;
    }*/


    //Q. 9  // done //da brdo Q.4
    /*public static double evaluateInfixGen(String exp) { //not full parenthesis
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operations = new Stack<>();
        Scanner input = new Scanner(exp);
        String next;

        while (input.hasNext()) {
            if (input.hasNext(UNSIGNED_DOUBLE)) {
                next = input.findInLine(UNSIGNED_DOUBLE);
                numbers.push(new Double(next));
            } else {
                next = input.findInLine(CHARACTER);
                char ch = next.charAt(0);
                if (ch == '(') {
                    operations.push(ch);
                } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                    while (!operations.isEmpty() && operations.peek() != '(' && prec(ch) <= prec(operations.peek())) {
                        evaluateStackTops(numbers, operations);
                    }
                    operations.push(ch);
                } else { // it will be right parenthesis
                    while (!operations.isEmpty() && operations.peek() != '(') {
                        evaluateStackTops(numbers, operations);
                    }
                    if (!operations.isEmpty())
                        operations.pop();
                }
            }
        }
        //da 3lshan b3d 25er r9m bitdaf hwa bi5zno w bs keda mesh hid5ol tany y3ml evaluation
        if (numbers.size() == 2 && operations.size() == 1)
            evaluateStackTops(numbers, operations);

        if (numbers.size() != 1) {
            throw new IllegalArgumentException("Illegal input expression!");
        }
        return numbers.pop();
    }

    private static void evaluateStackTops(Stack<Double> numbers, Stack<Character> operations) {
        double operand1, operand2;
        if ((numbers.size() < 2) || operations.isEmpty()) {
            throw new IllegalArgumentException("Illegal expression");
        }
        operand2 = numbers.pop();
        operand1 = numbers.pop();
        switch (operations.pop()) {
            case '+':
                numbers.push(operand1 + operand2);
                break;
            case '-':
                numbers.push(operand1 - operand2);
                break;
            case '*':
                numbers.push(operand1 * operand2);
                break;
            case '/':
                numbers.push(operand1 / operand2);
                break;
            default:
                throw new IllegalArgumentException("Illegal operation");
        }
    }

    */


    //Q.12 // done
    /*public static <E> void displayTopBottom(LinkedStack<E> s) {
        if (s.isEmpty()) return;
        E x = s.pop();
        System.out.print(x + " ");
        displayTopBottom(s);
        s.push(x);

       /* //OR
       if (s.isEmpty()) return;
        Node<E> cursor = s.top;
        for(; cursor != null; cursor = cursor.getLink())
            System.out.print(cursor.getData() + " ");//
    }



    //Q. 12 // done
    public static <E> void displayBottomTop(LinkedStack<E> s) {
        if (s.isEmpty()) return;
        E x = s.pop();
        displayBottomTop(s);
        System.out.print(x + " ");
        s.push(x);

        //OR
        /*LinkedStack<E> temp = new LinkedStack<>();
        while (!s.isEmpty())
            temp.push(s.pop());

        while (!temp.isEmpty()) {
            E t = temp.pop();
            System.out.print(t + " ");
            s.push(t);
        }*/

    //Q.13  // done
   /* public static <E> boolean compareStacks(LinkedStack<E> s1, LinkedStack<E> s2) {
        if (s1 == null || s2 == null) return false;

        if (s1.isEmpty() && s2.isEmpty()) return true;

        if (s1.size() != s2.size()) return false;

        Node<E> ptr1 = s1.top, ptr2 = s2.top;

        while (ptr1 != null) {
            if (ptr1.getData() != ptr2.getData()) return false;
            ptr1 = ptr1.getLink();
            ptr2 = ptr2.getLink();
        }
        return true;
    }*/


    // Q.14 // done
    /*public static boolean palindrome(String exp) {
        LinkedStack<Character> s1 = new LinkedStack<>();
        LinkedStack<Character> temp;
        LinkedStack<Character> s2 = new LinkedStack<>();

        for (int i = 0; i < exp.length(); i++)
            s1.push(exp.charAt(i));
        temp = s1.clone();

        while (!temp.isEmpty())
            s2.push(temp.pop());

        return compareStacks(s1, s2);
    }*/


    //Q.15   //done
    /*public void flip() {
        LinkedStack<E> temp;
        temp = this.clone();
        while (!temp.isEmpty()) {
            E t = temp.pop();
            this.push(t);
        }
    }*/
}
