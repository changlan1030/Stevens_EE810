void sierpinski(int x1, int y1, int x2, int y2, int x3, int y3, int level) {
  if (level <= 5 && level >= 1) {
    level++;
    sierpinski(x1, y1, (x1+x3)/2, (y1+y3)/2, (x2+x1)/2, (y2+y1)/2, level);
    sierpinski(x2, y2, (x2+x3)/2, (y2+y3)/2, (x2+x1)/2, (y2+y1)/2, level);
    sierpinski(x3, y3, (x1+x3)/2, (y1+y3)/2, (x2+x3)/2, (y2+y3)/2, level);
  }
  else {
    fill(0);
    triangle(x1, y1, x2, y2, x3, y3);
  }
}

int level = 1;

void setup() {
  size(800, 800);
  background(255);
  sierpinski(0, height-1, width-1, height-1, width/2, 0, level);
}

void draw() {
}