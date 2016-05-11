package tiagojavaprogramador.drone.string;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */

public class PtBr {

    private static String PATH = "";

    public static String getPATH() {
        PATH = "" + javax.swing.filechooser.FileSystemView.getFileSystemView().getHomeDirectory() + "/MyVideos";
        PATH = PATH.replace("/", "\\");
        return PATH;
    }

}
