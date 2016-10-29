void setup() {
  size(800, 600);
}

void draw() {
  translate(width/2, height/2);
  scale(width/2/2.0/PI, -height/2);
  strokeWeight(0);
  float dx = 4.0 * PI / width;
  for (float x = -2.0 * PI; x <= 2.0 * PI; x += dx) {
    float y = sin(x);
    point(x, y);
  }
}