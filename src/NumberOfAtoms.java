import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Atom> stack = new Stack<>();
        Queue<Atom> queue = new LinkedList<>();
        int curIndex = 0;
        Atom flag = new Atom("", 0);
        while(curIndex < formula.length()){
            char curCh = formula.charAt(curIndex);
            if(curCh == '('){
                ++curIndex;
                stack.add(flag);
                continue;
            }
            if(curCh == ')'){
                String count = getNext(formula, curIndex + 1);
                curIndex += count.length() + 1;
                updateCountWithinParentheses(stack, queue, Integer.parseInt(count));
                continue;
            }
            String nameAndCount = getNext(formula, curIndex);
            stack.add(new Atom(nameAndCount));
            curIndex += nameAndCount.length();
        }
        Map<String, Integer> map = new HashMap<>();
        while(!stack.isEmpty()){
            Atom atom = stack.pop();
            if(map.containsKey(atom.name)){
                map.put(atom.name, atom.count + map.get(atom.name));
            }else{
                map.put(atom.name, atom.count);
            }
        }
        List<String> atomNames = new ArrayList<>(map.keySet());
        Collections.sort(atomNames);
        String result = "";
        for(String name : atomNames){
            result += name;
            int count = map.get(name);
            result += count == 1 ? "" : count;
        }
        return result;
    }

    private void updateCountWithinParentheses(Stack<Atom> stack, Queue<Atom> queue, int times){
        while(stack.peek().name != ""){
            Atom current = stack.pop();
            current.count *= times;
            queue.add(current);
        }
        stack.pop();//remove '('
        while(!queue.isEmpty()){
            stack.add(queue.poll());
        }
    }

    private String getNext(String formula, int curIndex){
        int endIndex = curIndex + 1;
        while(endIndex < formula.length()){
            char curCh = formula.charAt(endIndex);
            if(curCh >= 'A' && curCh <= 'Z' || curCh == '(' || curCh == ')'){
                break;
            }
            ++endIndex;
        }
        return formula.substring(curIndex, endIndex);
    }

    private class Atom{
        String name;
        int count;

        Atom(String name, int count){
            this.name = name;
            this.count = count;
        }

        Atom(String nameAndCount){
            int firstDigitIndex = nameAndCount.length();
            for(int i = 0; i < nameAndCount.length(); i++){
                char curCh = nameAndCount.charAt(i);
                if(curCh >= '1' && curCh <= '9'){
                    firstDigitIndex = i;
                    break;
                }
            }
            String name = nameAndCount.substring(0, firstDigitIndex);
            String countS = nameAndCount.substring(firstDigitIndex);
            int count = countS.equals("") ? 1 : Integer.parseInt(countS);
            this.name = name;
            this.count = count;
        }
    }
}
