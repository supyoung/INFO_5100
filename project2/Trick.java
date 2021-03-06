public class Trick extends GroupOfCards {
  private int winner;
  private Card winningCard;
  private boolean hearts = false;
  private boolean queen = false;

  public Trick(int players) {
    super(players * 2  - 1);
  }

  public int getWinner() {
    return this.winner;
  }

  public Card getWinningCard() {
    return this.winningCard;
  }

  public boolean getHearts() {
    return this.hearts;
  }

  public boolean getQueen() {
    return this.queen;
  }

  public void update(int playerNum, Card card) {
    this.addCard(card);
    if (isWinner(card) == true) {
      this.winner = playerNum;
      this.winningCard = card;

      if (card.getSuit() == 2) {
        this.hearts = true;
      }

      if (card.getSuit() == 3 && card.getNum() == 12) {
        this.queen = true;
      }
    }
  }

  private boolean isWinner(Card card) {
    if (this.winningCard == null) {
      return true;
    } else {
      if (card.getSuit() != this.winningCard.getSuit() || card.getNum() < this.winningCard.getNum()) {
        return false;
      } else {
        return true;
      }
    }
  }
}
