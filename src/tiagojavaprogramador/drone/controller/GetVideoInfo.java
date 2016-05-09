package tiagojavaprogramador.drone.controller;

import tiagojavaprogramador.drone.command.CommandDownload;
import tiagojavaprogramador.drone.model.Video;

/**  @author Tiago Alexandre Soares Aragão 
 * tiagojavaprogramador@gmail.com  
 * http://tiagojavaprogramador.blogspot.com */

public class GetVideoInfo {

    private String url;
    
    //recebe url do youtube com id do video
    public GetVideoInfo(String url) {
        this.url = url;      
    }

    CommandDownload cmd;    
    Video video;
    
    
}
