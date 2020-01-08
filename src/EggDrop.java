public class EggDrop {
    public static void main(String[] args) {
        //for simplicity we will have 2 eggs
        int eggs = 2;
        //and 6 floors
        int floors = 10;

        System.out.println("Minimum required number of trials with " + eggs + " eggs and " + floors + " floors is " + determine(eggs, floors));
    }

    private static int determine(int n, int f) {
        int[][] table = new int[n + 1][f + 1];

        //no matter how many floors we have, if we have only one egg then we need to do a linear search
        //i.e drop that one egg from every floor
        for (int i = 0; i <= f; i++) {
            table[1][i] = i;
        }

        //for one floor we always need one trial
        //and zero trials for zero floors
        for (int i = 0; i <= n; i++) {
            table[i][1] = 1;
            table[i][0] = 0;
        }

        //with 2 eggs and 6 floors; at this point table looks like this:
        //0 1 0 0 0 0 0
        //0 1 2 3 4 5 6
        //0 1 0 0 0 0 0


        //outer loop tracks number of eggs
        //first inner loop tracks floors.
        //second inner loop "drops eggs" from the first floor 'till the current floor (j)
        int result;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= f; j++) {
                table[i][j] = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    result = 1 + Math.max(table[i - 1][x - 1], table[i][j - x]);
                    table[i][j] = Math.min(table[i][j], result);
                }
            }
        }

        //with 2 eggs and 6 floors; at this point the state of table is:
        //0 1 0 0 0 0 0
        //0 1 2 3 4 5 6
        //0 1 2 2 3 3 (3) -> answer

        return table[n][f];
    }
}

//Complexity: O(n*(f*f))
