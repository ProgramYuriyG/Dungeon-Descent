package GUI;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

public class Visuals{

    public static final int WIDTH = 1280, HEIGHT = 960;

    public static void BeginSession(){
        Display.setTitle("Dungeon Descent");
        try {
            Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        glMatrixMode(GL_PROJECTION);
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glLoadIdentity();


    }

    public static void DrawQuad(float x, float y, float width, float height){

        //makes a rectangle or square
        glBegin(GL_QUADS);
        glVertex2f(x,y);    //top left corner
        glVertex2f(x+width,y);    //top right corner
        glVertex2f(x+width,y+height);    //bottom right corner
        glVertex2f(x,y+height);    //bottom left corner
        glEnd();

    }

    public static void DrawLine(float x, float y, float length){
        //makes a line
        glBegin(GL_LINES);
        glVertex2f(x, y);
        glVertex2f(x+length, y+length);
        glEnd();
    }

    public static void DrawQuadTex(Texture tex, float x, float y, float width, float height){
        //binds texture
        tex.bind();
        //draws the quads based on translation
        glTranslatef(x, y, 0);
        glBegin(GL_QUADS);
        //top left
        glTexCoord2f(0,0);
        glVertex2f(0,0);
        //top right
        glTexCoord2f(1,0);
        glVertex2f(width,0);
        //bottom right
        glTexCoord2f(1,1);
        glVertex2f(width,height);
        //bottom left
        glTexCoord2f(0,1);
        glVertex2f(0,height);

        glEnd();
        glLoadIdentity();

    }

    public static Texture LoadTexture(String path, String fileType){

        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex = TextureLoader.getTexture(fileType, in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tex;
    }

    public static Texture QuickLoad(String name){
        Texture tex = null;
        tex = LoadTexture("Resources/"+ name + ".png", "PNG");
        return tex;
    }


}
