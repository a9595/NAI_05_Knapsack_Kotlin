/**
 * Created by andrii.kovalchuk on 25/05/2017.
 */

object aa {

    class GreedyKnapsack(n: Int) {

        internal var profit: DoubleArray = DoubleArray(n)
        internal var weight: DoubleArray = DoubleArray(n)
        internal var take: DoubleArray = DoubleArray(n)

        init {
            for (i in 0..n - 1) {
                profit[i] = Math.round(Math.random() * 96 + 44).toInt().toDouble()
                weight[i] = Math.round(Math.random() * 89 + 15).toInt().toDouble()
            }
        }

        fun unitPriceOrder() {
            for (i in profit.indices) {
                for (j in 1..profit.size - i - 1) {
                    val x = profit[j - 1] / weight[j - 1]
                    val y = profit[j] / weight[j]
                    if (x <= y) {
                        val temp = profit[j - 1]
                        profit[j - 1] = profit[j]
                        profit[j] = temp

                        val temp1 = weight[j - 1]
                        weight[j - 1] = weight[j]
                        weight[j] = temp1
                    }
                }
            }
        }

        fun Knapsack(m: Int) {
            unitPriceOrder()
            var j: Int = 0
            while (j < profit.size) {
                take[j] = 0.0
                j++
            }
            var total = m.toDouble()
            j = 0
            while (j < profit.size) {
                if (weight[j] <= total) {
                    take[j] = 1.00
                    total -= weight[j]
                } else {
                    break// to exit the for-loop
                }
                j++
            }
        }

        fun print() {

            println("item" + " |  " + "profit" + "  |   " + "weight" +
                            "   |     " + "Unit Price" + "      |" + "  Take weight")
            for (n in profit.indices) {
                println(n.toString() + "\t" + profit[n] + "\t" + weight[n] + "\t"
                                + profit[n] / weight[n] + "\t" + take[n])
            }
        }
    }


    @JvmStatic fun main(args: Array<String>) {
        val knapsack = GreedyKnapsack(10)
        println("Optimal soluation to knapsack instance " + "with values given as follows : m=35")
        knapsack.Knapsack(35)
        knapsack.print()
        println("=======+============+=======+============+=" + "===========")
        println("Optimal soluation to knapsack instance with " + "values given as follows : m=120")
        knapsack.Knapsack(120)
        knapsack.print()
    }
}