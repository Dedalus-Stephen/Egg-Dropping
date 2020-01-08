# EggDrop

![Falling Egg](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfrVBP8939KjAJHOCF1dMo_1mWUme6UNJXdo7uflAZdjiz0yl7&s)

## A classic Dynamic Programming problem.

### Statement:

Having N number of eggs and a (F number)-story building count the minimum number of trials (droppings) in worst case to determine from which floor it is safe to drop eggs.

### Solution idea:

*Let d(N, F) be the function to count the minimum number of trials for N eggs and F floors.*

We will build in a bottom-up manner a table (2D array) of size [N+1][F+1] that will the store the results of d(N, F) for all N(1...N) and for all F(0...F). The *table[N][F]* will have the result.

The array will be filled in the following way:


**Every time calculating d(n, x) we will start dropping eggs from the first floor up to current floor:**

Initialize current floor's result value as -Infinity. *table[n][x] = Integer.MIN_VALUE*

On every try we face one of the following cases:

Case(1): if egg breaks, then we are left with n-1 eggs and x-1 floors -> *table[n-1][x-1]*

Case(2): if egg doesn't break, then we are left with n eggs and J-x floors. (where J is a current floor we calculating value for) -> *table[n][J-x]*

Since we need the worst case scenario for the particular floor and yet the minimum number of trials we should take maximum of the two cases -> *res = max(case(1), case(2)) +1* and then minimum between current floor's value and result - > *min(res, table[n-1[x-1])*

