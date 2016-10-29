void setup() {
  size(800, 800);
}

void draw() {
  background(255);
  
  for (int i = 0; i < 800; i = i + 75) {
    for (int j = 0; j < 800; j = j + 75) {
      line(0, i, j, 0);
    }
  }
}