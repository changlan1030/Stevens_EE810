PShape planet;
PShape satellite;
void setup() {
  size(3000, 1000, OPENGL);
  noStroke();
  planet = createShape(SPHERE, 400);
  PImage earth = loadImage("earthmap1k.jpg"); 
  planet.setTexture(earth);
  satellite = createShape(SPHERE, 100);
  PImage moon = loadImage("moonmap4k.jpg"); 
  satellite.setTexture(moon);
}
float ang_earth = 0;
float ang_moon = 0;
float d_ang = 0.01;
void draw() {
  background(0);
  translate(width/2, height/2, -3000);
  pushMatrix();
  rotateY(ang_earth);
  shape(planet);
  popMatrix();
  pushMatrix();
  rotateY(ang_moon);
  shape(satellite, 3200, 0);
  popMatrix();
  ang_earth += d_ang * 28.5;
  ang_moon += d_ang;
}