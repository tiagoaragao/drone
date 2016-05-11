package tiagojavaprogramador.drone.model;

import java.util.List;

/**
 * @author Tiago Alexandre Soares Aragão - tiagojavaprogramador@gmail.com -
 * http://tiagojavaprogramador.blogspot.com
 */
public class Video {

    private String idVideo;
    private String descVideo;
    private String linkVideo;
    private String linkDownVideo;
    private String urlImage;

    public Video() {
        this.idVideo = "";
        this.descVideo = "";
        this.linkVideo = "";
        this.linkDownVideo = "";
        this.urlImage = "";
    }


    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public String getDescVideo() {
        return descVideo;
    }

    public void setDescVideo(String descVideo) {
        this.descVideo = descVideo;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getLinkDownVideo() {
        return linkDownVideo;
    }

    public void setLinkDownVideo(String linkDownVideo) {
        this.linkDownVideo = linkDownVideo;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

}
