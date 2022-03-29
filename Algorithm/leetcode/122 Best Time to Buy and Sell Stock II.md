
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

 

Example 1:

```
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
```

Example 2:

```
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
```

Example 3:

```
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
```


Constraints:

- 1 <= prices.length <= 3 * 104
- 0 <= prices[i] <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



```c
/*
1) 每一天只能做一种操作买或者卖股票。
2) 我知道每一天股票的价格。
3) 在这两个条件下买卖股票。
*/

/*
我在第 i 天的持有或不持有股票，取决于前一天持有或不持有
*/

int maxProfit(int* prices, int pricesSize){
    int dp[pricesSize][2];
    dp[0][0]=0,dp[0][1]=-prices[0];
    for(int i=1;i<pricesSize;i++){
        dp[i][0]=fmax(dp[i-1][0],dp[i-1][1]+prices[i]);
        dp[i][1]=fmax(dp[i-1][1],dp[i-1][0]-prices[i]);
    }
    return dp[pricesSize-1][0];

}
```

```java
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp_0=0,dp_1=-prices[0];
        for(int i=1;i<n;i++){
            dp_0=Math.max(dp_0,dp_1+prices[i]);
            dp_1=Math.max(dp_1,dp_0-prices[i]);
        }
        return dp_0;

    }
}
```

