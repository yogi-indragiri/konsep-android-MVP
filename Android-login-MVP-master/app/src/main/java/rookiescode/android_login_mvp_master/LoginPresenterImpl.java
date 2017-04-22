package rookiescode.android_login_mvp_master;

/**
 * Created by muhammadyogiindragiri on 4/22/17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private final LoginView mView;

    public LoginPresenterImpl(LoginView view) {
        mView = view;
    }

    @Override
    public void login(String email, String password) {

        if (mView.validation()) {
            //Code Retrofit
            mView.successLogin();

        }
        else {
            mView.errorLogin();
        }

    }

}
