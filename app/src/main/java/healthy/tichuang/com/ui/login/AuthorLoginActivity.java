package healthy.tichuang.com.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import healthy.tichuang.com.Intents;
import healthy.tichuang.com.ui.base.BaseActivity;

/**
 * Created by punisher on 2017/3/1.
 */

public class AuthorLoginActivity  extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public static Intent createIntent(Context context) {
        return new Intents.Builder().setClass(context, AuthorLoginActivity.class).toIntent();
    }
}
