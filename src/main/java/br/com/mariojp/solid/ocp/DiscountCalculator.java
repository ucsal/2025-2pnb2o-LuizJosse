package br.com.mariojp.solid.ocp;

import java.util.Map;
import java.util.Objects;

public class DiscountCalculator {

    private final Map<CustomerType, DiscountPolicy> policies;

    public DiscountCalculator() {
        this.policies = Map.of(
            CustomerType.REGULAR, new RegularPolicy(),
            CustomerType.PREMIUM, new PremiumPolicy(),
            CustomerType.PARTNER, new PartnerPolicy()
        );
    }

    public DiscountCalculator(Map<CustomerType, DiscountPolicy> policies) {
        this.policies = Objects.requireNonNull(policies, "policies must not be null");
    }

    public double apply(double amount, CustomerType type) {
        DiscountPolicy policy = policies.getOrDefault(type, NoDiscountPolicy.INSTANCE);
        return policy.apply(amount);
    }
}
