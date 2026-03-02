package tests;

import static org.junit.Assert.*;
import org.junit.Test;

public class OrderTest {


    @Test
    public void path_discount_and_freeShipping() {
        Order o = new Order(new int[]{1,2,3}, new double[]{60, 60}); 
        double total = o.finalTotal(false, false, true, 10);
        assertEquals(108.0, total, 0.0001);
    }

    @Test
    public void path_discount_and_paidShipping() {
        Order o = new Order(new int[]{1}, new double[]{55}); 
        double total = o.finalTotal(true, true, false, 10);
        assertEquals(59.5, total, 0.0001);
    }

    @Test
    public void path_noDiscount_and_freeShippingBySubtotal() {
        Order o = new Order(new int[]{1}, new double[]{60}); 
        double total = o.finalTotal(false, false, false, 10);
        assertEquals(60.0, total, 0.0001);
    }

    @Test
    public void path_noDiscount_and_paidShipping() {
        Order o = new Order(new int[]{1}, new double[]{20}); 
        double total = o.finalTotal(false, false, false, 10);
        assertEquals(30.0, total, 0.0001);
    }

    

    @Test
    public void mcdc_toggleHasCoupon_changesDecision() {
        Order o = new Order(new int[]{1}, new double[]{80});

        double t1 = o.finalTotal(true, true, true, 10);
        double t2 = o.finalTotal(true, false, true, 10);

        assertEquals(72.0, t1, 0.0001); 
        assertEquals(80.0, t2, 0.0001);
    }

    @Test
    public void mcdc_toggleIsMember_changesDecision() {
        Order o = new Order(new int[]{1}, new double[]{80});

        double t1 = o.finalTotal(true, true, true, 10);
        double t2 = o.finalTotal(false, true, true, 10);

        assertEquals(72.0, t1, 0.0001);
        assertEquals(80.0, t2, 0.0001);
    }

    @Test
    public void mcdc_toggleSubtotalOver100_changesDecision() {
        Order o1 = new Order(new int[]{1}, new double[]{100}); 
        Order o2 = new Order(new int[]{1}, new double[]{101}); 

        double t1 = o1.finalTotal(false, false, true, 10); 
        double t2 = o2.finalTotal(false, false, true, 10); 

        assertEquals(100.0, t1, 0.0001);
        assertEquals(90.9, t2, 0.0001); 
    }
}