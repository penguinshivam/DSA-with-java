import java.util.Stack;

public class raintrapping {
    public static int trap(int height[]) {
        int n = height.length;
        int result = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? -1 : height[i];
            while (!s.isEmpty() && curr > height[s.peek()]) {
                int top = s.pop();
                if (s.isEmpty()) break;
                int distance = i - s.peek() - 1;
                int boundedHeight = Math.min(height[s.peek()], curr) - height[top];
                result =result +( distance * boundedHeight);
            }
            s.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {7,0,4,2,5,0,6,4,0,5};
        System.out.println(trap(height)); 
    }
}