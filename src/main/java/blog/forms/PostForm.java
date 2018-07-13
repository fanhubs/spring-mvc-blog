package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by qiang on 18-7-8.
 */
public class PostForm {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Size(min=2, max=30, message = "The username size should be in the range (2..30)")
    private String title;

    @NotNull
    @Size(min=1, max =50)
    private String body;

}
