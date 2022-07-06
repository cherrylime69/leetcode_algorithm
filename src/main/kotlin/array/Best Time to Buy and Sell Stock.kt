package array

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

fun main() {
    println(Best_Time_to_Buy_and_Sell_Stock().maxProfit(intArrayOf(7,6,4,3,1)))
}


class Best_Time_to_Buy_and_Sell_Stock {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0
        var minStock = prices[0]

        prices.forEach { currentPrice ->
            minStock = minOf(minStock, currentPrice)
            maxProfit = maxOf(maxProfit, currentPrice - minStock)
        }
        return maxProfit
    }
}
