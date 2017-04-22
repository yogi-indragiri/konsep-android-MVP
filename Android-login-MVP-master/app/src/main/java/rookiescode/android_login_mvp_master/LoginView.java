package rookiescode.android_login_mvp_master;

/**
 * Created by muhammadyogiindragiri on 4/22/17.
 */

public interface LoginView {

    String getEmail();

    String getPassword();

    boolean validation();

    void successLogin();

    void errorLogin();

}
