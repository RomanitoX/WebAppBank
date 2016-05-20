package Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@RequestScoped
public class ImagesView implements Serializable {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 10; i++) {
            images.add("avatar" + i + ".png");
        }
    }

    public List<String> getImages() {
        return images;
    }

    public void saveImage(ActionEvent event) {

    }
}
