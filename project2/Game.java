public class Game {
  final int PLAYERS;
  private Deck deck;
  private Hand[] players;
  private Trick[] tricks;
  private int numberOfTricks = 0;
  private boolean hearts = false;
  private boolean queenOfSpades = false;

  public Game(int numberOfPlayers) {
    this.PLAYERS = numberOfPlayers;
    this.players = new Hand[numberOfPlayers];
    for (int i=0; i< numberOfPlayers; i++) {
      this.players[i] = new Hand(i, 52/this.PLAYERS);
    }
    this.tricks = new Trick[52/this.PLAYERS];
  }

  public int getNumberOfTricks() {
    return this.numberOfTricks;
  }

  public boolean getHearts() {
    return this.hearts;
  }

  public boolean getQueenOfSpades() {
    return this.queenOfSpades;
  }

  public void playAGame() {
    deck = new Deck();
    int cardsLeft = 52 % this.PLAYERS;
    int playerNum;
    Card[] cardsLeft = new Card[];

    if (cardLeft > 0) {
      for (int i=0; i<cardLeft; i++) {
        cardsLeft.add(deck.removeCard(0));
      }
    }

    deck.shuffle();

    for (int i=0; i<this.tricks.length; i++) {
      for (int j=0; j<this.PLAYERS; j++) {
        this.players[j].addCard(deck.dealCard());
      }
    }

    for (int i=0; i<this.PLAYERS; i++) {
      this.players[i].sort();
      this.players[i].setShortest();

      System.out.println("player " + i + " shortest = " + this.players[i].getShortest());
      this.players[i].display();

      if (this.players[i].find(2, 0) > 0) {
        playerNum = i;
      }
    }

    for (int i=0; i<this.tricks.length; i++) {
      tricks[i] = new Trick(this.PLAYERS);
      this.numberOfTricks++;
      Card card;

      if (i == 0) {
        int index = 0;
        card = this.players[playerNum].removeCard(index);
        tricks[i].update(playerNum, card);
      } else {
        card = this.players[playerNum].playACard(this, this.tricks[i]);
      }

      System.out.print("player " + playerNum + "      ");
      card.display();

      for (int j=1; j < this.PLAYERS; j++) {
				playerNum = (playerNum + 1) % this.PLAYERS;
				card = this.players[playerNum].palyACard(this, this.tricks[i]);
				System.out.print("player " + playerNum + "      ");
				card.display();
			}

			playerNum = this.tricks[i].getWinner();

			if (i == 0) {
        for (Card card: cardsLeft) {
          System.out.print("undelt card     ");
          card.display();

          updateHeartsAndQueen(card);
        }
			}
			System.out.println();
    }

    for (int i=0; i<this.PLAYERS; i++) {
      System.out.println("players " + i + "  score = " + computePoints(i));
    }
  }

  public void updateHeartsAndQueen(Card card) {
    if (card.getSuit()==2 && this.hearts==false) {
      System.out.println("Hearts is now broken");
      this.hearts = ture;
    }
    if (card.getSuit()==3 && card.getNum()==12) {
      this.queenOfSpades = true;
    }
  }

  private int computePoints(int playerNum) {
    int sum = 0;

    for (int i=0; i<tricks.length; i++) {
      for (int j=0; j<tricks[i].getCurrentSize(); j++) {
        if (this.players[playerNum].Num==tricks[i].getWinner()) {
          if (tricks[i].getCard(j).getSuit()==2) {
            sum += 1;
          } else if (tricks[i].getCard(j).getSuit()==3 && tricks[i].getCard(j).getNum()==12) {
            sum += 13;
          }
        }
      }
    }
  }

}
