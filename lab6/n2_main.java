package lab6;

public class n2_main {
    public static void main(String[] args) {
        n2_stack<Integer> stack = new n2_stack<>(10);
        stack.push(1); // добавление числа 1
        stack.push(2); // добавление числа 2
        stack.push(3);
        System.out.println(stack.pop()); // выводит и удаляет из стека последний добавленный элемент
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek()); // показывает верхушку стека, не изменяя его состояние
        stack.push(4);
        System.out.println(stack.pop()); // последний добавленный элемент теперь другой
    }
}
