void setup() {
  size(500, 500);
}

int rect_width = 200, rect_height = 100;
int x = 0, y = 0;
int dx = 5, dy = 5;

void draw() {
  background(255);
  fill(0, 0, 255);
  stroke(0, 0, 255);
  rect(x, y, rect_width, rect_height);
  
  if (x < 500 - rect_width && y == 0) {
    x = x + dx;
  }
  
  else if (x == 500 - rect_width && y < 500 - rect_height) {
    y = y + dy;
  }
  
  else if (x > 0 && y == 500 - rect_height) {
    x = x - dx;
  }
  
  else if (x == 0 && y > 0) {
    y = y - dy;
  }
}