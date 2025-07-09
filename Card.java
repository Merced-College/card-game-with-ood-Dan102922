public class Card {
    // The suit of the card (e.g., "Hearts", "Spades")
    private String suit;
    // The rank of the card (e.g., "Ace", "2", "King")
    private String rank;
    // The numeric value of the card (e.g., 1 for Ace, 11 for Jack)
    private int value;
    // The picture associated with the card (e.g., file name or description)
    private String picture;

    // Default constructor
    public Card() {
        this.suit = "";
        this.rank = "";
        this.value = 1;
        this.picture = "";
    }

    // Parameterized constructor
    public Card(String suit, String rank, int value, String picture) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
        this.picture = picture;
    }

    // Copy constructor
    public Card(Card other) {
        this.suit = other.suit;
        this.rank = other.rank;
        this.value = other.value;
        this.picture = other.picture;
    }

    // Accessors (getters)
    public String getSuit() {
        return suit; // Returns the suit of the card
    }

    public String getRank() {
        return rank; // Returns the rank of the card
    }

    public int getValue() {
        return value; // Returns the value of the card
    }

    public String getPicture() {
        return picture; // Returns the picture string of the card
    }

    // Mutators (setters)
    public void setSuit(String suit) {
        this.suit = suit; // Sets the suit of the card
    }

    public void setRank(String rank) {
        this.rank = rank; // Sets the rank of the card
    }

    public void setValue(int value) {
        this.value = value; // Sets the value of the card
    }

    public void setPicture(String picture) {
        this.picture = picture; // Sets the picture string of the card
    }

    // toString method for displaying card information
    @Override
    public String toString() {
        return rank + " of " + suit + " (Value: " + value + ", Picture: " + picture + ")";
    }
    
    // equals method for comparing card suit and rank
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card)) return false;
        Card other = (Card) obj;
        return this.suit.equals(other.suit) && this.rank.equals(other.rank);
    }
}