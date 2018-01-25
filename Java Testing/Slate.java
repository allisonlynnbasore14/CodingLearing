import java.awt.*;
class Example {
// demonstrate simple use of the Slate class
public static void main (String[] args) {
int width = 500;
int height = 500;
Slate slate = new Slate (width, height);
Graphics g = slate.getSlateGraphics ();
g.setColor (Color.blue);
draw (g, 0, 0, width, height);
slate.repaint ();
anim (slate);
}
// draw demonstrates a recursive pattern
public static void draw (Graphics g, int x, int y, int width, int height) {
if (height < 3) return;
g.drawOval (x, y, width, height);
draw (g, x, y+height/2, width/2, height/2);274
Graphics
draw (g, x+width/2, y+height/2, width/2, height/2);
}
// anim demonstrates a simple animation
public static void anim (Slate slate) {
Graphics g = slate.image.getGraphics ();
g.setColor (Color.red);
for (int i=-100; i<500; i+=10) {
g.drawOval (i, 100, 100, 100);
slate.repaint ();
try {
Thread.sleep(10);
} catch (InterruptedException e) {}
}
}
}
class Slate extends Frame {
// image is a buffer: when Slate users draw things, they
// draw on the buffer. When the Slate gets painted, we
// copy the image onto the screen.
Image image;
public Slate (int width, int height) {
setBounds (100, 100, width, height);
setBackground (Color.white);
setVisible (true);
image = createImage (width, height);
}
// when a Slate user asks for a Graphics object, we give
// them one from the off-screen buffer.
public Graphics getSlateGraphics () {
return image.getGraphics ();
}
//
//
//
//
normally update erases the screen and invokes paint, but
since we are overwriting the whole screen anyway, it is
slightly faster to override update and avoid clearing the
screen
public void update (Graphics g) {
paint (g);D.6 The Slate Class
275
}
// paint copies the off-screen buffer onto the screen
public void paint (Graphics g) {
if (image == null) return;
g.drawImage (image, 0, 0, null);
}
}