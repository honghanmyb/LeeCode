import java.util.Stack;

public class BasicCalculator {
	public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        operatorStack.add('+');
        int currentIndex = 0;
        int currentNum = 0;
        while(currentIndex < s.length()){
            char ch = s.charAt(currentIndex++);
            if(ch == ' '){
                continue;
            }
            
            if(ch <= '9' && ch >= '0'){
                currentNum = currentNum * 10 + ch - '0';
                continue;
            }
            if(ch == '+'){
                intStack.add(currentNum);
                currentNum = 0;
                operatorStack.add('+');
                continue;
            }
            if(ch == '-'){
                intStack.add(currentNum);
                currentNum = 0;
                operatorStack.add('-');
                continue;
            }
            if(ch == '('){
                operatorStack.add('(');
                operatorStack.add('+');
                continue;
            }
            
            if(ch == ')'){
                intStack.add(currentNum);
                currentNum = 0;
                int parenthesesResult = 0;
                while(operatorStack.peek() != '('){
                int popInt = intStack.pop();
                char popOperator = operatorStack.pop();
                    if(popOperator == '-'){
                        parenthesesResult -= popInt;
                    }else{
                        parenthesesResult += popInt;
                    }
                }
                operatorStack.pop();
                currentNum = parenthesesResult;
            }
        }
        intStack.add(currentNum);
        int result = 0;
        while(!intStack.isEmpty()){
            int popInt = intStack.pop();
            char popOperator = operatorStack.pop();
            if(popOperator == '-'){
                result -= popInt;
            }else{
                result += popInt;
            }
        }
        
        return result;
	}
}
