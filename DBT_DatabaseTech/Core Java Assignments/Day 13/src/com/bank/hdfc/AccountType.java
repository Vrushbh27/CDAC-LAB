package com.bank.hdfc;

public enum AccountType {
    CURRENT("Current Account"),
    SAVINGS("Savings Account");

    private final String displayName;

    // Constructor
    AccountType(String displayName) {
        this.displayName = displayName;
    }

    // Getter
    public String getDisplayName() {
        return displayName;
    }

    // For pretty printing
    @Override
    public String toString() {
        return displayName;
    }

    // Convert from user input safely
    public static AccountType fromString(String type) throws IllegalArgumentException {
        if (type == null) {
            throw new IllegalArgumentException("Account type cannot be null!");
        }
        switch (type.trim().toUpperCase()) {
            case "CURRENT":
                return CURRENT;
            case "SAVINGS":
                return SAVINGS;
            default:
                throw new IllegalArgumentException("Invalid account type! Allowed: CURRENT, SAVINGS");
        }
    }
}
