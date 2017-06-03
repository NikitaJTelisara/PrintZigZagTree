public class ZigZagTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        printZigZagTree(n1);
    }

    public static int getHeight(TreeNode n) {
        if (n != null) {
            int left = getHeight(n.left);
            int right = getHeight(n.right);
            return (Math.max(left, right) + 1);
        }
        return 0;
    }

    public static void printZigZagTree(TreeNode n) {
        int h = getHeight(n);
        boolean flag = true;
        for (int i = 1; i <= h; i++) {
            flag = (i % 2 == 0) ? false : true;
            print(n,i, flag);
        }
    }

    public static void print(TreeNode n, int level, boolean flag) {
        if (n == null) {
            return;
        }
        if (level == 1) {
            System.out.println(n.data);
        } else {
            if (flag == true) {
                print(n.right, level - 1, flag);
                print(n.left, level - 1, flag);
            }
            if (flag == false) {
                print(n.left, level - 1, flag);
                print(n.right, level - 1, flag);
            }
        }
    }
}