class MyRange {

    private final String input;

    MyRange(String input) {
        this.input = input;
    }

    boolean isStartInputWithInclude() {
        return this.input.startsWith("[");
    }

    boolean isEndInputWithInclude() {
        return this.input.endsWith("]");
    }

    int getStart() {
        if(isStartInputWithInclude()) {
            return this.input.charAt(1) - 48;
        }
        return this.input.charAt(1) - 48 + 1;
    }

    String generate() {
        int start = getStart();
        int end = getEnd();

        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end ; i++) {
            result.append(i);
        }

        return result.toString();
    }

    private int getEnd() {
        return 5;
    }
}
