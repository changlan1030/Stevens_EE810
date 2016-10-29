void setup() {
  float sum1 = 0;  
  float sum2 = 0;
  for (int i = 1; i <= 100; i++) {
    sum1 += 1.0 / i;
  }
  for (int i = 100; i >= 1; i--) {
    sum2 += 1.0 / i;
  }
  println("sum(forward) =", sum1, ", sum(backward) =", sum2, ", difference =", sum1 - sum2);
  
  exit();
}