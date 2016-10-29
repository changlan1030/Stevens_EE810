void setup() {
  size(800, 800);
}

int n = 4;  // or n = 8

void draw() {
  for (int i = 1; i < n; i++) {
    line(0, i * 800 / n, 800, i * 800 / n);
    line(i * 800 / n, 0, i * 800 / n, 800);
  }
}