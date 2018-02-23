public class StackOwn {
    int max = 1000;
    int a[] = new int[max];
    int top;


    StackOwn() {
        top = -1;
    }

    boolean push (int x) {
        if (top >= max) {
            System.out.println("Max size reached");
            return false;
        }
        else {
            a[++top] = x;
            return true;
        }
    }

    int pop () {
        if (top < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return a[top--];
        }
    }

    public static void main(String[] args) {
        StackOwn s = new StackOwn();
        s.push(1);
        System.out.println( s.pop() + " ");

    }

}
