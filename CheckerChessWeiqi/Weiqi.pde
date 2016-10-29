int turn = 0;
boolean[][] pos;

void setup() {
  size(1000, 1000);
  background(255);
  for (int i = 50; i <= 950; i += 50) {
    line(50, i, 950, i);
    line(i, 50, i, 950);
  }
  for (int i = 200; i <= 800; i += 300) {
    for (int j = 200; j <= 800; j += 300) {
      fill(0);
      ellipse(i, j, 10, 10);
    }
  }
  pos = new boolean[19][19];
  for (int i = 0; i < 19; i++) {
    for (int j = 0; j < 19; j++) {
      pos[i][j] = false;
    }
  }
}

void draw() {
}

void mouseClicked() {
  int x = (mouseX + 25) / 50;
  int y = (mouseY + 25) / 50;
  if (x >= 1 && x <= 19 && y >= 1 && y <= 19 && pos[x - 1][y - 1] == false) {
    if (turn % 2 == 0) {
      fill(0);
    }
    else {
      fill(255);
    }
    ellipse(x * 50, y * 50, 40, 40);
    turn++;
    pos[x - 1][y - 1] = true;
  }
}