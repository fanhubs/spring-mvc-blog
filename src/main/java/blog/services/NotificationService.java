package blog.services;

/**
 * Created by qiang on 18-7-7.
 */
public interface NotificationService {

    void addInforMessage(String msg);
    void addErrorMessage(String msg);

}
