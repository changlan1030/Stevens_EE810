/*
the sqrt(6*sum) approximately equals to PI and backward is better
*/

void setup() {
  int n = 10000;  // n = 1, 10, 100, 1000, 10000
  float sum_forward = 0;
  float sum_backward = 0;
  for (int i = 1; i <= n; i++) {
    sum_forward += 1.0 / (i * i);
  }
  for (int i = n; i >= 1; i--) {
    sum_backward += 1.0 / (i * i);
  }
  println("n =", n);
  println("forward: sum =", sum_forward, ", sqrt(6*sum) =", sqrt(6 * sum_forward));
  println("backward: sum =", sum_backward, ", sqrt(6*sum) =", sqrt(6 * sum_backward));
  
  exit();
}