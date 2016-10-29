int[][] Board;
int click = 1;
int current;

void setup() {
  size(800, 800);
  Board = new int[8][8];
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
      Board[i][j] = 0;
    }
  }
  Board[0][1] = 1;
  Board[0][3] = 1;
  Board[0][5] = 1;
  Board[0][7] = 1;
  Board[1][0] = 1;
  Board[1][2] = 1;
  Board[1][4] = 1;
  Board[1][6] = 1;
  Board[2][1] = 1;
  Board[2][3] = 1;
  Board[2][5] = 1;
  Board[2][7] = 1;
  Board[7][0] = 2;
  Board[7][2] = 2;
  Board[7][4] = 2;
  Board[7][6] = 2;
  Board[6][1] = 2;
  Board[6][3] = 2;
  Board[6][5] = 2;
  Board[6][7] = 2;
  Board[5][0] = 2;
  Board[5][2] = 2;
  Board[5][4] = 2;
  Board[5][6] = 2;
}

void draw() {
  for (int i = 0; i <= 700; i += 100) {
    for (int j = 0; j <= 700; j += 100) {
      if ((i + j) % 200 == 0) {
        fill(200, 150, 100);
      }
      else {
        fill(100, 70, 50);
      }
      rect(i, j, 100, 100);
    }
  }
  
  for (int i = 0; i < 8; i++) {
    for (int j = 0; j < 8; j++) {
      if (Board[i][j] == 1) {
        fill(0);
        ellipse(j * 100 + 50, i * 100 + 50, 80, 80);
      }
      if (Board[i][j] == 2) {
        fill(255, 0, 0);
        ellipse(j * 100 + 50, i * 100 + 50, 80, 80);
      }
    }
  }
}

void mouseClicked() {
  if (click == 1 && Board[mouseY/100][mouseX/100] != 0) {
    current = Board[mouseY/100][mouseX/100];
    Board[mouseY/100][mouseX/100] = 0;
    click = 2;
  }
  else if (click == 2 && Board[mouseY/100][mouseX/100] == 0 && (mouseY/100 + mouseX/100) % 2 == 1) {
    Board[mouseY/100][mouseX/100] = current;
    click = 1;
  }
}