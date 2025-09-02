package br.com.mariojp.solid.ocp;

public class NoDiscountPolicy implements DiscountPolicy {
    public static final NoDiscountPolicy INSTANCE = new NoDiscountPolicy();
    private NoDiscountPolicy() {}
    @Override
    public double apply(double amount) {
        return amount; 
    }
}
