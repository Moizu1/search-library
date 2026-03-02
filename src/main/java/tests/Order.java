package tests;

public class Order {
    private final int[] itemIds;      // sorted
    private final double[] prices;

    public Order(int[] itemIds, double[] prices) {
        this.itemIds = itemIds;
        this.prices = prices;
    }

    // Uses your binary search
    public int findItemIndex(int itemId) {
        return unittesting.binarySearch(itemIds, itemId);
    }

    // Decision-heavy method for CFG + all-path + MC/DC
    public double finalTotal(boolean isMember, boolean hasCoupon, boolean freeShipping, double shippingFee) {
        double subtotal = 0.0;
        for (double p : prices) {
            subtotal += p;
        }

        // Decision #1 (3 conditions)
        if ((isMember && hasCoupon) || subtotal > 100) {
            subtotal *= 0.90; // 10% discount
        }

        // Decision #2 (2 conditions)
        if (freeShipping || subtotal >= 50) {
            return subtotal;
        } else {
            return subtotal + shippingFee;
        }
    }
}