void setup() {
  for (int i = 0; i < 10; i++) {
    print(i);
    println();
  }
  
  for (int j = 1; j <= 99; j = j + 2) {
    print(j, "");
  }
  
  println();
  
  for (int k = 1; k <= 32768; k = k * 2) {
    print(k, "");
  }
  
  exit();
}