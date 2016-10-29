PImage WPawn;
PImage BPawn;
PImage WRook;
PImage BRook;
PImage WKnight;
PImage BKnight;
PImage WBishop;
PImage BBishop;
PImage WQueen;
PImage BQueen;
PImage WKing;
PImage BKing;
PImage[][] Board;
PImage current;
int click = 1;

void setup() {
  size(800, 800);
  
  BKing = loadImage("BKing.png");
  BQueen = loadImage("BQueen.png");
  BRook = loadImage("BRook.png");
  BKnight = loadImage("BKnight.png");
  BBishop = loadImage("BBishop.png");
  BPawn = loadImage("BPawn.png");
  WKing = loadImage("WKing.png");
  WQueen = loadImage("WQueen.png");
  WRook = loadImage("WRook.png");
  WKnight = loadImage("WKnight.png");
  WBishop = loadImage("WBishop.png");
  WPawn = loadImage("WPawn.png");
  BKing.resize(100, 100);
  BQueen.resize(100, 100);
  BRook.resize(100, 100);
  BKnight.resize(100, 100);
  BBishop.resize(100, 100);
  BPawn.resize(100, 100);
  WKing.resize(100, 100);
  WQueen.resize(100, 100);
  WRook.resize(100, 100);
  WKnight.resize(100, 100);
  WBishop.resize(100, 100);
  WPawn.resize(100, 100);
  Board = new PImage[8][8];
  Board[0][0] = BRook;
  Board[0][1] = BKnight;
  Board[0][2] = BBishop;
  Board[0][3] = BQueen;
  Board[0][4] = BKing;
  Board[0][5] = BBishop;
  Board[0][6] = BKnight;
  Board[0][7] = BRook;
  Board[1][0] = BPawn;
  Board[1][1] = BPawn;
  Board[1][2] = BPawn;
  Board[1][3] = BPawn;
  Board[1][4] = BPawn;
  Board[1][5] = BPawn;
  Board[1][6] = BPawn;
  Board[1][7] = BPawn;
  Board[7][0] = WRook;
  Board[7][1] = WKnight;
  Board[7][2] = WBishop;
  Board[7][3] = WQueen;
  Board[7][4] = WKing;
  Board[7][5] = WBishop;
  Board[7][6] = WKnight;
  Board[7][7] = WRook;
  Board[6][0] = WPawn;
  Board[6][1] = WPawn;
  Board[6][2] = WPawn;
  Board[6][3] = WPawn;
  Board[6][4] = WPawn;
  Board[6][5] = WPawn;
  Board[6][6] = WPawn;
  Board[6][7] = WPawn;
}

void draw() {
  for (int i = 0; i <= 700; i += 100) {
    for (int j = 0; j <= 700; j += 100) {
      if ((i + j) % 200 == 0) {
        fill(200);
      }
      else {
        fill(55);
      }
      rect(i, j, 100, 100);
    }
  }
  
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
      if (Board[i][j] != null) {
        image(Board[i][j], j * 100, i * 100);
      }
    }
  }
}

void mouseClicked() {
  if (click == 1 && Board[mouseY/100][mouseX/100] != null) {
    current = Board[mouseY/100][mouseX/100];
    Board[mouseY/100][mouseX/100] = null;
    click = 2;
  }
  else if (click == 2) {
    Board[mouseY/100][mouseX/100] = current;
    click = 1;
  }
}