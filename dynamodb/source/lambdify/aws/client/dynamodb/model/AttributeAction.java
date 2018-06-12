package lambdify.aws.client.dynamodb.model;

public enum AttributeAction {

    ADD("ADD"),
    PUT("PUT"),
    DELETE("DELETE");

    private String value;

    private AttributeAction(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Use this in place of valueOf.
     *
     * @param value
     *        real value
     * @return AttributeAction corresponding to the value
     */
    public static AttributeAction fromValue(String value) {
        if (value == null || "".equals(value)) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }

        for (AttributeAction enumEntry : AttributeAction.values()) {
            if (enumEntry.toString().equals(value)) {
                return enumEntry;
            }
        }

        throw new IllegalArgumentException("Cannot create enum from " + value + " value!");
    }
}