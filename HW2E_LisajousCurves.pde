void setup() {
  size(800, 800);
}

void draw() {
  translate(width/2, height/2);
  scale(width/2, -height/2);
  strokeWeight(0);
  float dt = PI / width / 10;
  for (float t = -2.0 * PI; t <= 2.0 * PI; t += dt) {
    float x = cos(13 * t);
    float y = cos(15 * t);
    point(x, y);
  }
}