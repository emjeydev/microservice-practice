package dev.emjey.productservice.exception.enums;

public enum FriendlyMessageCodesEnum implements IFriendlyMessageCode {
    OK(1000);
    private final int value;

    FriendlyMessageCodesEnum(int value) {
        this.value = value;
    }

    @Override
    public int getFriendlyMessageCode() {
        return value;
    }
}
