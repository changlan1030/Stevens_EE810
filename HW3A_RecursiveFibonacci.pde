int fibo(int n) {
  if (n == 1 || n == 2)
    return 1;
  return fibo(n - 1) + fibo (n - 2);
}

void setup() {
  println(fibo(10));
  println(fibo(20));
  println(fibo(30));
  
  exit();
}