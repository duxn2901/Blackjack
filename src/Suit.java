public enum Suit {
        SPADES("of Spades"),
        CLUBS("of Clubs"),
        DIAMONDS("of Diamonds"),
        HEARTS("of Hearts");

        private final String symbol;
        private Suit(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    
}
