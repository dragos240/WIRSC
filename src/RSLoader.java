import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AppletStub;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class RSLoader extends JFrame
  implements AppletStub
{
  private static final HashMap<String, String> parameters = new HashMap();

  public RSLoader() {
    try {
      setResizable(true);
      setTitle("RSClient - Dragos240 (Based on GrimJava's RunescapeClient");
      setVisible(true);
      parameters.put("28", "");
      parameters.put("centerimage", "true");
      parameters.put("boxbgcolor", "black");
      parameters.put("image", "http://www.runescape.com/img/game/splash2.gif");
      parameters.put("boxborder", "false");
      parameters.put("java_arguments", "-Xmx256m -Xss2m -Dsun.java2d.noddraw=true -XX:CompileThreshold=1500 -Xincgc -XX:+UseConcMarkSweepGC -XX:+UseParNewGC");
      parameters.put("separate_jvm", "true");
      parameters.put("20", "196088521318718660");
      parameters.put("31", "0");
      parameters.put("24", "false");
      parameters.put("22", "false");
      parameters.put("9", "1104");
      parameters.put("30", "0");
      parameters.put("18", "wwGlrZHF5gKN6D3mDdihco3oPeYN2KFybL9hUUFqOvk");
      parameters.put("0", "HB09H8X*6XgR2aOiNsP6EA");
      parameters.put("5", "8");
      parameters.put("23", "");
      parameters.put("32", "-1391634031");
      parameters.put("3", "0");
      parameters.put("16", "0");
      parameters.put("29", "");
      parameters.put("7", "lobby5.runescape.com");
      parameters.put("11", "true,false,0,43,200,18,0,21,354,-15,Verdana,11,0xF4ECE9,candy_bar_middle.gif,candy_bar_back.gif,candy_bar_outline_left.gif,candy_bar_outline_right.gif,candy_bar_outline_top.gif,candy_bar_outline_bottom.gif,loadbar_body_left.gif,loadbar_body_right.gif,loadbar_body_fill.gif,6");
      parameters.put("26", "false");
      parameters.put("25", "");
      parameters.put("10", ".runescape.com");
      parameters.put("27", "false");
      parameters.put("33", "87JCmig8u1xN5A9THnbpoeM29dlc7X7S");
      parameters.put("1", "0");
      parameters.put("15", "false");
      parameters.put("8", "false");
      parameters.put("4", "225");
      parameters.put("13", "24974");
      parameters.put("2", "false");
      parameters.put("12", "false");
      parameters.put("-1", "0-TSt3NAEPw0guXP4vCjIg");
      parameters.put("6", "0");
      parameters.put("haveie6", "true");


      URLClassLoader localURLClassLoader = new URLClassLoader(new URL[] { new URL("http://world8.runescape.com/gamepack87JCmig8u1xN5A9THnbpoeM29dlc7X7S_4604971.jar") });

      Applet localApplet = (Applet)localURLClassLoader.loadClass("Rs2Applet").newInstance();
      localApplet.setStub(this);
      localApplet.init();
      localApplet.start();

      JPanel localJPanel = new JPanel(new BorderLayout());
      localJPanel.setPreferredSize(new Dimension(768, 560));
      setPreferredSize(new Dimension(768, 658));
      localJPanel.add(localApplet);
      getContentPane().add(localApplet, "Center");
      setDefaultCloseOperation(3);
      setSize(769, 538);
    } catch (Exception localException) {
      localException.printStackTrace();
    }
  }

  public void appletResize(int paramInt1, int paramInt2)
  {
  }

  public final URL getCodeBase() {
    try {
      return new URL("http://world8.runescape.com/"); } catch (Exception localException) {
    }
    return null;
  }

  public final URL getDocumentBase()
  {
    try {
      return new URL("http://world8.runescape.com/"); } catch (Exception localException) {
    }
    return null;
  }
  public final String getParameter(String paramString)
  {
    return (String)parameters.get(paramString);
  }

  public final AppletContext getAppletContext() {
    return null;
  }

  public static void main(String[] paramArrayOfString) {
    new RSLoader().setVisible(true);
  }
}

