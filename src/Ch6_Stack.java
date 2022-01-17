
public class Ch6_Stack {

    // Q.2
    /*public Object itemAt(int n) {
        E x;
        if (n < 0 || n > size()) throw new NoSuchElementException();

        ArrayStack<E> temp = new ArrayStack<E>();
        for (int i = 0; i < n; i++) {
            temp.push((E) pop());
        }
        x = (E) peek();
        while (!temp.isEmpty()) {
            this.push((E) temp.pop());
        }
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

        public static Boolean evaluate(String exp) {
            Stack<Integer> num = new Stack<>();
            Stack<Boolean> bool = new Stack<>();
            Stack<Character> opStack = new Stack<>();
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
                    next = ex.findInLine(CHARACTER);
                    c = next.charAt(0);
                    System.out.println("The character: " + c);
                    switch (c) {
                        case ')':
                            evaluateStackTops(opStack, num, bool);
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
                            opStack.push(c);
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

        private static boolean evalBoolean(int n1, int n2, char op) {
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

        private static void evaluateStackTops(Stack<Character> op, Stack<Integer> n, Stack<Boolean> b) {
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
                    b.push(evalBoolean(operand1, operand2, oper));
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

    }*/


    // Q. 6 // done
    /*public static double evaluatePostfix(String exp) {
        Stack<Double> numStack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ')
                continue;
            if (Character.isDigit(c)) {
                System.out.println(c);
                numStack.push(new Double(c));
            } else { //an operator is encountered
                System.out.println(numStack.peek());
                double operand2 = numStack.pop();
                double operand1 = numStack.pop();
                double result = evalArith(operand1, operand2, c);
                numStack.push(result);
            }
        }
        if (numStack.size() != 1) {
            throw new IllegalArgumentException("Invalid Expression");
        }
        return numStack.pop();
    }*/


    //Q.7 as part  //  done
    /*public static String convInToPostGen(String exp) { //this is for the case when the parenthesis need not to be fully
        Stack<Character> opStack = new Stack<Character>();
        String result = "";

        if (!isBalanced(exp))
            return "Not well formed";
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (c == ' ') continue;
            if (Character.isLetterOrDigit(c))
                result += c;
            else if (c == LEFT_NORMAL)
                opStack.push(c);
            else if (c == RIGHT_NORMAL) {
                while ((!opStack.isEmpty()) && (opStack.peek() != LEFT_NORMAL)) {
                    result += opStack.pop();
                }
                if (!opStack.isEmpty()) {
                    opStack.pop();
                }
            } else {
                while (!opStack.isEmpty() && (opStack.peek() != LEFT_NORMAL) && prec(c) <= prec(opStack.peek())) {
                    result += opStack.pop();
                }
                opStack.push(c);
            }
            System.out.println();
            System.out.print(result + "   ");
        }

        while (!opStack.isEmpty()) {
            if (opStack.peek() == LEFT_NORMAL) {
                System.out.println(opStack.peek());
                return "Invalid Expression";
            }
            result += opStack.pop();
        }
        return result;
    }*/


    //Q. 9  // NOT done
    /*public static double evaluateInfixGen(String exp) { //not full parenthesis
        Stack<Double> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        Scanner input = new Scanner(exp);
        String next;

        for(int i=0; i <exp.length(); i++){
            char c = exp.charAt(i);
            if(Character.isDigit(c)){
                int num = 0;     //if the number is not one digit
                while(Character.isDigit(c)){
                    num = num*10 + (c-'0');
                    i++;
                    if(i<exp.length()){
                        c=exp.charAt(i);
                    }else
                        break;
                }
                i--;
                numStack.push((double)num);
            }else if(c=='(')
                opStack.push(c);
            else if(c==')'){
                while(!opStack.isEmpty() ){
                    evaluateStackTops(numStack, opStack);
                }
                opStack.pop();
            }else{
                while(!opStack.isEmpty()&& opStack.peek()!='(' &&  prec(c)<=prec(opStack.peek())){
                    evaluateStackTops(numStack, opStack);
                }
                opStack.push(c);
            }
        }
        */
    /*while (input.hasNext()) {
            if (input.hasNext(UNSIGNED_DOUBLE)) {
                next = input.findInLine(UNSIGNED_DOUBLE);
                numStack.push(new Double(next));
            } else {
                next = input.next(CHARACTER);
                char c = next.charAt(0) ;
                switch (c) {
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        opStack.push(c);
                        break;
                    case ')':
                        evaluateStackTops(numStack, opStack);
                        break;
                    case '(':
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal character");
                }
            }
        }*//*
    if (numStack.size() != 1) {
            throw new IllegalArgumentException("Illegal input expression!");
        }
        return numStack.pop();
    }*/


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
