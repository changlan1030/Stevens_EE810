void setup() {
  size(800, 800);
}

float dx = 2.5, dy = 1.5;
float r = 50;
float x = r, y = r;

void draw() {
  background(255);
  ellipse(x, y, 2 * r, 2 * r);
  fill(0, 0, 255);
  x += dx;
  y += dy;
  if (x < r || x >= width - r) {
    dx = -dx;
  }
  if (y < r || y >= height - r) {
    dy = -dy;
  }
}